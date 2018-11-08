package com.epam.tat.realtor.steps;

import com.epam.tat.realtor.pages.SettingsPage;
import io.appium.java_client.AppiumDriver;

public class SettingsPageStep extends BasePageStep {
    private SettingsPage settingsPage;

    public SettingsPageStep(AppiumDriver driver) {
        super(driver);
        settingsPage = new SettingsPage(driver);
    }

    public String getUserName() {
        return settingsPage.getName();
    }

    public void logOut(){
        settingsPage.clickLogOut();
    }
}
