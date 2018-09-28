package com.epam.tat.realtor.steps;

import com.epam.tat.realtor.pages.SavedHomesPage;
import org.openqa.selenium.WebDriver;

public class SavedHomesPageStep extends BasePageStep {

    private SavedHomesPage savedHomesPage;

    public SavedHomesPageStep(WebDriver driver) {
        super(driver);
        savedHomesPage = new SavedHomesPage(driver);
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

}
