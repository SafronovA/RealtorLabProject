package com.epam.tat.realtor.tests;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class PropertyRecordsTest extends BaseTest {
    private static final String CITY_NAME = "San Francisco, CA";
    @Test
    public void searchByCondition() {
        assertTrue(homePageStep.enterCityName(CITY_NAME).goToHomeEstimate().checkPropertyRecords());
    }
}
