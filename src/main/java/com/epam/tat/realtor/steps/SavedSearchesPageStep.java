package com.epam.tat.realtor.steps;

import com.epam.tat.realtor.pages.SavedSearchesPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SavedSearchesPageStep extends BasePageStep {

    private SavedSearchesPage savedSearchesPage;

    public SavedSearchesPageStep(WebDriver driver) {
        super(driver);
        savedSearchesPage = new SavedSearchesPage(driver);
    }

    public SavedSearchesPageStep clearAllOldSavedSearches(){
        if(!savedSearchesPage.getSavedSearchesList().isEmpty()) {
            savedSearchesPage.getSavedSearchesList().stream().forEach(WebElement -> savedSearchesPage.clickDeleteButton());
        }
        return this;
    }

    public HomePageStep moveToHomePage(){
        savedSearchesPage.moveToHomePage();
        return new HomePageStep(driver);
    }

}
