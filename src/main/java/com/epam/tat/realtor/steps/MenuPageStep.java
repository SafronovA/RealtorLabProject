package com.epam.tat.realtor.steps;

import com.epam.tat.realtor.pages.MenuPage;
import io.appium.java_client.AppiumDriver;

public class MenuPageStep extends BasePageStep {

    private MenuPage menuPage;

    public MenuPageStep(AppiumDriver driver) {
        super(driver);
        menuPage = new MenuPage(driver);
    }

    public HomePageStep clickStartNewSearch() {
        menuPage.clickStartNewSearch();
        return new HomePageStep(driver);
    }

    public SavedSearchPageStep clickSavedSearchButton() {
        menuPage.clickSavedSearch();
        return new SavedSearchPageStep(driver);
    }
    public SearchPageStep  startNewSearch() {
        menuPage.clickNewSearchButton();
        return new SearchPageStep(driver);
    }


}
