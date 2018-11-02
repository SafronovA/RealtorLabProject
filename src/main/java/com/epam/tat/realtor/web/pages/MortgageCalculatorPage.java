package com.epam.tat.realtor.web.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MortgageCalculatorPage extends BasePage {

    public MortgageCalculatorPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id='mc-home-price']")
    private WebElement homePriceInput;
    @FindBy(xpath = "//*[@id='mc-dp-amount']")
    private WebElement downPaymentInput;
    @FindBy(xpath = "//button[@data-id='mc-loanType']")
    private WebElement mortgageLoanTypeDropDown;
    @FindBy(xpath = "//a[@tabindex='0'][position()<8]")
    private List<WebElement> loanTypeOptionList;
    @FindBy(xpath = "//*[@id='mc-mortgage-rate']")
    private WebElement rateInput;
    @FindBy(xpath = "//*[@id='principal_interest']")
    private WebElement pricePerMonth;

    /**
     * get all possible loan type options
     *
     * @return list of loan type options
     */
    public List<WebElement> getLoanTypeOptionList() {
        return loanTypeOptionList;
    }

    /**
     * get price per month
     *
     * @return price per month
     */
    public String getPricePerMonth() {
        waitForJQueryIsLoad();
        return pricePerMonth.getText();
    }

    /**
     * set home price to home price input
     *
     * @param homePrice that will be set
     * @return this page
     */
    public MortgageCalculatorPage setHomePrice(String homePrice) {
        setValue(homePriceInput, homePrice);
        return this;
    }

    /**
     * set down payment to down payment input
     *
     * @param downPayment that will be set
     * @return this page
     */
    public MortgageCalculatorPage setDownPayment(String downPayment) {
        setValue(downPaymentInput, downPayment);
        downPaymentInput.sendKeys(Keys.ENTER);
        homePriceInput.click();
        return this;
    }

    /**
     * set rate to rate input
     *
     * @param rate that will be set
     * @return this page
     */
    public MortgageCalculatorPage setRateInput(String rate) {
        setValue(rateInput, rate);
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

    /**
     * delete text in field
     *
     * @param field which text will be delete in
     * @return this page
     */
    private MortgageCalculatorPage setValue(WebElement field, String value) {
        field.sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),value);
        return this;
    }

}