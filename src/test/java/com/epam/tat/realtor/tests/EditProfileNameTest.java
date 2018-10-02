package com.epam.tat.realtor.tests;

import com.epam.tat.realtor.ConfigProperties;
import com.epam.tat.realtor.steps.MyProfilePageStep;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class EditProfileNameTest extends BaseTest {
    private MyProfilePageStep myProfilePageStep;

    private String firstNameOrigin = "Loko";
    private String lastNameOrigin = "ko";
    private String firstNameNew = "New_Lo";
    private String lastNameNew = "New_ko";

    @BeforeMethod
    public void logIn() {
        homePageStep.userLogIn();
    }

    /**
     * testing the correctness of username changing
     */
    @Test
    public void editProfileName(){
        myProfilePageStep = homePageStep.clickUserIcon()
                                        .goToMyProfileSection()
                                        .editName(firstNameNew, lastNameNew);
        Assert.assertTrue(myProfilePageStep.nameIsCorrect(firstNameNew+lastNameNew), "Profile name has not changed to the required");
    }

    /**
     * revert profile name and logout
     */
    @AfterMethod
    public void revertProfileName(){

        myProfilePageStep.editName(firstNameOrigin, lastNameOrigin)
                .logOut();
    }

}
