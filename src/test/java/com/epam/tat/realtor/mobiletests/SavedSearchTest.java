package com.epam.tat.realtor.mobiletests;

import com.epam.tat.realtor.mobile.steps.SavedSearchPageStep;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class SavedSearchTest extends BaseTest {

    private static final String CITY = "San Francisco";
    private SavedSearchPageStep savedSearchPageStep;

    @Test
    public void savedSearch() {
        savedSearchPageStep = homePageStep.clickMenuButton()
                .clickStartNewSearch()
                .enterCity(CITY)
                .clickSaveSearchButton()
                .clickMenuButton()
                .clickSavedSearchButton();
        Assert.assertTrue(savedSearchPageStep.doesSavedSearchDescriptionContainsEnteredCity(CITY),
                "do not contains entered text");
    }

    @AfterMethod
    public void deleteSavedSearch(){
        savedSearchPageStep.deleteSavedSearches();
    }

}
