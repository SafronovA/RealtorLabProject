package com.epam.tat.realtor.tests;

import com.epam.jira.JIRATestKey;
import com.epam.tat.realtor.bo.House;
import com.epam.tat.realtor.steps.SearchPageStep;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertTrue;

public class SearchByConditionsTest extends BaseTest {
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
     * check that every house in the list of search result match search parameters
     */
    @JIRATestKey(key = "EPMFARMATS-4923")
    @Test
    public void searchByCondition() {
        SearchPageStep searchPageStep = homePageStep.enterCityName(CITY_NAME)
                .clickSearchButton();
        List<House> searchResult = searchPageStep
                .createSearchRequest(MIN_PRICE_VALUE, MAX_PRICE_VALUE, BED_NUMBER, BATH_NUMBER, MIN_SQFT_VALUE, MAX_SQFT_VALUE)
                .createHomesList();
        assertTrue(searchPageStep.checkSearchResultPrice(searchResult, MIN_PRICE_VALUE, MAX_PRICE_VALUE),
                "price value mismatch search criteria");
        assertTrue(searchPageStep.checkSearchResultBed(searchResult, BED_NUMBER),
                "bed quantity mismatch search criteria");
        assertTrue(searchPageStep.checkSearchResultBath(searchResult, BATH_NUMBER),
                "bath quantity mismatch search criteria");
        assertTrue(searchPageStep.checkSearchResultSqft(searchResult, MIN_SQFT_VALUE, MAX_SQFT_VALUE),
                "square feet house size mismatch search criteria");
    }
}
