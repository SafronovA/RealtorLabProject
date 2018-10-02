package com.epam.tat.realtor.tests;

import com.epam.tat.realtor.pages.SearchPage;
import com.epam.tat.realtor.steps.HomePageStep;
import com.epam.tat.realtor.steps.SavedHomesPageStep;
import com.epam.tat.realtor.steps.SearchPageStep;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class SavedHomesTest extends BaseTest {
    public final String CITY_NAME="Berkeley, CA";
    private final String MIN_PRICE_VALUE = "$250k";
    private final String MAX_PRICE_VALUE = "$900k";

    @BeforeMethod (groups = "LogIn")
    public void logIn(){
            homePageStep.userLogIn();
    }
    @BeforeMethod (dependsOnGroups = "LogIn")
    public void clearSavedHomes(){
        SavedHomesPageStep savedHomesPageStep = homePageStep.clickUserIcon();
        homePageStep=savedHomesPageStep.clearSavedHomes();
    }
    @Test
    public void checkSavedHomes(){
        int savedHomes = homePageStep.saveHomes();
        SavedHomesPageStep savedHomesPageStep = homePageStep.clickUserIcon();
        assertEquals(savedHomes, savedHomesPageStep.checkSavedHomes(), "saved homes number in saved homes section mismatch number of saved homes on the search page");
    }
    @AfterMethod
    public void clearResources(){
        new SavedHomesPageStep(driver).clearSavedHomes();
    }
}
