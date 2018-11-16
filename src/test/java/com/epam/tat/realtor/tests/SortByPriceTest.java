package com.epam.tat.realtor.tests;

import com.epam.tat.realtor.steps.ViewSearchResultsPageStep;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SortByPriceTest extends BaseTest {

    private static final String CITY = "San Francisco, CA";
    private static final String MIN_PRICE = "3500000";
    private static final String MAX_PRICE = "3600000";

    @Test
    public void sortByPrice() {
        ViewSearchResultsPageStep viewSearchResultsPageStep =
                mainPageStep.clickMenuButton()
                        .clickStartNewSearch()
                        .enterSearchCity(CITY)
                        .openViewListPage()
                        .clickSortByButton()
                        .selectLowToHighSortOption()
                        .clickFilterButton()
                        .enterPriceRange(MIN_PRICE, MAX_PRICE)
                        .clickViewResultsButtonAfterSetSort();
        Assert.assertTrue(viewSearchResultsPageStep.doesHomeDisplayedSortedByPrice(),
                "Homes were not displayed in sorted by price order");
    }

}
