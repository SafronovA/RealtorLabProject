package com.epam.tat.realtor.tests;

import com.epam.tat.realtor.steps.FindRealtorPageStep;
import com.epam.tat.realtor.steps.RealtorPageStep;
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
    @Test
    public void checkRealtorRecommendations() {
        FindRealtorPageStep findRealtorPageStep = homePageStep.clickFindRealtorButton()
                .findRealtor(REALTOR_NAME);
        int realtorRecommendations = findRealtorPageStep.getRecommendationsCount();
        RealtorPageStep realtorPageStep = findRealtorPageStep.clickRealtorIcon()
                .loadAllRecommendations();
        assertEquals(realtorRecommendations, realtorPageStep.getRealtorRecommendationsCount(),
                "number of realtor reviews in the realtor card mismatch reviews number on the realtor page ");
    }
}
