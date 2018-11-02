package com.epam.tat.realtor.tests;

import com.epam.jira.JIRATestKey;
import com.epam.jira.testng.RetryAnalyzer;
import com.epam.tat.realtor.web.steps.SearchPageStep;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class MapMarksTest extends BaseTest {
    private final String CITY_NAME = "Berkeley, CA";
    private final String MIN_PRICE_VALUE = "$250k";
    private final String MAX_PRICE_VALUE = "$1.4M";
    private final String BED_NUMBER = "2+";
    private final String BATH_NUMBER = "2+";
    private final String MIN_SQFT_VALUE = "1,750 sqft";
    private final String MAX_SQFT_VALUE = "2,000 sqft";

    /**
     * enter city name in the main search input, submit search request
     * create search request by: min/max house price, number of beds, bathes, min/max square feet house size
     * click map view button
     * check if all map marks contain values that match search parameters
     */
    @JIRATestKey(key = "EPMFARMATS-4924", retryCountIfFailed = 2)
    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void checkMapMarks() {
        SearchPageStep searchPageStep = homePageStep.enterCityName(CITY_NAME)
                .clickSearchButton()
                .createSearchRequest(MIN_PRICE_VALUE, MAX_PRICE_VALUE,
                        BED_NUMBER, BATH_NUMBER,
                        MIN_SQFT_VALUE, MAX_SQFT_VALUE);
        assertTrue(searchPageStep.checkPriceMapMarks(MIN_PRICE_VALUE, MAX_PRICE_VALUE),
                "price value on the map mark mismatch search criteria");
        assertTrue(searchPageStep.checkBedMapMarks(BED_NUMBER),
                "bed quantity on the map mark mismatch search criteria");
        assertTrue(searchPageStep.checkBathMapMarks(BATH_NUMBER),
                "bath quantity on the map mark mismatch search criteria");
        assertTrue(searchPageStep.checkSqftMapMarks(MIN_SQFT_VALUE, MAX_SQFT_VALUE),
                "square feet house size on the map mark mismatch search criteria");
    }
}
