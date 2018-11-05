package com.epam.tat.realtor.tests_mob;

import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.Set;

public class NumberOfHousesFoundTest extends BaseTest {
    private final String CITY = "Wildwood, NJ";
    private final String MIN_PRICE = "450000";
    private final String MAX_PRICE = "500000";

    @Test
    public void numberOfHousesFound() {
        int expectedNumberOfHousesFound = homePageStep.openFilter()
                .enterPriceRange(MIN_PRICE, MAX_PRICE)
//                .enterCity(CITY)
                .clickViewResultsButton()
                .getSearchResultCount();
        System.out.println(expectedNumberOfHousesFound);
//        int actualNumberOfHousesFound = homePageStep.openHousesList().getNumberOfAllHousesFromScreen();
//        System.out.println(actualNumberOfHousesFound);

        homePageStep.openHousesList().HFS();
    }


}

