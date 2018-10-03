package com.epam.tat.realtor.tests;

import com.epam.tat.realtor.steps.FindRealtorPageStep;
import com.epam.tat.realtor.steps.RealtorPageStep;
import com.epam.tat.realtor.steps.SearchRealtorPageStep;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class RealtorSoldHousesTest extends BaseTest {
    private static final String REALTOR_NAME = "Amanda Hurtt";

    /**
     * click realtor button on homepage,
     * create search request (enter realtor name),
     * submit search request, get number of sold houses in the realtor card,
     * click on realtor icon
     * check that number of sold houses in the "Recently Sold" section match sold houses number in the realtor's card
     * check if every house on the iframe map has "Sold" status
     */
    @Test
    public void checkRealtorSoldHouses() {
        FindRealtorPageStep findRealtorPageStep = homePageStep.clickFindRealtorButton()
                .findRealtor(REALTOR_NAME);
        int realtorSoldHouses = findRealtorPageStep.getRealtorSoldHoses();
        RealtorPageStep realtorPageStep = findRealtorPageStep.clickRealtorIcon()
                .prepareIFrameMap();
        assertEquals(realtorSoldHouses, realtorPageStep.getSoldHousesQuantity(),
                "number of sold houses in the realtor card mismatch number on the iframe map ");
        assertTrue(realtorPageStep.checkSoldHousesMapMarks(),
                "wrong status of sold houses on the iframe map");
    }
}
