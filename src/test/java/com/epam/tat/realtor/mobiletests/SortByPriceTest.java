package com.epam.tat.realtor.mobiletests;

import org.testng.annotations.Test;

public class SortByPriceTest extends BaseTest {

    private static final String CITY = "San Francisco, CA";
    private static final String MIN_PRICE = "3500000";
    private static final String MAX_PRICE = "3700000";

    @Test
    public void sortByPrice(){
        homePageStep.clickMenuButton()
                .clickStartNewSearch()
                .enterCity(CITY)
                .clickViewListButton()
                .selectLowToHighPriceSortOption()
                .clickFilterButton()
                .enterMinPrice(MIN_PRICE)
                .enterMaxPrice(MAX_PRICE);
    }

}
