package com.epam.tat.realtor.steps;

import com.epam.tat.realtor.pages.MortgageCalculatorPage;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.stream.Collectors;

public class MortgageCalculatorPageStep extends BasePageStep {
    private MortgageCalculatorPage mortgageCalculatorPage;

    public MortgageCalculatorPageStep(WebDriver driver) {
        super(driver);
        mortgageCalculatorPage = new MortgageCalculatorPage(driver);
    }

    public MortgageCalculatorPageStep setHomePrice(String homePrice){
        mortgageCalculatorPage.setHomePrice(homePrice);
        return this;
    }

    public MortgageCalculatorPageStep setDownPayment(String downPayment){
        mortgageCalculatorPage.setDownPayment(downPayment);
        return this;
    }

    public MortgageCalculatorPageStep selectLoanType(String loanType){
        mortgageCalculatorPage.clickMortgageLoanTypeDropDown();
        List<String> opt = mortgageCalculatorPage.getLoanTypeOptionList().stream().map(webElement -> webElement.getText()).collect(Collectors.toList());
        mortgageCalculatorPage.getLoanTypeOptionList().stream()
                .filter(element -> loanType.equals(element.getText()))
                .findFirst().get().click();
        return this;
    }

    public boolean isDisplayedPriceCorrect(){
        
    }

    private int calculateMortgagePricePerMonth(){

    }
}
