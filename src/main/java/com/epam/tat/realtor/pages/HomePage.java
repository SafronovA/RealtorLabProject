package com.epam.tat.realtor.pages;

import com.epam.tat.realtor.ConfigProperties;
import org.openqa.selenium.By;
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
    @FindBy(id = "global_login_btn")
    private WebElement logInSubmitButton;
    @FindBy(xpath = "//*[@id='my-account-url']/following-sibling::span[1]")
    private WebElement userIcon;
    @FindBy(xpath = "//*[@id='logout']")
    private WebElement logOutLink;
    @FindBy(xpath = "//a[contains(text(),'Saved Homes')]")
    private WebElement savedHomesLink;
    @FindBy(xpath = "//*[@id='my_search_div']/div/a")
    private WebElement savedSearchLink;
    @FindBy(xpath = "//*[@id='searchBox']")
    private WebElement searchInput;
    @FindBy(xpath = "(//button[@class='btn btn-primary js-searchButton '])[1]")
    private WebElement searchButton;
    @FindBy(xpath = "//*[text()='Just Sold']")
    private WebElement rentButton;
    @FindBy(xpath = "//li[@id='img_far']/a")
    private WebElement realtorButton;
    @FindBy(xpath = "//a[contains(@class,'js-save-listing btn-save-listing js-save-trigger ')]//i[2]")
    private List<WebElement> heartIconsList;
    @FindBy(xpath = "//*[@id='img_mortgage']/a")
    private WebElement mortgageLink;
    @FindBy(linkText = "Mortgage Calculator")
    private WebElement mortgageCalculatorLink;

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
        emailInput.sendKeys(ConfigProperties.getTestProperty("userLogin"));
        return this;
    }

    /**
     * enter user password in password input
     *
     * @return this page
     */
    public HomePage enterPassword() {
        passwordInput.sendKeys(ConfigProperties.getTestProperty("userPassword"));
        return this;
    }

    /**
     * click LogInSubmitl button
     *
     * @return this page
     */
    public HomePage clickLoginSubmitButton() {
        logInSubmitButton.click();
        return this;
    }

    /**
     * navigate to user icon
     *
     * @return this page
     */
    public HomePage navigateToUserIcon() {
        new Actions(driver).moveToElement(userIcon).perform();
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
        searchInput.sendKeys(city);
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
     * click log out link in drop-down list, which appears after hovering the cursor on the user's logo
     *
     * @return new HomePage
     */
    public HomePage clickLogOutLink() {
        waitUntilElementIsVisible(logOutLink);
        logOutLink.click();
        return this;
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
        waitUntilElementIsClickable(realtorButton);
        realtorButton.click();
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

}
