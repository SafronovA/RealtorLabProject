package com.epam.tat.realtor.steps;

import com.epam.tat.realtor.pages.SignInPage;
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
