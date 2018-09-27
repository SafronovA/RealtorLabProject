package com.epam.tat.realtor.steps;

import com.epam.tat.realtor.pages.SavedHomesPage;
import org.openqa.selenium.WebDriver;

public class SavedHomesPageStep extends BasePageStep {
    private SavedHomesPage savedHomesPage;

    public SavedHomesPageStep(WebDriver driver){
        super(driver);
        savedHomesPage = new SavedHomesPage(driver);
    }

    /**
     * performing the operation of the transition to the 'My Profile' page
     * @return new MyProfilePageStep
     */
    public MyProfilePageStep goToMyProfileSection(){
        savedHomesPage.clickMyProfileLink();
        return new MyProfilePageStep(driver);
    }
}
