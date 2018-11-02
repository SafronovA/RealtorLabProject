package com.epam.tat.realtor.tests;

import com.epam.jira.JIRATestKey;
import com.epam.jira.testng.RetryAnalyzer;
import com.epam.tat.realtor.web.steps.SearchPageStep;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SchoolRatingTest extends BaseTest {

    private static final String CITY_NAME = "Anchorage, AK";
    private static final String RATING = "9";

    /**
     * select high school with selected rating
     * check that schools are displayed on map have rating more than selected rating
     */
    @JIRATestKey(key = "EPMFARMATS-5230", retryCountIfFailed = 2)
    @Test(retryAnalyzer = RetryAnalyzer.class)
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
