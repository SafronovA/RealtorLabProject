package com.epam.tat.realtor.mobile.steps;

import com.epam.tat.realtor.mobile.pages.SearchPage;
import io.appium.java_client.AppiumDriver;

public class SearchPageStep extends BasePageStep {

    private SearchPage searchPage;

    public SearchPageStep(AppiumDriver appiumDriver){
        super(appiumDriver);
        searchPage = new SearchPage(appiumDriver);
    }

    public MenuPageStep clickMenuButton(){
        searchPage.clickMenuButton();
        return new MenuPageStep(appiumDriver);
    }

    public SearchPageStep enterCity(String city){
        searchPage.enterCity(city);
        return this;
    }

    public SearchPageStep clickSaveSearchButton(){
        searchPage.clickSaveSearchButton();
        return this;
    }

}
