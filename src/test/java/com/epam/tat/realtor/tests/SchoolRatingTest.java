package com.epam.tat.realtor.tests;

import org.testng.annotations.Test;

public class SchoolRatingTest extends BaseTest {

    private static final String CITY_NAME = "San Francisco, CA";

    /**
     * select high and rating 10
     * check that schools are displayed on mam have rating 10
     */
    @Test
    public void schoolRating() {
        homePageStep.enterCityName(CITY_NAME)
                .clickSearchButton();
    }

}
