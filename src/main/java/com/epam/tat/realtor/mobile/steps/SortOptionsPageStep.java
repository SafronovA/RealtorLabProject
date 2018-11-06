package com.epam.tat.realtor.mobile.steps;

import com.epam.tat.realtor.mobile.pages.SortOptionsPage;
import io.appium.java_client.AppiumDriver;

public class SortOptionsPageStep extends BasePageStep {

    private SortOptionsPage sortOptionsPage;

    public SortOptionsPageStep(AppiumDriver driver) {
        super(driver);
        sortOptionsPage = new SortOptionsPage(driver);
    }

    public ViewSearchResultsPageStep selectLowToHighSortOption(){
        sortOptionsPage.selectLowToHighSortOption();
        return new ViewSearchResultsPageStep(driver);
    }
}
