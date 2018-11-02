package com.epam.tat.realtor.mobiletests;

import com.epam.tat.realtor.bo.House;
import com.epam.tat.realtor.mobilepages.HomePage;
import com.epam.tat.realtor.mobilepages.ViewPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class SearchTest extends BaseTest {
    private final String CITY_NAME = "New York, NY";
    private final String MIN_PRICE_VALUE = "370000";
    private final String MAX_PRICE_VALUE = "380000";
    @Test
    void search() {
        List<House> propertyList = homePageStep.enterMenuSection()
                .startNewSearch()
                .enterSearchCity(CITY_NAME)
                .enterFilterSection()
                .createFilterRequest(MIN_PRICE_VALUE,MAX_PRICE_VALUE).showListView().createPropertyList();
        System.out.println(propertyList.size());
        propertyList.forEach(x-> System.out.println(x.getPrice()+" "+x.getBedNumber()+" "+x.getBathNumber()));
        Assert.assertTrue(true);
        }
}
