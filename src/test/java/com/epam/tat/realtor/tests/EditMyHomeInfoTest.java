package com.epam.tat.realtor.tests;

import com.epam.tat.realtor.steps.MyHomePageStep;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class EditMyHomeInfoTest extends BaseTest {
    private static final String BEDROOMS_ORIGINAL = "4";
    private static final String BATHROOMS_ORIGINAL = "3";
    private static final String CAR_SPACES_ORIGINAL = "1";
    private static final String SQ_FOOT_ORIGINAL = "3030";
    private static final String LOT_SIZE_ORIGINAL = "3485";
    private static final String BEDROOMS_NEW = "2";
    private static final String BATHROOMS_NEW = "1";
    private static final String CAR_SPACES_NEW = "3";
    private static final String SQ_FOOT_NEW = "2987";
    private static final String LOT_SIZE_NEW = "3781";

    private MyHomePageStep myHomePageStep;

    /**
     * perform login operation
     */
    @BeforeMethod
    public void logIn() {
        homePageStep.userLogIn();
    }

    /**
     * click my home button on home page
     * edit info of my home
     * check that home info changed correctly
     */
    @Test
    public void editHomeInfo() {
        myHomePageStep = homePageStep.clickMyHomeButton()
                .editHomeInfo(BEDROOMS_NEW, BATHROOMS_NEW, CAR_SPACES_NEW, SQ_FOOT_NEW, LOT_SIZE_NEW);

        Assert.assertTrue(myHomePageStep.bedroomsValueIsCorrect(BEDROOMS_NEW), "Bedrooms value has not changed to the required");
        Assert.assertTrue(myHomePageStep.bathroomsValueIsCorrect(BATHROOMS_NEW), "Bathrooms value has not changed to the required");
        Assert.assertTrue(myHomePageStep.carSpacesValueIsCorrect(CAR_SPACES_NEW), "Car spaces value has not changed to the required");
        Assert.assertTrue(myHomePageStep.sqFootValueIsCorrect(SQ_FOOT_NEW), "Sq.Foot value has not changed to the required");
        Assert.assertTrue(myHomePageStep.lotSizeIsCorrect(LOT_SIZE_NEW), "Lot size has not changed to the required");
    }

    /**
     * revert home information
     */
    @AfterMethod
    public void revertHomeInfo() {
        myHomePageStep.editHomeInfo(BEDROOMS_ORIGINAL, BATHROOMS_ORIGINAL, CAR_SPACES_ORIGINAL, SQ_FOOT_ORIGINAL, LOT_SIZE_ORIGINAL);
    }

}

