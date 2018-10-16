package com.epam.tat.realtor.tests;

import com.epam.tat.realtor.steps.SearchPageStep;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NumberOfHousesFoundTest extends BaseTest {
    private final String CITY_NAME = "Berkeley, CA";
    private SearchPageStep searchPageStep;

    /**
     * enter valid city in main search input
     * click submit button
     * check that the declared number of found houses and the actual number of houses on the pages are the same
     */
    @Test
    public void numberOfHousesFound() {
        searchPageStep = homePageStep.enterCityName(CITY_NAME)
                .clickSearchButton();
        Assert.assertTrue(searchPageStep.checkFindHomesCount(),
                "The number of homes found and displayed is not equal");
    }
}
