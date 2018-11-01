package com.epam.tat.realtor.steps_mob;

import com.epam.tat.realtor.pages_mob.BasePage;
import io.appium.java_client.AppiumDriver;

public class BasePageStep {
    protected AppiumDriver driver;
    protected BasePage basePage;

    public BasePageStep(AppiumDriver driver) {
        this.driver = driver;
        basePage = new BasePage(driver);
    }

}
