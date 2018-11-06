package com.epam.tat.realtor.tests_mob;

import com.epam.tat.realtor.steps_mob.SettingsPageStep;
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
        settingsPageStep = homePageStep.clickMenu()
                .clickSignInButton()
                .clickLogInButton()
                .logIn(EMAIL, PASS)
                .clickSettingsButton();
        Assert.assertEquals(EMAIL, settingsPageStep.getUserName());
    }

    @AfterClass
    public void postconditions(){
        settingsPageStep.logOut();
    }
}
