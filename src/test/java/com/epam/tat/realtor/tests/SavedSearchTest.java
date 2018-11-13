package com.epam.tat.realtor.tests;

import com.epam.tat.realtor.steps.SavedSearchPageStep;
import com.epam.tat.realtor.util.ConfigProperties;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SavedSearchTest extends BaseTest {

    private static final String CITY = "San Francisco";
    private SavedSearchPageStep savedSearchPageStep;

//    @BeforeClass
//    public void changeImplisityWait(){
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//
//    }
    @Test
    public void savedSearch() {
        savedSearchPageStep = mainPageStep.clickMenuButton()
                .clickStartNewSearch()
                .enterSearchCity(CITY)
//                .enterCity(CITY)
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
