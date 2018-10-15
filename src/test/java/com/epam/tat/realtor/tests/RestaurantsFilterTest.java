package com.epam.tat.realtor.tests;

import com.epam.tat.realtor.steps.SearchPageStep;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RestaurantsFilterTest extends BaseTest {

    private static final String CITY_NAME = "San Francisco, CA";

    /**
     * check that dots are shown on map are restaurants
     */
    @Test
    public void restaurantsFilter() {
        SearchPageStep searchPageStep = new SearchPageStep(driver);
        homePageStep.enterCityName(CITY_NAME);
        homePageStep.clickSearchButton();
        searchPageStep.clickViewMapButton();
        searchPageStep.clickLifestyleButton();
        searchPageStep.selectRestaurants();
        Assert.assertTrue(searchPageStep.areAllFoundLifestyleRestaurants(),
                "One of found lifestyle is not a restaurant");
    }
}
