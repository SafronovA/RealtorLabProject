package com.epam.tat.realtor.steps;

import com.epam.tat.realtor.pages.MainPage;
import io.appium.java_client.AppiumDriver;

public class MainPageStep extends BasePageStep {
    private MainPage mainPage;

    public MainPageStep(AppiumDriver driver) {
        super(driver);
        mainPage = new MainPage(driver);
    }


    public MenuPageStep clickMenu() {
        mainPage.clickMenuButton();
        return new MenuPageStep(driver);
    }

    public FilterPageStep openFilter() {
        mainPage.clickFilterButton();
        return new FilterPageStep(driver);
    }

    public ViewSearchResultsPageStep openViewListPage() {
        mainPage.clickViewListButton();
        return new ViewSearchResultsPageStep(driver);
    }

    public int getSearchResultCount(){
        return mainPage.searchResultCount();
    }


}
