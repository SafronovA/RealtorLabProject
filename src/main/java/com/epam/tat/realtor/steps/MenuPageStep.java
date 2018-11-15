package com.epam.tat.realtor.steps;

import com.epam.tat.realtor.pages.MenuPage;
import io.appium.java_client.AppiumDriver;

public class MenuPageStep extends BasePageStep{
    private MenuPage menuPage;

    public MenuPageStep(AppiumDriver driver) {
        super(driver);
        menuPage= new MenuPage(driver);
    }

    public SignInPageStep clickSignInButton(){
        menuPage.clickSignInButton();
        return new SignInPageStep(driver);
    }

    public SettingsPageStep clickSettingsButton(){
        swipeUntilElementBecomeVisible(driver, menuPage.getSettingsButton());
        menuPage.clickSettingsButton();
        return new SettingsPageStep(driver);
    }

    public SearchPageStep clickStartNewSearch() {
        menuPage.clickStartNewSearch();
        return new SearchPageStep(driver);
    }

    public SavedSearchPageStep clickSavedSearchButton() {
        menuPage.clickSavedSearch();
        return new SavedSearchPageStep(driver);
    }

    public MainPageStep  selectSoldStatus() {
        menuPage.clickRecentlySoldButton();
        return new MainPageStep(driver);
    }

    public RecentlyViewedListingsPageStep clickRecentlyViewedListingsButton(){
        menuPage.clickRecentlyViewedListings();
        return new RecentlyViewedListingsPageStep(driver);
    }

//    public SearchPageStep  startNewSearch() {
//        menuPage.clickNewSearchButton();
//        return new SearchPageStep(driver);
//    }
}
