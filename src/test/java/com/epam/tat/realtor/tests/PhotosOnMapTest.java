package com.epam.tat.realtor.tests;

import com.epam.tat.realtor.steps.RealtorSearchResultPageStep;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PhotosOnMapTest extends BaseTest {

    private static final String CITY_NAME = "San Francisco, CA";
    private static final String REALTOR_NAME = "Laura Lanzone";

    @Test
    public void photosOnMapMatchToSelectedAgentPhoto(){
        RealtorSearchResultPageStep realtorSearchResultPageStep = homePageStep.clickFindRealtorButton()
                .enterRealtorsLocation(CITY_NAME)
                .enterRealtorName(REALTOR_NAME)
                .clickSearchButton()
                .clickActivityMapButton()
                .clickGetStartedConfirmButton();
        Assert.assertTrue(realtorSearchResultPageStep.arePhotosOnMapMatchSelectedRealtorPhoto(),
                "One of photos shown on map do not match with selected realtor photo");
    }

}
