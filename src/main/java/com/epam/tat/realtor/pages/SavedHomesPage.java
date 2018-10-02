package com.epam.tat.realtor.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SavedHomesPage extends BasePage {

    public SavedHomesPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(linkText = "Saved Searches")
    private WebElement savedSearches;

    /**
     * click on saved searches link and go in saved searches page
     *
     * @return new SavedSearchesPage
     */
    public SavedSearchesPage clickSavedSearches() {
        waitUntilElementIsClickable(savedSearches);
        savedSearches.click();
        return new SavedSearchesPage(driver);
    }

    @FindBy(xpath = "//*[text()='My Profile']")
    private WebElement myProfileLink;

    /**
     * click 'My Profile' link
     * @return new MyProfilePage
     */
    public MyProfilePage clickMyProfileLink(){
        myProfileLink.click();
        return new MyProfilePage(driver);
    }
}
