package com.epam.tat.realtor.tests;

import com.epam.jira.JIRATestKey;
import com.epam.jira.testng.RetryAnalyzer;
import com.epam.tat.realtor.web.steps.RealtorSearchResultPageStep;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SortByRecommendationsTest extends BaseTest {
    private static final String CITY_NAME = "San Francisco, CA";
    private static final String RECOMMENDATION_VALUE = "10+";
    private static final String SORT_OPTION = "Most Recommendations";
    private RealtorSearchResultPageStep realtorSearchResultPageStep;

    /**
     * click find realtor button on home page
     * find realtors on some location
     * edit recommendation filter
     * chose sort option
     * check that realtors are displayed on page sorted by recommendations
     */

    @JIRATestKey(key = "EPMFARMATS-4921", retryCountIfFailed = 2)
    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void sortByRecommendations() {
        realtorSearchResultPageStep = homePageStep.clickFindRealtorButton()
                .enterRealtorsLocation(CITY_NAME)
                .clickSearchButton()
                .choseRecommendation(RECOMMENDATION_VALUE)
                .choseSortOption(SORT_OPTION);
        Assert.assertTrue(realtorSearchResultPageStep.isRealtorsDisplayedSortedByRecommendations(),
                "Realtors are not sorted by descending number of reviews");
    }

}
