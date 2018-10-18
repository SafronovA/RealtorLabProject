package com.epam.tat.realtor.tests;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class PropertyRecordsTest extends BaseTest {
    private static final String CITY_NAME = "San Francisco, CA";

    /**
     * enter Property Records for the named city,
     * check if every property record starts with proper character
     */
    @Test
    public void checkPropertyRecords() {
        assertTrue(homePageStep.enterCityName(CITY_NAME)
                .goToHomeEstimate()
                .checkPropertyRecords(), "property list has alphabetical sorting structure mistake");
    }
}
