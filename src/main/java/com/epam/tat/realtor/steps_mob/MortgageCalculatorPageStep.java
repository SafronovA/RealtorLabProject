package com.epam.tat.realtor.steps_mob;

import com.epam.tat.realtor.pages_mob.MortgageCalculatorPage;
import io.appium.java_client.AppiumDriver;

public class MortgageCalculatorPageStep extends BasePageStep {
    private MortgageCalculatorPage mortgageCalculatorPage;

    public MortgageCalculatorPageStep(AppiumDriver driver){
        super(driver);
        mortgageCalculatorPage = new MortgageCalculatorPage(driver);
    }


}
