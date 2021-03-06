package com.epam.tat.realtor.steps;

import com.epam.tat.realtor.pages.LogInPage;
import io.appium.java_client.AppiumDriver;

public class LogInPageStep extends BasePageStep{
    private LogInPage logInPage;

    public LogInPageStep(AppiumDriver driver) {
        super(driver);
        logInPage = new LogInPage(driver);
    }

    public MenuPageStep logIn(String email, String pass){
        logInPage.enterEmail(email);
        logInPage.enterPass(pass);
        logInPage.clickSubmitButton();

        return new MenuPageStep(driver);
    }
}
