package com.epam.tat.realtor.tests;

import com.epam.tat.realtor.steps.SavedHomesPageStep;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class SavedHomesTest extends BaseTest {

    /**
     * user LogIn
     */
    @BeforeMethod(groups = "LogIn")
    public void logIn() {
        homePageStep.userLogIn();
    }

    /**
     * clear saved homes in the saved homes section
     */
    @BeforeMethod(dependsOnGroups = "LogIn")
    public void clearSavedHomes() {
        SavedHomesPageStep savedHomesPageStep = homePageStep.clickUserIcon();
        homePageStep = savedHomesPageStep.clearSavedHomes();
    }

    /**
     * save all homes on the main page,
     * go to saved homes section,
     * check if saved homes number match saved homes on the main page
     */
    @Test
    public void checkSavedHomes() {
        int savedHomes = homePageStep.saveHomes();
        SavedHomesPageStep savedHomesPageStep = homePageStep.clickUserIcon();
        assertEquals(savedHomes, savedHomesPageStep.checkSavedHomes(),
                "saved homes number in saved homes section mismatch number of saved homes on the search page");
    }

}
