package com.epam.tat.realtor.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SavedHomesPage extends BasePage {

    public SavedHomesPage (WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(linkText = "Saved Searches")
    private WebElement savedSearches;
    @FindBy(xpath = "//button[@data-label='pc-save-cta']/span/i[2]")
    private List<WebElement> saveHomesButtonList;
    @FindBy(xpath = "//button[text()='Delete']")
    private WebElement deleteButton;
    @FindBy(xpath = "//div[@class='modal fade modal-hero modal-mobile-fullscreen js-modal-lazyload-assets modalOverlayBase_after-open']")
    private WebElement strangeWindowLayer;
    @FindBy(xpath = "//a[@id='header-rdc-logo']/*")
    private WebElement realtorIcon;

    /**
     * click on saved searches link and go in saved searches page
     * @return new SavedSearchesPage
     */
    public SavedSearchesPage clickSavedSearches(){
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

    public List<WebElement> getSaveHomesButtonList(){
        return saveHomesButtonList;
    }
    public SavedHomesPage clickDeleteButton(){
        waitUntilElementIsClickable(deleteButton);
        deleteButton.click();
        return this;
    }
    public WebElement getStrangeWindowLayer(){
        return strangeWindowLayer;
    }
    public HomePage clickRealtorIcon(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        realtorIcon.click();
        return new HomePage(driver);
    }
}
