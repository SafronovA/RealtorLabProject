package com.epam.tat.realtor.mobile.steps;

import com.epam.tat.realtor.mobile.pages.SavedSearchPage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Point;

import java.util.List;
import java.util.stream.IntStream;

public class SavedSearchPageStep extends BasePageStep {

    private SavedSearchPage savedSearchPage;

    public SavedSearchPageStep(AppiumDriver appiumDriver) {
        super(appiumDriver);
        savedSearchPage = new SavedSearchPage(appiumDriver);
    }

    public boolean doesSavedSearchDescriptionContainsEnteredCity(String enteredCity) {
        return savedSearchPage.getSavedSearchDescription().contains(enteredCity);
    }

    public SavedSearchPageStep deleteSavedSearches() {
        List<AndroidElement> savedSearches = savedSearchPage.getSavedSearchList();
        int savedSearchedCount = savedSearches.size();
        IntStream.range(0, savedSearchedCount)
                .map(index -> savedSearchedCount - 1 - index)
                .forEach(index -> {
                    Point savedSearchLocation = savedSearches.get(index).getLocation();
                    new TouchAction(appiumDriver).longPress(PointOption.point(savedSearchLocation.x+50, savedSearchLocation.y+50)).perform();
                    savedSearchPage.clickUnSaveSearchButton();
                });
        return this;
    }

}
