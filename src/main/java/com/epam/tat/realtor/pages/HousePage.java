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
    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.move.realtor:id/address_text_view']")
    private AndroidElement houseAddress;
    @AndroidFindBy(xpath = "(//android.widget.ImageButton)[3]")
    private AndroidElement goBackButton;

    public String getHouseAddress(){
        waitUntilElementIsVisible(houseAddress);
        return houseAddress.getText();
    }

    public ViewSearchResultsPage clickGoBackButton(){
        goBackButton.click();
        return new ViewSearchResultsPage(driver);
    }

    public List<AndroidElement> getEditMortgageCalculatorButton() {
        return editMortgageCalculatorButton;
    }

    public MortgageCalculatorPage clickEditMirtgageCalculatorButton() {
        editMortgageCalculatorButton.get(0).click();
        return new MortgageCalculatorPage(driver);
    }
}
