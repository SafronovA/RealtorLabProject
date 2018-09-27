package com.epam.tat.realtor.tests;

import com.epam.tat.realtor.ConfigProperties;
import com.epam.tat.realtor.steps.MyProfilePageStep;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class EditProfileNameTest extends BaseTest {
    private MyProfilePageStep myProfilePageStep;

    private String firstNameOrigin = "Loko";
    private String lastNameOrigin = "ko";
    private String firstNameNew = "New_Lo";
    private String lastNameNew = "New_ko";

    /**
     * testing the correctness of username changing
     */
    @Test
    public void editProfileName(){
        myProfilePageStep = homePageStep.userLogIn()
                                        .goToSavedHomesSection()
                                        .goToMyProfileSection()
                                        .editProfileName(firstNameNew, lastNameNew);
        Assert.assertTrue(myProfilePageStep.nameIsCorrect(firstNameNew+lastNameNew));
    }

    /**
     * revert profile name and logout
     */
    @AfterMethod(alwaysRun = true)
    public void revertProfileName(){
        driver.navigate().to(ConfigProperties.getTestProperty("url"));
        myProfilePageStep = homePageStep.goToSavedHomesSection()
                                        .goToMyProfileSection()
                                        .editProfileName(firstNameOrigin, lastNameOrigin);
        driver.navigate().to(ConfigProperties.getTestProperty("url"));
        homePageStep.logOut();
    }

}
