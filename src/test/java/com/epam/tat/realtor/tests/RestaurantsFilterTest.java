package com.epam.tat.realtor.tests;

import com.epam.jira.JIRATestKey;
import com.epam.jira.testng.RetryAnalyzer;
import com.epam.tat.realtor.web.steps.SearchPageStep;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RestaurantsFilterTest extends BaseTest {

    private static final String CITY_NAME = "San Francisco, CA";

    /**
     * check that dots are shown on map are restaurants
     */
    @JIRATestKey(key = "EPMFARMATS-4937", retryCountIfFailed = 2)
    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void restaurantsFilter() {
        SearchPageStep searchPageStep = homePageStep.enterCityName(CITY_NAME)
                .clickSearchButton()
                .clickViewMapButton()
                .clickLifestyleButton()
                .selectRestaurants();
        Assert.assertTrue(searchPageStep.areAllFoundLifestyleRestaurants(),
                "One of found lifestyle is not a restaurant");
    }
}
