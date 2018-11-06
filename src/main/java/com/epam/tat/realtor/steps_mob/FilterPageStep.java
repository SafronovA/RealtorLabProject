package com.epam.tat.realtor.steps_mob;

import com.epam.tat.realtor.pages_mob.FilterPage;
import io.appium.java_client.AppiumDriver;

public class FilterPageStep extends BasePageStep{
    private FilterPage filterPage;

    public FilterPageStep(AppiumDriver driver) {
        super(driver);
        filterPage = new FilterPage(driver);
    }

    public FilterPageStep enterCity(String city) {
        filterPage.clickClearCityIcon()
                .enterCity(city);
        return this;
    }

    public FilterPageStep enterPriceRange(String minPrice, String maxPrice) {
        filterPage.enterMinPrice(minPrice)
                .enterMaxPrice(maxPrice);
        return this;
    }

    public MainPageStep clickViewResultsButton() {
        filterPage.clickViewResultsButton();
        return new MainPageStep(driver);
    }
}
