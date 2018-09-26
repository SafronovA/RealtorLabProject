package com.epam.tat.realtor.tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SavedSearchTest extends BaseTest{

    private static final String CITY_NAME = "New York, NY";
    private static final String MIN_PRICE = "$350k";
    private static final String MAX_PRICE = "$600k";

    @BeforeTest
    public void logIn(){
        homePageStep.userLogIn();
        homePageStep.openSavedSearches()
                .clearAllOldSavedSearches()
                .moveToHomePage();
    }

    @Test
    public void savedSearch(){
        homePageStep.enterCityName(CITY_NAME)
                .clickSearchButton()
                .selectMinMaxPrices(MIN_PRICE, MAX_PRICE);
    }

}
