package com.epam.tat.realtor.steps;

import com.epam.tat.realtor.pages.MortgageCalculatorPage;
import com.epam.tat.realtor.util.Parser;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.stream.Collectors;

public class MortgageCalculatorPageStep extends BasePageStep {
    private MortgageCalculatorPage mortgageCalculatorPage;

    public MortgageCalculatorPageStep(WebDriver driver) {
        super(driver);
        mortgageCalculatorPage = new MortgageCalculatorPage(driver);
    }

    /**
     * set home price to home price input
     *
     * @param homePrice that will be set
     * @return MortgageCalculatorPageStep
     */
    public MortgageCalculatorPageStep setHomePrice(String homePrice) {
        mortgageCalculatorPage.setHomePrice(homePrice);
        return this;
    }

    /**
     * set down payment to down payment input
     *
     * @param downPayment that will be set
     * @return MortgageCalculatorPageStep
     */
    public MortgageCalculatorPageStep setDownPayment(String downPayment) {
        mortgageCalculatorPage.setDownPayment(downPayment);
        return this;
    }

    /**
     * set rate to rate input
     *
     * @param rate that will be set
     * @return MortgageCalculatorPageStep
     */
    public MortgageCalculatorPageStep setRate(String rate) {
        mortgageCalculatorPage.setRateInput(rate);
        return this;
    }

    /**
     * click on mortgage loan type drop-down and select loan type according to parameter
     *
     * @param loanType will be set
     * @return MortgageCalculatorPageStep
     */
    public MortgageCalculatorPageStep selectLoanType(String loanType) {
        mortgageCalculatorPage.clickMortgageLoanTypeDropDown();
        mortgageCalculatorPage.getLoanTypeOptionList().stream()
                .filter(element -> !element.getText().equals(""))
                .filter(element -> loanType.equals(element.getText()))
                .findFirst().get().click();
        return this;
    }

    /**
     * check that price calculated by web site is correct
     *
     * @param homePrice input parameter to calculator
     * @param downPayment input parameter to calculator
     * @param rate input parameter to calculator
     * @param loanType input parameter to calculator
     * @return true, if displayed price is correct, return false, if it is not
     */
    public boolean isDisplayedPriceCorrect(String homePrice,
                                           String downPayment,
                                           String rate,
                                           String loanType) {
        boolean result = Parser.parse(mortgageCalculatorPage.getPricePerMonth())
                == calculateMortgagePricePerMonth(homePrice, downPayment, rate, loanType);
        return result;
    }

    /**
     * calculate monthly payment for input parameters by formula
     * calculate money which left to pay(Home price - Down payment)
     * calculate rate (input rate divide on month per year)
     * calculate all necessary payment(multiply month per year on year in loan type)
     * calculate monthly payment
     *
     * @param homePrice input parameter to calculator
     * @param downPayment input parameter to calculator
     * @param rate input parameter to calculator
     * @param loanType input parameter to calculator
     * @return monthly payment
     */
    private static int calculateMortgagePricePerMonth(String homePrice,
                                               String downPayment,
                                               String rate,
                                               String loanType) {
        int monthInYear = 12;
        int percent = 100;
        int moneyLeftToPay = Integer.valueOf(homePrice) - Integer.valueOf(downPayment);
        double rateInt = (Double.valueOf(rate)/percent)/monthInYear;
        int allPaymentCount = monthInYear * Parser.parse(loanType);
        double paymentPerMonth = moneyLeftToPay * (rateInt * Math.pow(1 + rateInt, allPaymentCount)) / (Math.pow((1 + rateInt), allPaymentCount) - 1);
        return (int)Math.round(paymentPerMonth);
    }
}
