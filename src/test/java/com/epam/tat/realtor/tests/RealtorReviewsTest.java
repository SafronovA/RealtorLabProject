package com.epam.tat.realtor.tests;

import com.epam.tat.realtor.steps.RealtorSearchResultPageStep;
import com.epam.tat.realtor.steps.RealtorPageStep;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Created by volchek on 02.10.2018.
 */
public class RealtorReviewsTest extends BaseTest {
    private static final String REALTOR_NAME = "Adora Lazaro";

    /**
     * click realtor button on homepage,
     * create search request (enter realtor name),
     * submit search request, get number of reviews in the realtor card,
     * click on realtor icon
     * click Load More Reviews button until all reviews won't be loaded
     * check that number of reviews on the page match reviews number in the realtor's card
     */
    @Test
<<<<<<< HEAD
    public void checkRealtorSoldHouses() {
        RealtorSearchResultPageStep realtorSearchResultPageStep = homePageStep.clickFindRealtorButton()
=======
    public void checkRealtorReviews() {
        FindRealtorPageStep findRealtorPageStep = homePageStep.clickFindRealtorButton()
>>>>>>> Jenkins_TEST
                .findRealtor(REALTOR_NAME);
        int realtorReviews = realtorSearchResultPageStep.getRatingCount();
        RealtorPageStep realtorPageStep = realtorSearchResultPageStep.clickRealtorIcon()
                .loadAllReviews();
        assertEquals(realtorReviews, realtorPageStep.getRealtorReviewsCount(),
                "number of realtor reviews in the realtor card mismatch reviews number on the realtor page ");
    }
}
