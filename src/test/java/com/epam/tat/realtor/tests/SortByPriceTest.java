package com.epam.tat.realtor.tests;

import org.testng.annotations.Test;

public class SortByPriceTest extends BaseTest {

    private static final String CITY_NAME = "San Francisco, CA";
    private static final String MIN_PRICE = "$350k";
    private static final String MAX_PRICE = "$600k";
    private static final String SORT_OPTION = "Highest Price";

    @Test
    public void savedSearch() {
        homePageStep.enterCityName(CITY_NAME)
                .clickSearchButton()
                .selectMinMaxPrices(MIN_PRICE, MAX_PRICE)
                .selectSortOption(SORT_OPTION);
    }

}
