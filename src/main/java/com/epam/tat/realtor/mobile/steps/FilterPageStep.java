package com.epam.tat.realtor.mobile.steps;

import com.epam.tat.realtor.mobile.pages.FilterPage;
import io.appium.java_client.AppiumDriver;

public class FilterPageStep extends BasePageStep {

    private FilterPage filterPage;

    public FilterPageStep(AppiumDriver driver){
        super(driver);
        filterPage = new FilterPage(driver);
    }

    public FilterPageStep enterMinPrice(String minPrice){
        filterPage.enterMinPrice(minPrice);
        return this;
    }

    public FilterPageStep enterMaxPrice(String maxPrice){
        filterPage.enterMaxPrice(maxPrice);
        return this;
    }

    public ViewPageStep clickViewResultsButton(){
        filterPage.clickViewResultsButton();
        return new ViewPageStep(driver);
    }

}
