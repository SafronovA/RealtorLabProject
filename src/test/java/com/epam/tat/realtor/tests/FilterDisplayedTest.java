package com.epam.tat.realtor.tests;

import com.epam.tat.realtor.steps.SearchPageStep;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FilterDisplayedTest extends BaseTest {

    private static final String CITY_NAME = "San Francisco, CA";

    /**
     * check that city is displayed in input field on home page are equals entered in input field city on search page
     */
    @Test
    public void savedSearch() {
        SearchPageStep searchPageStep = homePageStep.enterCityName(CITY_NAME)
                .clickSearchButton();
        Assert.assertTrue(searchPageStep.isEnteredCityEqualsShownInInputFieldCity(CITY_NAME),
                "City is displayed in input field are not equals entered city");
    }

}
