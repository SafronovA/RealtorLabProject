package com.epam.tat.realtor.steps;

import com.epam.tat.realtor.pages.HousePage;
import io.appium.java_client.AppiumDriver;

public class HousePageStep extends BasePageStep {
    private HousePage housePage;

    public HousePageStep(AppiumDriver driver) {
        super(driver);
        housePage = new HousePage(driver);
    }

    public MortgageCalculatorPageStep clickEditMortgageCalculatorButton(){
        swipeUntilElementBecomeVisible(driver, housePage.getEditMortgageCalculatorButton());
        housePage.clickEditMirtgageCalculatorButton();
        return new MortgageCalculatorPageStep(driver);
    }

    public String getHouseAddress(){
        return housePage.getHouseAddress();
    }

    public MainPageStep clickGoBackButton(){
        housePage.clickGoBackButton();
        return new MainPageStep(driver);
    }

}
