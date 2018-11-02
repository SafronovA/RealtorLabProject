package com.epam.tat.realtor.tests;

import com.epam.jira.JIRATestKey;
import com.epam.jira.testng.RetryAnalyzer;
import com.epam.tat.realtor.pages.RealtorSearchResultPage;
import com.epam.tat.realtor.steps.FindRealtorPageStep;
import com.epam.tat.realtor.steps.RealtorPageStep;
import com.epam.tat.realtor.steps.RealtorSearchResultPageStep;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class RealtorRecommendationsTest extends BaseTest {
    private static final String REALTOR_NAME = "Adora Lazaro";

    /**
     * click realtor button on homepage,
     * create search request (enter realtor name),
     * submit search request, get number of recommendations in the realtor card,
     * click on realtor icon
     * click Load More Recommendations button until all recommendations won't be loaded
     * check that number of recommendations on the page match recommendations number in the realtor's card
     */
    @JIRATestKey(key = "EPMFARMATS-5215", retryCountIfFailed = 2)
    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void checkRealtorRecommendations() {
        RealtorSearchResultPageStep realtorSearchResultPageStep = homePageStep.clickFindRealtorButton()
                .enterRealtorName(REALTOR_NAME).clickSearchButton();
        int realtorRecommendations = realtorSearchResultPageStep.getRecommendationsCount();
        RealtorPageStep realtorPageStep = realtorSearchResultPageStep.clickRealtorIcon()
                .loadAllRecommendations();
        assertEquals(realtorRecommendations, realtorPageStep.getRealtorRecommendationsCount(),
                "number of realtor reviews in the realtor card mismatch reviews number on the realtor page ");
    }
}
