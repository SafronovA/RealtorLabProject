package com.epam.tat.realtor.tests;

import com.epam.tat.realtor.steps.SearchPageStep;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SchoolRatingAndTypeTest extends BaseTest {

    private static final String CITY_NAME = "Santa Rosa, CA";
    private static final String RATING = "8";

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
        Assert.assertTrue(searchPageStep.areAllSchoolsHigh(),
                "One of the schools shown on the map are not high");
    }

}
