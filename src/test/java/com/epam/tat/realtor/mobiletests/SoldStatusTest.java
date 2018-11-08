package com.epam.tat.realtor.mobiletests;

import com.epam.tat.realtor.mobilesteps.ViewPageStep;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SoldStatusTest extends MobileFarm{
    private final String CITY_NAME = "San Francisco, CA";
    private final String MIN_PRICE_VALUE = "370000";
    private final String MAX_PRICE_VALUE = "475000";


    @Test
    void checkHomeStatus() throws InterruptedException {
        ViewPageStep viewPageStep =homePageStep.enterMenuSection()
                .startNewSearch()
                .enterSearchCity(CITY_NAME)
                .enterFilterSection()
                .createFilterRequest(MIN_PRICE_VALUE,MAX_PRICE_VALUE).enterMenuSection().selectSoldStatus().showListView();
        Assert.assertTrue(viewPageStep.checkSoldStatus());

    }
}
