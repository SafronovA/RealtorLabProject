package com.epam.tat.realtor.mobiletests;

import com.epam.tat.realtor.bo.House;
import com.epam.tat.realtor.mobilepages.HomePage;
import com.epam.tat.realtor.mobilepages.ViewPage;
import com.epam.tat.realtor.mobilesteps.ViewPageStep;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Set;

public class SearchTest extends BaseTest {
    private final String CITY_NAME = "New York, NY";
    private final String MIN_PRICE_VALUE = "370000";
    private final String MAX_PRICE_VALUE = "375000";
    private final int BED_QUANTITY = 2;
    private final int BATH_QUANTITY = 2;

    @Test
    void search() {
        ViewPageStep viewPageStep =homePageStep.enterMenuSection()
                .startNewSearch()
                .enterSearchCity(CITY_NAME)
                .enterFilterSection()
                .createFilterRequest(MIN_PRICE_VALUE,MAX_PRICE_VALUE).showListView().createPropertyList();
        Assert.assertTrue(viewPageStep.checkSearchResults(MIN_PRICE_VALUE,MAX_PRICE_VALUE,BATH_QUANTITY,BED_QUANTITY));

        }
}
