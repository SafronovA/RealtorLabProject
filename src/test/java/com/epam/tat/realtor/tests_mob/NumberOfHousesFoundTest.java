package com.epam.tat.realtor.tests_mob;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.Set;

public class NumberOfHousesFoundTest extends BaseTest {
    private final String CITY = "Wildwood, NJ";
    private final String MIN_PRICE = "450000";
    private final String MAX_PRICE = "500000";

    @Test
    public void numberOfHousesFound() {
        int expectedNumberOfHousesFound = homePageStep.openFilter()
                .enterPriceRange(MIN_PRICE, MAX_PRICE)
                .enterCity(CITY)
                .clickViewResultsButton()
                .getSearchResultCount();
        int actualNumberOfHousesFound = homePageStep.openHousesList()
                .getNumberOfAllHousesFromScreen();
        Assert.assertEquals(expectedNumberOfHousesFound, actualNumberOfHousesFound,
                "The number of homes found and displayed is not equal");
    }


}

