package com.epam.tat.realtor.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class MenuPage extends BasePage {

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.move.realtor:id/menu_item_start_new_search\")")
    private AndroidElement startNewSearch;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.move.realtor:id/menu_item_badge\")")
    private AndroidElement savedSearchButton;

    public MenuPage(AppiumDriver driver){
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(20)), this);
    }

    public HomePage clickStartNewSearch(){
        startNewSearch.click();
        return new HomePage(driver);
    }

    public SavedSearchPage clickSavedSearch(){
        waitUntilElementIsVisible(savedSearchButton);
        savedSearchButton.click();
        return new SavedSearchPage(driver);
    }

}