package com.epam.tat.realtor.tests;

import com.epam.tat.realtor.steps.ViewSearchResultsPageStep;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SoldStatusTest extends BaseTest{
    private final String CITY_NAME = "San Francisco, CA";
    private final String MIN_PRICE_VALUE = "370000";
    private final String MAX_PRICE_VALUE = "475000";


    @Test
    void checkHomeStatus() {
        ViewSearchResultsPageStep viewSearchResultsPageStep =mainPageStep.clickMenuButton()
                .clickStartNewSearch()
//                .startNewSearch()
                .enterSearchCity(CITY_NAME)
                .enterFilterSection()
                .createFilterRequest(MIN_PRICE_VALUE,MAX_PRICE_VALUE).clickViewResultsButton().clickMenuButton().selectSoldStatus().openViewListPage();
        Assert.assertTrue(viewSearchResultsPageStep.checkSoldStatus(), "there are elements without 'sold' status in the view list");

    }
}
