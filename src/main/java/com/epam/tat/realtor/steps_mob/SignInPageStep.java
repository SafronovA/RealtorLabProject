package com.epam.tat.realtor.steps_mob;

import com.epam.tat.realtor.pages_mob.SignInPage;
import io.appium.java_client.AppiumDriver;

public class SignInPageStep extends BasePageStep{
    private SignInPage settingsPage;

    public SignInPageStep(AppiumDriver driver) {
        super(driver);
        settingsPage = new SignInPage(driver);
    }

    public LogInPageStep clickLogInButton() {
        settingsPage.clickLogInButton();
        return new LogInPageStep(driver);
    }
}
