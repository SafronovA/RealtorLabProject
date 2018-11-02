package com.epam.tat.realtor.mobile.steps;

import com.epam.tat.realtor.mobile.pages.HomePage;
import io.appium.java_client.AppiumDriver;

public class HomePageStep extends BasePageStep {

    private HomePage homePage;

    public HomePageStep(AppiumDriver driver){
        super(driver);
        homePage = new HomePage(driver);
    }

    public MenuPageStep clickMenuButton(){
        homePage.clickMenuButton();
        return new MenuPageStep(driver);
    }

    public HomePageStep enterCity(String city){
        homePage.enterCity(city);
        return this;
    }

    public HomePageStep clickSaveSearchButton(){
        homePage.clickSaveSearchButton();
        return this;
    }

}
