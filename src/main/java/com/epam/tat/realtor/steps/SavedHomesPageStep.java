package com.epam.tat.realtor.steps;

import com.epam.tat.realtor.pages.SavedHomesPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class SavedHomesPageStep extends BasePageStep {
    private SavedHomesPage savedHomesPage;

    public SavedHomesPageStep(WebDriver driver) {
        super(driver);
        savedHomesPage = new SavedHomesPage(driver);
    }

    /**
     * performing the operation of the transition to the 'My Profile' page
     *
     * @return new MyProfilePageStep
     */
    public MyProfilePageStep goToMyProfileSection() {
        savedHomesPage.clickMyProfileLink();
        return new MyProfilePageStep(driver);
    }

    /**
     * click on Saved Searches link to open saved searches page
     *
     * @return new SavedSearchesPageStep
     */
    public SavedSearchesPageStep clickSavedSearchesLink() {
        savedHomesPage.clickSavedSearches();
        return new SavedSearchesPageStep(driver);
    }

    /**
     * clear all saved homes in saved homes section
     * return back on home page
     *
     * @return new HomePage
     */
    public HomePageStep clearSavedHomes() {
        if (!savedHomesPage.getSaveHomesButtonList().isEmpty()) {
            savedHomesPage.clickLayerToStartDelete();
            for (int j = savedHomesPage.getSaveHomesButtonList().size(); j >0; j--) {
                driver.findElement(By.xpath("(//button[@data-label='pc-save-cta']/span/i[2])[" + j + "]")).click();
                savedHomesPage.clickDeleteButton();
            }
        }
        savedHomesPage.clickRealtorIcon();
        return new HomePageStep(driver);
    }

    /**
     * check number of saved homes
     *
     * @return saved homes list size
     */
    public int checkSavedHomes() {
        return savedHomesPage.getSaveHomesButtonList().size();
    }
}
