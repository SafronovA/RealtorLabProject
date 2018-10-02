package com.epam.tat.realtor.tests;

import com.epam.tat.realtor.steps.FindRealtorPageStep;
import com.epam.tat.realtor.steps.RealtorPageStep;
import com.epam.tat.realtor.steps.SearchRealtorPageStep;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Created by volchek on 02.10.2018.
 */
public class RealtorReviewsTest extends BaseTest {
    private static final String REALTOR_NAME="Adora Lazaro";

    /**
     * click realtor button on homepage,
     * create search request (enter realtor name),
     * submit search request, get number of reviews in the realtor card,
     * click on realtor icon
     * click Load More Reviews button until all reviews won't be loaded
     * check that number of reviews on the page match reviews number in the realtor's card
     */
    @Test
    public void checkRealtorSoldHouses(){
        SearchRealtorPageStep searchRealtorPageStep = homePageStep.clickFindRealtorButton();
        FindRealtorPageStep findRealtorPageStep = searchRealtorPageStep.findRealtor(REALTOR_NAME);
        int realtorReviews = findRealtorPageStep.getRatingCount();
        RealtorPageStep realtorPageStep = findRealtorPageStep.clickRealtorIcon();
        realtorPageStep.loadAllReviews();
        assertEquals(realtorReviews,realtorPageStep.getRealtorReviewsCount(), "number of realtor reviews in the realtor card mismatch reviews number on the realtor page ");
    }
}
