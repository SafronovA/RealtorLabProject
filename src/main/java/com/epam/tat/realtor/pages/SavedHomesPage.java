package com.epam.tat.realtor.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SavedHomesPage extends BasePage {

    public SavedHomesPage (WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(linkText = "Saved Searches")
    private WebElement savedSearches;

    public SavedSearchesPage clickSavedSearches(){
        waitUntilElementIsClickable(savedSearches);
        savedSearches.click();
        return new SavedSearchesPage(driver);
    }
}
