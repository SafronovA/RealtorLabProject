package com.epam.tat.realtor.web.pages;

import com.epam.tat.realtor.web.ConfigProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    private By strangeLayer = By.id("loginModal");
    @FindBy(linkText = "Log In")
    private WebElement signInButton;
    @FindBy(id = "email_address")
    private WebElement emailInput;
    @FindBy(id = "password")
    private WebElement passwordInput;
    //    @FindBy(xpath = "//span[contains(@class,'global-account-')]")
    @FindBy(xpath = "//*[@class='dropdown-toggle disabled dropdown-toggle-desktop']")
    private WebElement userIcon;
    @FindBy(linkText = "Sign Out")
    private WebElement logOutLink;
    //    @FindBy(xpath = "//input[contains(@id,'downshift')]")
    @FindBy(xpath = "//input[@id='searchBox']")
    private WebElement searchInput;
    //    @FindBy(xpath = "//button[contains(@class,'search-btn')]")
    @FindBy(xpath = "//span[text()='Search']")
    private WebElement searchButton;
    @FindBy(xpath = "//*[text()='Just Sold']")
    private WebElement rentButton;
    @FindBy(xpath = "//li[@id='img_far']/a")
    private WebElement realtorButton;
    @FindBy (xpath = "//li/a[contains(text(),'HOME')]")
    private WebElement homeEstimate;
    //    @FindBy(xpath = "//a[@title='Find a realtor']")
    @FindBy(xpath = "//a[@data-omtag='header-menu:realtors']")
    private WebElement findRealtorButton;
    @FindBy(xpath = "//button[@data-label='pc-save-cta']")
    private List<WebElement> heartIconsList;
    @FindBy(linkText = "Mortgage")
    private WebElement mortgageLink;
    @FindBy(linkText = "Mortgage Calculator")
    private WebElement mortgageCalculatorLink;
    @FindBy(linkText = "My Home")
    private WebElement myHomeButton;


    /**
     * get heart icons list on the homes for sale cards
     *
     * @return heart icons list
     */
    public List<WebElement> getHeartIconsList() {
        return heartIconsList;
    }

    /**
     * click SignIn button
     *
     * @return this page
     */
    public HomePage clickSignInButton() {
        waitUntilElementIsVisible(signInButton);
        signInButton.click();
        return this;
    }

    /**
     * enter user login in the email input
     *
     * @return this page
     */
    public HomePage enterEmail() {
        emailInput.click();
        emailInput.sendKeys(ConfigProperties.getTestProperty("userLogin"));
        return this;
    }

    /**
     * enter user password in password input
     *
     * @return this page
     */
    public HomePage enterPassword() {
        passwordInput.click();
        passwordInput.sendKeys(ConfigProperties.getTestProperty("userPassword"));
        return this;
    }

    /**
     * perform logIn operation
     *
     * @return this page
     */
    public HomePage clickLoginSubmitButton() {
        new Actions(driver).sendKeys(Keys.ENTER).perform();
        return this;
    }

    /**
     * clear city entered by default
     *
     * @return this page
     */
    public HomePage clearInputField() {
        waitUntilElementIsVisible(searchInput);
        searchInput.clear();
        return this;
    }

    /**
     * enter city in input search field
     *
     * @param city
     * @return this page
     */
    public HomePage enterCityInMainSearchInput(String city) {
        searchInput.click();
        searchInput.sendKeys(city);
        searchInput.click();
        return this;
    }

    /**
     * click search button
     *
     * @return new search page
     */
    public SearchPage clickSearchButton() {
        waitUntilElementIsClickable(searchButton);
        searchButton.click();
        return new SearchPage(driver);
    }

    /**
     * wait until user icon become clickable
     * click user icon
     *
     * @return new SavedHomesPage
     */
    public SavedHomesPage clickUserIcon() {
        waitInvisibilityOfElementLocated(strangeLayer);
        userIcon.click();
        return new SavedHomesPage(driver);
    }

    /**
     * click on the Realtor button
     *
     * @return new FindRealtorPage
     */
    public FindRealtorPage clickRealtorButton() {
        waitUntilElementIsClickable(findRealtorButton);
        clickByJEx(findRealtorButton, driver);
        return new FindRealtorPage(driver);
    }

    /**
     * navigate cursor on mortgage calculator to show drop-down menu
     *
     * @return this page
     */
    public HomePage navigateCursorOnMortgageLink() {
        new Actions(driver).moveToElement(mortgageLink).perform();
        return this;
    }

    /**
     * click on mortgage calculator link
     *
     * @return new MortgageCalculatorPage
     */
    public MortgageCalculatorPage clickMortgageCalculatorLink() {
        mortgageCalculatorLink.click();
        return new MortgageCalculatorPage(driver);
    }

    /**
     * click on the My Home button
     *
     * @return new MyHomePage
     */
    public MyHomePage clickMyHomeButton() {
        waitInvisibilityOfElementLocated(strangeLayer);
        myHomeButton.click();
        return new MyHomePage(driver);
    }


    /**
     * click HomeEstimate section
     */
    public HomePage clickHomeEstimate() {
        waitUntilElementIsClickable(homeEstimate);
        homeEstimate.click();
        return this;
    }
}
