package com.epam.tat.realtor.tests;

import com.epam.tat.realtor.steps.FindRealtorPageStep;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SortByRecommendationsTest extends BaseTest {
    private static final String CITY_NAME = "San Francisco, CA";
    private static final String RECOMMENDATION_VALUE = "10+";
    private static final String SORT_OPTION = "Most Recommendations";
    private FindRealtorPageStep findRealtorPageStep;

    /**
     * check that realtors are displayed on page sorted by recommendations
     */
    @Test
    public void sortByRecommendations() {
        findRealtorPageStep = homePageStep.clickFindRealtorButton()
                .findRealtorsByLocation(CITY_NAME)
                .choseRecommendation(RECOMMENDATION_VALUE)
                .choseSortOption(SORT_OPTION);
        Assert.assertTrue(findRealtorPageStep.isRealtorsDisplayedSortedByRecommendations(),
                "Realtors are not sorted by descending number of reviews");
    }

}
