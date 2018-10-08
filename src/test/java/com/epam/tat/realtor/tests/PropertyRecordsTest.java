package com.epam.tat.realtor.tests;

import org.testng.annotations.Test;

public class PropertyRecordsTest extends BaseTest {
    private static final String CITY_NAME = "San Francisco, CA";
    @Test
    public void searchByCondition() {
        homePageStep.enterCityName(CITY_NAME).goToHomeEstimate().checkPropertyRecords();

    }
}
