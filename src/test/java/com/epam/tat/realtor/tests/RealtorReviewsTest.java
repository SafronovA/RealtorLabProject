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
     * submit search request, get number of sold houses in the realtor card,
     * click on realtor icon
     * check that number of sold houses in the "Recently Sold" section match sold houses number in the realtor's card
     * check if every hose on the iframe map has "Sold" status
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
