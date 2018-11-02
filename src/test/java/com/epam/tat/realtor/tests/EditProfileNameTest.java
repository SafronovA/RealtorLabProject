package com.epam.tat.realtor.tests;

import com.epam.jira.JIRATestKey;
import com.epam.jira.testng.RetryAnalyzer;
import com.epam.tat.realtor.steps.MyProfilePageStep;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class EditProfileNameTest extends BaseTest {

    private final String FIRST_NAME_ORIGIN = "Loko";
    private final String LAST_NAME_ORIGIN = "ko";
    private final String FIRST_NAME_NEW = "New_Lo";
    private final String LAST_NAME_NEW = "New_ko";
    private MyProfilePageStep myProfilePageStep;

    /**
     * perform login operation
     */
    @BeforeMethod
    public void logIn() {
        homePageStep.userLogIn();
    }

    /**
     * click user icon on home page
     * go to my profile section
     * edit address name
     * check that the profile name has changed correctly
     */
    @JIRATestKey(key = "EPMFARMATS-4919", retryCountIfFailed = 2)
    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void editProfileName() {
        myProfilePageStep = homePageStep.clickUserIcon()
                .goToMyProfileSection()
                .editName(FIRST_NAME_NEW, LAST_NAME_NEW);
        Assert.assertTrue(myProfilePageStep.nameIsCorrect(FIRST_NAME_NEW + LAST_NAME_NEW),
                "Profile name has not changed to the required");
    }

    /**
     * revert profile name and logout
     */
    @AfterMethod
    public void revertProfileName() {
        myProfilePageStep.editName(FIRST_NAME_ORIGIN, LAST_NAME_ORIGIN)
                .logOut();
    }

}
