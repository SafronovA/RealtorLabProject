package com.epam.tat.realtor.pages;

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
    @FindBy(xpath = "//*[@id='mrtg-calc-monthly-payment']")
    private WebElement pricePerMonth;

    public List<WebElement> getLoanTypeOptionList() {
        return loanTypeOptionList;
    }

    public MortgageCalculatorPage setHomePrice(String homePrice){
        homePriceInput.clear();
        homePriceInput.sendKeys(homePrice);
        return this;
    }

    public MortgageCalculatorPage setDownPayment(String downPayment){
        downPaymentInput.clear();
        downPaymentInput.sendKeys(downPayment);
        return this;
    }

    public MortgageCalculatorPage clickMortgageLoanTypeDropDown(){
        mortgageLoanTypeDropDown.click();
        return this;
    }

    public String getPricePerMonth(){
        return pricePerMonth.getText();
    }

}
