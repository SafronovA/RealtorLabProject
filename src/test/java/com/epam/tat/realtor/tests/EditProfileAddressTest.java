package com.epam.tat.realtor.tests;

import com.epam.jira.JIRATestKey;
import com.epam.jira.testng.RetryAnalyzer;
import com.epam.tat.realtor.steps.MyProfilePageStep;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

import static org.testng.Assert.assertTrue;

public class EditProfileAddressTest extends BaseTest {

    private final String ADDRESS_ORIGIN = "streetOrigin";
    private final String CITY_ORIGIN = "cityOrigin";
    private final String STATE_ORIGIN = "Arizona";
    private final String COUNTRY_ORIGIN = "Togo";
    private final String ADDRESS_NEW = "streetNew";
    private final String CITY_NEW = "cityNew";
    private final String STATE_NEW = "Hawaii";
    private final String COUNTRY_NEW = "United States";
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
     * edit address fields
     * check that the profile address has changed correctly
     */
    @JIRATestKey(key = "EPMFARMATS-4946", retryCountIfFailed = 2)
    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void editAddressFields() {
                myProfilePageStep = homePageStep.clickUserIcon()
                .goToMyProfileSection()
                .editAddress(ADDRESS_NEW, CITY_NEW, STATE_NEW, COUNTRY_NEW);
        assertTrue(myProfilePageStep.addressIsCorrect(ADDRESS_NEW), "Profile address has not changed to the required");
        assertTrue(myProfilePageStep.cityIsCorrect(CITY_NEW), "Profile city  has not changed to the required");
        assertTrue(myProfilePageStep.stateIsCorrect(STATE_NEW), "Profile state  has not changed to the required");
        assertTrue(myProfilePageStep.countryIsCorrect(COUNTRY_NEW), "Profile address has not changed to the required");
    }

    /**
     * returns the values of the modified fields
     */
    @AfterMethod
    public void revertAddressFields() {

        myProfilePageStep.editAddressRevert(ADDRESS_ORIGIN, CITY_ORIGIN, STATE_ORIGIN, COUNTRY_ORIGIN)
                .logOut();
    }

}
