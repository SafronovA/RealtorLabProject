package com.epam.tat.realtor.mobile.steps;

import com.epam.tat.realtor.mobile.pages.ViewPage;
import io.appium.java_client.AppiumDriver;

public class ViewPageStep extends BasePageStep {

    private ViewPage viewPage;

    public ViewPageStep(AppiumDriver driver){
        super(driver);
        viewPage = new ViewPage(driver);
    }

    public FilterPageStep clickFilterButton(){
        viewPage.clickFilterButton();
        return new FilterPageStep(driver);
    }

    public ViewPageStep selectLowToHighPriceSortOption(){
        viewPage.clickSortByButton();
        viewPage.selectLowToHighSortOption();
        return this;
    }

}
