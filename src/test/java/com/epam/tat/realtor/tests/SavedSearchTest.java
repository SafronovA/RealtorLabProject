package com.epam.tat.realtor.tests;

import com.epam.tat.realtor.steps.SavedSearchPageStep;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class SavedSearchTest extends BaseTest {

    private static final String CITY = "San Francisco";
    private SavedSearchPageStep savedSearchPageStep;

    @Test
    public void savedSearch() {
        savedSearchPageStep = mainPageStep.clickMenuButton()
                .clickStartNewSearch()
                .enterSearchCity(CITY)
                .clickSaveSearchButton()
                .clickMenuButton()
                .clickSavedSearchButton();
        Assert.assertTrue(savedSearchPageStep.doesSavedSearchDescriptionContainsEnteredCity(CITY),
                "Saved search does not contain entered text");
    }

    @AfterMethod
    public void deleteSavedSearch() {
        savedSearchPageStep.deleteSavedSearches();
    }

}
