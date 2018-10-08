package com.epam.tat.realtor.tests;

import com.epam.tat.realtor.steps.SearchPageStep;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SchoolRatingAndTypeTest extends BaseTest {

    private static final String CITY_NAME = "Santa Rosa, CA";

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
                .selectEightRating();
        Assert.assertTrue(searchPageStep.doesAllSchoolHaveRatingMoreThanEight(),
                "One of the schools shown on the map does not have a rating of ten");
        Assert.assertTrue(searchPageStep.areAllSchoolsHigh(),
                "One of the schools shown on the map are not high");
    }

}
