package com.epam.tat.realtor.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MortgageCalculatorPage extends BasePage {

    public MortgageCalculatorPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "com.move.realtor:id/home_price_input_box")
    private AndroidElement homePriceInput;
    @AndroidFindBy(id = "com.move.realtor:id/down_payment_input_box")
    private AndroidElement downPaymentInput;
    @AndroidFindBy(id = "com.move.realtor:id/mortgage_loan_type_input_box")
    private AndroidElement mortgageLoanTypeDropDown;
    @AndroidFindBy(className = "android.widget.TextView")
    private List<AndroidElement> loanTypeOptionList;
    @AndroidFindBy(id = "com.move.realtor:id/interest_rate_percentage_input_box")
    private AndroidElement rateInput;
    @AndroidFindBy(id = "com.move.realtor:id/principal_and_interest_price_and_logo")
    private AndroidElement pricePerMonth;
    @AndroidFindBy(id = "com.move.realtor:id/selector_dialog_ok_btn")
    private AndroidElement okButton;

    /**
     * get all possible loan type options
     *
     * @return list of loan type options
     */
    public List<AndroidElement> getLoanTypeOptionList() {
        return loanTypeOptionList;
    }

    /**
     * get price per month
     *
     * @return price per month
     */
    public String getPricePerMonth() {
        homePriceInput.click();
        rateInput.click();
        return pricePerMonth.getText();
    }

    /**
     * set home price to home price input
     *
     * @param homePrice that will be set
     * @return this page
     */
    public MortgageCalculatorPage setHomePrice(String homePrice) {
        homePriceInput.clear();
        homePriceInput.sendKeys(homePrice);
        return this;
    }

    /**
     * set down payment to down payment input
     *
     * @param downPayment that will be set
     * @return this page
     */
    public MortgageCalculatorPage setDownPayment(String downPayment) {
        downPaymentInput.clear();
        downPaymentInput.sendKeys(downPayment);
        return this;
    }

    /**
     * set rate to rate input
     *
     * @param rate that will be set
     * @return this page
     */
    public MortgageCalculatorPage setRate(String rate) {
        rateInput.clear();
        rateInput.sendKeys(rate);
        return this;
    }

    /**
     * click on mortgage loan type drop-down
     *
     * @return this page
     */
    public MortgageCalculatorPage clickMortgageLoanTypeDropDown() {
        mortgageLoanTypeDropDown.click();
        return this;
    }

    public MortgageCalculatorPage clickOkButton() {
        okButton.click();
        return this;
    }

}
