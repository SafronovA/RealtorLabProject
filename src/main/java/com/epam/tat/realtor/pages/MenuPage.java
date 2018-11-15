package com.epam.tat.realtor.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MenuPage extends BasePage {

    public MenuPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(className = "android.widget.LinearLayout")
    private AndroidElement menuSideBar;
    @AndroidFindBy(id = "com.move.realtor:id/menu_sign_in")
    private AndroidElement signInButton;
    @AndroidFindBy(id = "com.move.realtor:id/menu_item_settings")
    private List<AndroidElement> settingsButton;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.move.realtor:id/menu_item_start_new_search\")")
    private AndroidElement startNewSearch;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.move.realtor:id/menu_item_badge\")")
    private AndroidElement savedSearchButton;
    @AndroidFindBy(xpath = "(//android.widget.RelativeLayout[@resource-id='com.move.realtor:id/menu_item_entry'])[4]")
    private AndroidElement recentlySoldButton;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.move.realtor:id/menu_item_recently_viewed_listings\")")
    private AndroidElement recentlyViewedListingsButton;

    public SignInPage clickSignInButton() {
        signInButton.click();
        return new SignInPage(driver);
    }

    public SettingsPage clickSettingsButton() {
        waitUntilElementIsVisible(menuSideBar);
        settingsButton.get(0).click();
        return new SettingsPage(driver);
    }

    public List<AndroidElement> getSettingsButton() {
        return settingsButton;
    }

    public SearchPage clickStartNewSearch() {
        startNewSearch.click();
        return new SearchPage(driver);
    }

    public SavedSearchPage clickSavedSearch() {
        waitUntilElementIsVisible(savedSearchButton);
        savedSearchButton.click();
        return new SavedSearchPage(driver);
    }

    public SearchPage clickNewSearchButton() {
        startNewSearch.click();
        return new SearchPage(driver);
    }

    public MainPage clickRecentlySoldButton() {
        recentlySoldButton.click();
        return new MainPage(driver);
    }

    public RecentlyViewedListingsPage clickRecentlyViewedListings(){
        recentlyViewedListingsButton.click();
        return new RecentlyViewedListingsPage(driver);
    }

}
