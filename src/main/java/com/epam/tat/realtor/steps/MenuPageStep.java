package com.epam.tat.realtor.steps;

import com.epam.tat.realtor.pages.MenuPage;
import io.appium.java_client.AppiumDriver;

public class MenuPageStep extends BasePageStep{
    private MenuPage menuPage;

    public MenuPageStep(AppiumDriver driver) {
        super(driver);
        menuPage= new MenuPage(driver);
    }

    public SignInPageStep clickSignInButton(){
        menuPage.clickSignInButton();
        return new SignInPageStep(driver);
    }

    public SettingsPageStep clickSettingsButton(){
        swipeUntilElementBecomeVisible(driver, menuPage.getSettingsButton());
        menuPage.clickSettingsButton();
        return new SettingsPageStep(driver);
    }

}
