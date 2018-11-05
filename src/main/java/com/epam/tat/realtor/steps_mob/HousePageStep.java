package com.epam.tat.realtor.steps_mob;

import com.epam.tat.realtor.pages_mob.HousePage;
import com.epam.tat.realtor.pages_mob.MortgageCalculatorPage;
import io.appium.java_client.AppiumDriver;

public class HousePageStep extends BasePageStep {
    private HousePage housePage;

    public HousePageStep(AppiumDriver driver) {
        super(driver);
        housePage = new HousePage(driver);
    }

    public MortgageCalculatorPageStep clickEditMirtgageCalculatorButton(){
        swipeUntilElementBecomeVisible(driver, housePage.getEditMortgageCalculatorButton());
        housePage.clickEditMirtgageCalculatorButton();
        return new MortgageCalculatorPageStep(driver);
    }

}
