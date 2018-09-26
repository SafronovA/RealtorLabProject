package com.epam.tat.realtor.tests;


import com.epam.tat.realtor.steps.SearchPageStep;
import org.testng.annotations.Test;

public class SearchByConditionsTest extends BaseTest {
    private final String CITY_NAME = "San Francisco, CA";
    @Test
    public void searchByCondition(){
        SearchPageStep searchPageStep = homePageStep.enterCityName(CITY_NAME)
                                                    .clickSearchButton();

    }
}
