package com.epam.tat.realtor.tests;

import com.epam.tat.realtor.steps.SettingsPageStep;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class AuthorizedTest extends BaseTest {
    private SettingsPageStep settingsPageStep;
    private static final String EMAIL = "qwert@mail.ru";
    private static final String PASS = "qwert12345";

    /**
     */
    @Test
    public void authorised() {
        settingsPageStep = mainPageStep.clickMenuButton()
                .clickSignInButton()
                .clickLogInButton()
                .logIn(EMAIL, PASS)
                .clickSettingsButton();
        Assert.assertEquals(EMAIL, settingsPageStep.getUserName());
    }

    @AfterClass
    public void logOut(){
        settingsPageStep.logOut();
    }
}
