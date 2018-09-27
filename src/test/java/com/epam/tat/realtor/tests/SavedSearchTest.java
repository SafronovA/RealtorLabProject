package com.epam.tat.realtor.tests;

import com.epam.tat.realtor.steps.SavedSearchesPageStep;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SavedSearchTest extends BaseTest{

    private static final String CITY_NAME = "New York, NY";
    private static final String MIN_PRICE = "$350k";
    private static final String MAX_PRICE = "$600k";
    private SavedSearchesPageStep savedSearchesPageStep;

    @BeforeTest
    public void logIn(){
        homePageStep.userLogIn()
                .openSavedSearches()
                .clearAllOldSavedSearches()
                .moveToHomePage();
    }

    @Test
    public void savedSearch(){
        homePageStep.enterCityName(CITY_NAME)
                .clickSearchButton()
                .selectMinMaxPrices(MIN_PRICE, MAX_PRICE)
                .clickSaveSearchButton()
                .openSavedSearches();
        savedSearchesPageStep = new SavedSearchesPageStep(driver);
//        Assert.assertTrue(savedSearchesPageStep.checkSavedSearchDescriptionContainsInputText(CITY_NAME, MIN_PRICE, MAX_PRICE),
//                "Description does not contains needed parameters");
    }

    @AfterTest
    public void deleteCreatedSaveSearch(){
        savedSearchesPageStep.clearAllOldSavedSearches()
                .moveToHomePage();
        homePageStep.logOut();
    }

}
