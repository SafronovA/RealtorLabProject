package com.epam.tat.realtor.tests;


import com.epam.tat.realtor.bo.House;
import com.epam.tat.realtor.steps.SearchPageStep;
import com.epam.tat.realtor.util.Parser;
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
    @Test
    public void searchByCondition(){
        SearchPageStep searchPageStep = homePageStep.enterCityName(CITY_NAME)
                                                    .clickSearchButton();
        List<House> searchResult = searchPageStep
                .createSearchRequest(MIN_PRICE_VALUE,MAX_PRICE_VALUE,BED_NUMBER,BATH_NUMBER,MIN_SQFT_VALUE,MAX_SQFT_VALUE)
                .createHomesList();
        searchPageStep.printList(searchResult);
        assertTrue(searchPageStep.checkSearchResult(searchResult,
                                                    Parser.parsePrice(MIN_PRICE_VALUE),
                                                    Parser.parsePrice(MAX_PRICE_VALUE),
                                                    Parser.parse(BED_NUMBER),
                                                    Parser.parse(BATH_NUMBER),
                                                    Parser.parse(MIN_SQFT_VALUE),
                                                    Parser.parse(MAX_SQFT_VALUE)));
    }
}
