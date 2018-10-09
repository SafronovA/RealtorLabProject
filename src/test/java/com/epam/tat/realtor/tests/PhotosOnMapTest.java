package com.epam.tat.realtor.tests;

import org.testng.annotations.Test;

public class PhotosOnMapTest extends BaseTest {

    private static final String CITY_NAME = "San Francisco, CA";
    private static final String REALTOR_NAME = "Grace Lucero";

    @Test
    public void photosOnMapMatchToSelectedAgentPhoto(){
        homePageStep.clickFindRealtorButton()
                .setCity(CITY_NAME)
                .findRealtor(REALTOR_NAME)
                .clickActivityMapButton();
    }

}
