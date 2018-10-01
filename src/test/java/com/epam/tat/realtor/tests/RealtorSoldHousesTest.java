package com.epam.tat.realtor.tests;

import com.epam.tat.realtor.pages.BasePage;
import com.epam.tat.realtor.pages.RealtorPage;
import com.epam.tat.realtor.pages.SearchRealtorPage;
import com.epam.tat.realtor.steps.FindRealtorPageStep;
import com.epam.tat.realtor.steps.RealtorPageStep;
import com.epam.tat.realtor.steps.SearchRealtorPageStep;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class RealtorSoldHousesTest extends BaseTest {
    private static final String REALTOR_NAME="Amanda Hurtt";
    @Test
    public void checkRealtorSoldHouses(){
        SearchRealtorPageStep searchRealtorPageStep = homePageStep.clickFindRealtorButton();
        FindRealtorPageStep findRealtorPageStep = searchRealtorPageStep.findRealtor(REALTOR_NAME);
        int realtorSoldHouses = findRealtorPageStep.getRealtorSoldHoses();
        RealtorPageStep realtorPageStep = findRealtorPageStep.clickRealtorIcon();
        realtorPageStep.goToIFrameMap();
        assertEquals(realtorSoldHouses,realtorPageStep.getSoldHousesQuantity(), "number of sold houses in the realtor card mismatch number on the iframe map ");
        assertTrue(realtorPageStep.checkSoldHousesMapMarks(),"wrong status of sold houses on the iframe map");
    }
}
