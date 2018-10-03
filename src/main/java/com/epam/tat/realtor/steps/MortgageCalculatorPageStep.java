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

    public MortgageCalculatorPageStep setHomePrice(String homePrice) {
        mortgageCalculatorPage.clearHomePriceInput()
                .setHomePrice(homePrice);
        return this;
    }

    public MortgageCalculatorPageStep setDownPayment(String downPayment) {
        mortgageCalculatorPage.clearDownPaymentInput()
                .setDownPayment(downPayment);
        return this;
    }

    public MortgageCalculatorPageStep setRate(String downPayment) {
        mortgageCalculatorPage.clearRateInput()
                .setRateInput(downPayment);
        return this;
    }

    public MortgageCalculatorPageStep selectLoanType(String loanType) {
        mortgageCalculatorPage.clickMortgageLoanTypeDropDown();
        mortgageCalculatorPage.getLoanTypeOptionList().stream()
                .filter(element -> !element.getText().equals(""))
                .filter(element -> loanType.equals(element.getText()))
                .findFirst().get().click();
        return this;
    }

    public boolean isDisplayedPriceCorrect(String homePrice,
                                           String downPayment,
                                           String rate,
                                           String loanType) {
        boolean result = Parser.parse(mortgageCalculatorPage.getPricePerMonth())
                == calculateMortgagePricePerMonth(homePrice,downPayment, rate, loanType);
        return result;
    }

    private int calculateMortgagePricePerMonth(String homePrice,
                                               String downPayment,
                                               String rate,
                                               String loanType) {
        int moneyLeftToPay = Integer.valueOf(homePrice) - Integer.valueOf(downPayment);
        int allPaymentCount = Integer.valueOf(rate)*Parser.parse(loanType);
        int rateInt = Integer.valueOf(rate);
        double paymentPerMonth = moneyLeftToPay*((rateInt*Math.pow(1+rateInt,allPaymentCount))/(Math.pow((1+rateInt),allPaymentCount))-1);
        return (int)paymentPerMonth;
    }
}
