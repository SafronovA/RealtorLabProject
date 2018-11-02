package com.epam.tat.realtor.mobile.steps;

import com.epam.tat.realtor.mobile.pages.BasePage;
import io.appium.java_client.AppiumDriver;

public class BasePageStep {

    protected AppiumDriver appiumDriver;
    protected BasePage basePage;

    public BasePageStep(AppiumDriver appiumDriver){
        this.appiumDriver = appiumDriver;
        basePage = new BasePage(appiumDriver);
    }

}
