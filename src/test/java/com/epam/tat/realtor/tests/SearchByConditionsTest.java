package com.epam.tat.realtor.tests;


import com.epam.tat.realtor.bo.House;
import com.epam.tat.realtor.steps.SearchPageStep;
import com.epam.tat.realtor.util.RealtorUtil;
import org.testng.annotations.Test;
import java.util.List;

import static org.testng.Assert.*;

public class SearchByConditionsTest extends BaseTest {
    private final String CITY_NAME = "San Francisco, CA";
    private final String MIN_PRICE_VALUE = "$350k";
    private final String MAX_PRICE_VALUE = "$1.2M";
    private final String BED_NUMBER = "2+";
    private final String BATH_NUMBER = "2+";
    private final String MIN_SQFT_VALUE = "1,500 sqft";
    private final String MAX_SQFT_VALUE = "2,000 sqft";


    @Test
    public void searchByCondition(){
        SearchPageStep searchPageStep = homePageStep.enterCityName(CITY_NAME)
                                                    .clickSearchButton();
        List<House> searchResult = searchPageStep
                .createSearchRequest(MIN_PRICE_VALUE,MAX_PRICE_VALUE,BED_NUMBER,BATH_NUMBER,MIN_SQFT_VALUE,MAX_SQFT_VALUE)
                .createHomesList();
        searchPageStep.printList(searchResult);
        assertTrue(searchPageStep.checkSearchResult(searchResult,
                                                    RealtorUtil.parse(MIN_PRICE_VALUE,1000),
                                                    RealtorUtil.parse(MAX_PRICE_VALUE,100000),
                                                    RealtorUtil.parse(BED_NUMBER),
                                                    RealtorUtil.parse(BATH_NUMBER),
                                                    RealtorUtil.parse(MIN_SQFT_VALUE),
                                                    RealtorUtil.parse(MAX_SQFT_VALUE)));
    }
}
