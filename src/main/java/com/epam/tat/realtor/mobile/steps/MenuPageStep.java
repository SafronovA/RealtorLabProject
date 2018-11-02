package com.epam.tat.realtor.mobile.steps;

import com.epam.tat.realtor.mobile.pages.MenuPage;
import io.appium.java_client.AppiumDriver;

public class MenuPageStep extends BasePageStep {

    private MenuPage menuPage;

    public MenuPageStep(AppiumDriver appiumDriver) {
        super(appiumDriver);
        menuPage = new MenuPage(appiumDriver);
    }

    public SearchPageStep clickStartNewSearch(){
        menuPage.clickStartNewSearch();
        return new SearchPageStep(appiumDriver);
    }

    public SavedSearchPageStep clickSavedSearchButton(){
        menuPage.clickSavedSearch();
        return new SavedSearchPageStep(appiumDriver);
    }

}
