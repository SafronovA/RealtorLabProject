package com.epam.tat.realtor.tests;

import com.epam.tat.realtor.steps.SearchPageStep;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SchoolRatingTest extends BaseTest {

    private static final String CITY_NAME = "Anchorage, AK";
    private static final String RATING = "9";

    /**
     * select high and rating 8
     * check that schools are displayed on mam have rating mare than 8 and high
     */
    @Test
    public void schoolRating() {
        SearchPageStep searchPageStep = homePageStep.enterCityName(CITY_NAME)
                .clickSearchButton()
                .clickViewMapButton()
                .clickSchoolButton()
                .selectHighSchool()
                .selectSchoolRating(RATING);
        Assert.assertTrue(searchPageStep.doesAllSchoolHaveSelectedRating(RATING),
                "One of the schools shown on the map does not have a rating more that " + RATING);

    }

}
