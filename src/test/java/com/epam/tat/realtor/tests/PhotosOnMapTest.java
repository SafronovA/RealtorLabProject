package com.epam.tat.realtor.tests;

import com.epam.jira.JIRATestKey;
import com.epam.jira.testng.RetryAnalyzer;
import com.epam.tat.realtor.web.steps.RealtorSearchResultPageStep;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PhotosOnMapTest extends BaseTest {

    private static final String CITY_NAME = "San Francisco, CA";
    private static final String REALTOR_NAME = "Laura Lanzone";

    @JIRATestKey(key = "EPMFARMATS-5235", retryCountIfFailed = 2)
    @Test(retryAnalyzer = RetryAnalyzer.class)
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
