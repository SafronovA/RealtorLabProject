package com.epam.tat.realtor.steps_mob;

import com.epam.tat.realtor.pages_mob.HomePage;
import com.epam.tat.realtor.pages_mob.MenuPage;
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
        menuPage.clickSettingsButton();
        return new SettingsPageStep(driver);
    }


}
