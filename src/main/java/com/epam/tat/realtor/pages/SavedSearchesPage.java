package com.epam.tat.realtor.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class SavedSearchesPage extends BasePage {

    public SavedSearchesPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    private final static String XPATH_CONFIRM_DELETE_BUTTON = "(//div[contains(@class,'ReactModalPortal')])//div[2]//button";
    @FindBy(xpath = "//a[contains(@title,'delete this saved card')]")
    private WebElement deleteButton;
    @FindBy(xpath = "//div[contains(@class,'card-padding')]")
    private List<WebElement> savedSearchesList;
    @FindBy(xpath = "(//div[contains(@class,'ReactModalPortal')])//div[2]//button")
    private WebElement confirmDeleteButton;
    @FindBy(xpath = "//*[@id='__next']//div[2]//div[4]/h4/div")
    private WebElement cardTextCity;
    @FindBy(xpath = "//*[@id='__next']//div[2]//div[4]/h4/div[2]")
    private WebElement cardTextPrice;
    @FindBy(xpath = "//*[@id='header-navbar']//ul//span")
    private WebElement userIcon;
    @FindBy(linkText = "Sign Out")
    private WebElement logOutLink;
    @FindBy(xpath = "//*[@id='header-rdc-logo']/svg")
    private WebElement logo;
    @FindBy(xpath = "//*[@id='header-rdc-logo']")
    private WebElement homePageLink;

    /**
     * get saved searches list
     *
     * @return list of searches
     */
    public List<WebElement> getSavedSearchesList() {
        return savedSearchesList;
    }

    /**
     * click delete button
     *
     * @return this page
     */
    public SavedSearchesPage clickDeleteButton() {
        deleteButton.click();
        return this;
    }

    /**
     * confirm saved search deleting
     *
     * @return
     */
    public SavedSearchesPage clickConfirmDeleteButton() {
        confirmDeleteButton.click();
        driverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(XPATH_CONFIRM_DELETE_BUTTON)));
        return this;
    }

    /**
     * get city from saved search description
     *
     * @return
     */
    public String getCity() {
        return cardTextCity.getText();
    }

    /**
     * get prices from saved search description
     *
     * @return
     */
    public String getPrice() {
        return cardTextPrice.getText();
    }

    /**
     * navigate to user icon
     *
     * @return this page
     */
    public SavedSearchesPage navigateToUserIcon() {
        new Actions(driver).moveToElement(userIcon).perform();
        return this;
    }

    /**
     * click log out link in drop-down list, which appears after hovering the cursor on the user's logo
     *
     * @return new HomePage
     */
    public HomePage clickLogOutLink() {
        waitUntilElementIsClickable(logOutLink);
        logOutLink.click();
        return new HomePage(driver);
    }

    /**
     * go to home page
     *
     * @return new HomePage(driver)
     */
    public HomePage clickHomePageLink(){
        homePageLink.click();
        return new HomePage(driver);
    }

}
