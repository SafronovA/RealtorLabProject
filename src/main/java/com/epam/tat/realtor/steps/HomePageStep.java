package com.epam.tat.realtor.steps;

import com.epam.tat.realtor.pages.HomePage;
import io.appium.java_client.AppiumDriver;

public class HomePageStep extends BasePageStep {

    private HomePage homePage;

    public HomePageStep(AppiumDriver driver) {
        super(driver);
        homePage = new HomePage(driver);
    }

}
