package com.epam.tat.realtor.mobiletests;

import com.epam.tat.realtor.mobile.steps.ViewSearchResultsPageStep;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SortByPriceTest extends BaseTest {

    private static final String CITY = "San Francisco, CA";
    private static final String MIN_PRICE = "3500000";
    private static final String MAX_PRICE = "3700000";

    @Test
    public void sortByPrice(){
        ViewSearchResultsPageStep viewSearchResultsPageStep =
                homePageStep.clickMenuButton()
                .clickStartNewSearch()
                .enterCity(CITY)
                .clickViewListButton()
                .clickSortByButton()
                .selectLowToHighSortOption()
                .clickFilterButton()
                .enterMinPrice(MIN_PRICE)
                .enterMaxPrice(MAX_PRICE)
                .clickViewResultsButton();
        Assert.assertTrue(viewSearchResultsPageStep.doesHomeDisplayedSortedByPrice(),
                "Homes were not displayed in sorted by price order");
    }

}
