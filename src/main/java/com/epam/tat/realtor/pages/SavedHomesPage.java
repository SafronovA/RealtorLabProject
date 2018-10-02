package com.epam.tat.realtor.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class SavedHomesPage extends BasePage {

    public SavedHomesPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    By pageLayer = By.xpath("//div[@class='modal fade modal-hero modal-mobile-fullscreen js-modal-lazyload-assets modalOverlayBase_after-open']");
    @FindBy(linkText = "Saved Searches")
    private WebElement savedSearches;
    @FindBy(xpath = "//button[@data-label='pc-save-cta']/span/i[2]")
    private List<WebElement> saveHomesButtonList;
    @FindBy(xpath = "(//div[contains(@class,'ReactModalPortal')])//div[2]//button")
    private WebElement deleteButton;
    @FindBy(xpath = "//div[@class='modal fade modal-hero modal-mobile-fullscreen js-modal-lazyload-assets modalOverlayBase_after-open']")
    private WebElement strangeWindowLayer;
    @FindBy(xpath = "//a[@id='header-rdc-logo']/*")
    private WebElement realtorIcon;
    @FindBy(xpath = "//*[text()='My Profile']")
    private WebElement myProfileLink;

    /**
     * get saved homes button list
     * @return saved homes button list
     */
    public List<WebElement> getSaveHomesButtonList(){
        return saveHomesButtonList;
    }

    /**
     * no comments =)
     * @return
     */
    public WebElement getStrangeWindowLayer(){
        return strangeWindowLayer;
    }
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
    /**
     * click 'My Profile' link
     * @return new MyProfilePage
     */
    public MyProfilePage clickMyProfileLink(){
        myProfileLink.click();
        return new MyProfilePage(driver);
    }

    /**
     * click delete button on the delete saved home alert window
     * @return this page
     */
    public SavedHomesPage clickDeleteButton(){
        waitUntilElementIsClickable(deleteButton);
        deleteButton.click();
        new Actions(driver).click().click().click().perform();
        driverWait.until(ExpectedConditions.invisibilityOfElementLocated(pageLayer));
        return this;
    }

    /**
     * navigate to home page
     * @return new home page
     */

    public HomePage clickRealtorIcon(){
        realtorIcon.click();
        return new HomePage(driver);
    }
}
