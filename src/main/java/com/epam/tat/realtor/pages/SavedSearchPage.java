package com.epam.tat.realtor.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.util.List;

public class SavedSearchPage extends BasePage {

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.move.realtor:id/title\")")
    private List<AndroidElement> savedSearch;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.move.realtor:id/tracks\")")
    private AndroidElement unsaveSearchButton;

    public SavedSearchPage(AppiumDriver driver){
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(20)), this);
    }

    public List<AndroidElement> getSavedSearchList(){
        return savedSearch;
    }

    public String getSavedSearchDescription(){
        return savedSearch.get(0).getText();
    }

    public SavedSearchPage clickUnSaveSearchButton(){
        waitUntilElementIsVisible(unsaveSearchButton);
        unsaveSearchButton.click();
        return this;
    }

}
