package com.epam.tat.realtor.mobiletests;

import org.testng.annotations.Test;

public class SortByPriceTest extends BaseTest {

    private static final String CITY = "San Francisco";

    @Test
    public void sortByPrice(){
        homePageStep.clickMenuButton()
                .clickStartNewSearch()
                .enterCity(CITY)
                .clickViewListButton();
    }

}
