package com.epam.tat.realtor.steps;

import com.epam.tat.realtor.pages.MainPage;
import io.appium.java_client.AppiumDriver;

public class MainPageStep extends BasePageStep {
    private MainPage mainPage;

    public MainPageStep(AppiumDriver driver) {
        super(driver);
        mainPage = new MainPage(driver);
    }

    public MenuPageStep clickMenuButton() {
        mainPage.clickMenuButton();
        return new MenuPageStep(driver);
    }

    public MainPageStep clickSaveSearchButton() {
        mainPage.clickSaveSearchButton();
        return this;
    }

    public ViewSearchResultsPageStep openViewListPage() {
        mainPage.clickViewListButton();
        return new ViewSearchResultsPageStep(driver);
    }

    public FilterPageStep enterFilterSection() {
        mainPage.clickFilterButton();
        return new FilterPageStep(driver);
    }

    public int getSearchResultCount(){
        return mainPage.searchResultCount();
    }

    //    public FilterPageStep openFilter() {
//        mainPage.clickFilterButton();
//        return new FilterPageStep(driver);
//    }

//    public HomePageStep enterCity(String city) {
//        homePage.enterCity(city);
//        return this;
//    }

//    public ViewPageStep showListView() {
//        homePage.clickViewListButton();
//        return new ViewPageStep(driver);
//    }

}
