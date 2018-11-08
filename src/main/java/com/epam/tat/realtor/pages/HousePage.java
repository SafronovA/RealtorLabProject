package com.epam.tat.realtor.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HousePage extends BasePage {

    public HousePage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "com.move.realtor:id/button_calculate")
    private List<AndroidElement> editMortgageCalculatorButton;

    public List<AndroidElement> getEditMortgageCalculatorButton(){
        return editMortgageCalculatorButton;
    }

    public MortgageCalculatorPage clickEditMirtgageCalculatorButton(){
        editMortgageCalculatorButton.get(0).click();
        return new MortgageCalculatorPage(driver);
    }
}
