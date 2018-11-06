package com.epam.tat.realtor.steps;

import com.epam.tat.realtor.pages.FilterPage;
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

    public ViewSearchResultsPageStep clickViewResultsButton(){
        filterPage.clickViewResultsButton();
        return new ViewSearchResultsPageStep(driver);
    }

}
