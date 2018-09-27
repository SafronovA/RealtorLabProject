package com.epam.tat.realtor.tests;

import com.epam.tat.realtor.steps.SavedSearchesPageStep;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SavedSearchTest extends BaseTest{

    private static final String CITY_NAME = "San Francisco, CA";
    private static final String MIN_PRICE = "$350k";
    private static final String MAX_PRICE = "$600k";
    private SavedSearchesPageStep savedSearchesPageStep;

    /**
     * login with valid credentials
     * go to saved searches page and delete all saved searches
     */
    @BeforeTest
    public void logIn(){
        homePageStep.userLogIn()
                .clickUserIcon()
                .clickSavedSearchesLink()
                .clearAllOldSavedSearches()
                .moveToHomePage();
    }

    /**
     * test that search saved with selected parameters
     */
    @Test
    public void savedSearch(){
        homePageStep.enterCityName(CITY_NAME)
                .clickSearchButton()
                .selectMinMaxPrices(MIN_PRICE, MAX_PRICE)
                .clickSaveSearchButton()
                .openSavedSearches();
        savedSearchesPageStep = new SavedSearchesPageStep(driver);
        Assert.assertTrue(savedSearchesPageStep.checkSavedSearchDescriptionContainsInputText(CITY_NAME, MIN_PRICE, MAX_PRICE),
                "Description does not contains needed parameters");
    }

    /**
     * delete created search and log out
     */
    @AfterTest
    public void deleteCreatedSaveSearch(){
        savedSearchesPageStep.clearAllOldSavedSearches()
                .logOut();
    }

}
