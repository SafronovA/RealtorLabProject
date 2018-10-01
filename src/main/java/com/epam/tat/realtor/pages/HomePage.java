package com.epam.tat.realtor.pages;

import com.epam.tat.realtor.ConfigProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage{

    public HomePage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//*[text()='Log In']")
    private WebElement signInButton;
    @FindBy(id = "email_address")
    private WebElement emailInput;
    @FindBy(id = "password")
    private WebElement passwordInput;
    @FindBy(id = "global_login_btn")
    private WebElement logInSubmitButton;
    @FindBy(xpath = "(//*[@id=\"header-navbar\"]//li)[1]")
    private WebElement userIcon;
    @FindBy(xpath = "//*[@id='logout']")
    private WebElement logOutLink;
    @FindBy(xpath = "(//a[contains(text(),'Saved Homes')])[1]")
    private WebElement savedHomesLink;
    @FindBy(linkText = "(//a[contains(text(),'Saved Searches')])[1]")
    private WebElement savedSearchLink;
    @FindBy(name = "q")
    private WebElement searchInput;
    @FindBy(xpath = "(//button[@class='btn btn-primary js-searchButton '])[1]")
    private WebElement searchButton;
    @FindBy(xpath = "//*[text()='Just Sold']")
    private WebElement justSoldButton;

    /**
     * click SignIn button
     * @return this page
     */
    public HomePage clickSignInButton(){
        signInButton.click();
        return this;
    }

    /**
     * enter user login in the email input
     * @return this page
     */
    public HomePage enterEmail(){
        emailInput.sendKeys(ConfigProperties.getTestProperty("userLogin"));
        return this;
    }
    /**
     * enter user password in password input
     * @return this page
     */
    public HomePage enterPassword(){
        passwordInput.sendKeys(ConfigProperties.getTestProperty("userPassword"));
        return this;
    }

    /**
     * click LogInSubmitl button
     * @return this page
     */
    public HomePage clickLoginSubmitButton(){
        logInSubmitButton.click();
        waitUntilElementIsVisible(userIcon);
        return this;
    }

    /**
     * navigate to user icon
     * @return this page
     */
    public HomePage navigateToUserIcon(){
        new Actions(driver).moveToElement(userIcon).perform();
        return this;
    }

    /**
     * wait for SignOut button to be visible
     * @return this page
     */
    public HomePage waitForSignOutLinkToAppear () {
        waitUntilElementIsVisible(logOutLink);
        return this;
    }

    /**
     * wait for SignIn button to be visible
     * @return this page
     */
    public HomePage waitForSignInLinkToAppear () {
        waitUntilElementIsVisible(signInButton);
        return this;
    }

    /**
     * click log out link in drop-down list, which appears after hovering the cursor on the user's logo
     * @return new HomePage
     */
    public HomePage clickLogOutLink () {
        logOutLink.click();
        return new HomePage(driver);
    }

    /**
     * wait until user icon become clickable
     * click user icon
     * @return  new SavedHomesPage
     */
    public SavedHomesPage clickUserIcon(){
        waitUntilElementIsVisible(userIcon);
        waitUntilElementIsClickable(userIcon);
        userIcon.click();
        return new SavedHomesPage(driver);
    }


}
