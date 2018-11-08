package com.epam.tat.realtor.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class NumberOfHousesFoundTest extends BaseTest {
    private final String CITY = "Wildwood, NJ";
    private final String MIN_PRICE = "450000";
    private final String MAX_PRICE = "480000";

    @Test
    public void numberOfHousesFound() {
        int expectedNumberOfHousesFound = mainPageStep.openFilter()
                .enterPriceRange(MIN_PRICE, MAX_PRICE)
                .enterCity(CITY)
                .clickViewResultsButton()
                .getSearchResultCount();
        int actualNumberOfHousesFound = mainPageStep.openViewListPage()
                .getNumberOfAllHousesFromSearchResult();
        Assert.assertEquals(expectedNumberOfHousesFound, actualNumberOfHousesFound,
                "The number of homes found and displayed is not equal");
    }
    
}

