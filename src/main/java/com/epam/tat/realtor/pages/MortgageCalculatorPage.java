package com.epam.tat.realtor.pages;

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

    public List<WebElement> getLoanTypeOptionList() {
        return loanTypeOptionList;
    }

    public String getPricePerMonth() {
        return pricePerMonth.getText();
    }

    public MortgageCalculatorPage setHomePrice(String homePrice) {
        homePriceInput.sendKeys(homePrice);
        return this;
    }

    public MortgageCalculatorPage setDownPayment(String downPayment) {
        downPaymentInput.sendKeys(downPayment);
        downPaymentInput.sendKeys(Keys.ENTER);
        return this;
    }

    public MortgageCalculatorPage setRateInput(String rate) {
        rateInput.sendKeys(rate);
        return this;
    }

    public MortgageCalculatorPage clickMortgageLoanTypeDropDown() {
        mortgageLoanTypeDropDown.click();
        return this;
    }

    public MortgageCalculatorPage clearHomePriceInput() {
        homePriceInput.clear();
        return this;
    }

    public MortgageCalculatorPage clearDownPaymentInput() {
        downPaymentInput.clear();
        return this;
    }

    public MortgageCalculatorPage clearRateInput() {
        rateInput.clear();
        return this;
    }

}
