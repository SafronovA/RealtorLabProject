package com.epam.tat.realtor.tests;

import com.epam.jira.JIRATestKey;
import com.epam.jira.testng.RetryAnalyzer;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class PropertyRecordsTest extends BaseTest {
    private static final String CITY_NAME = "Windsor, NY";

    /**
     * enter Property Records for the named city,
     * check if every property record starts with proper character
     */
    @JIRATestKey(key = "EPMFARMATS-5216", retryCountIfFailed = 2)
    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void checkPropertyRecords() {
        assertTrue(homePageStep.enterCityName(CITY_NAME)
                .goToHomeEstimate()
                .checkPropertyRecords(), "property list has alphabetical sorting structure mistake");
    }
}
