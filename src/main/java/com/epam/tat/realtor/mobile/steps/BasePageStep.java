package com.epam.tat.realtor.mobile.steps;

import com.epam.tat.realtor.mobile.pages.BasePage;
import io.appium.java_client.AppiumDriver;

public class BasePageStep {

    protected AppiumDriver driver;
    protected BasePage basePage;

    public BasePageStep(AppiumDriver driver){
        this.driver = driver;
        basePage = new BasePage(driver);
    }

}
