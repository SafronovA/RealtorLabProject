package com.epam.tat.realtor.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyProfilePage extends BasePage {

    public MyProfilePage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//*[@id='header-login-menu']/li[1]")
    private WebElement userIcon;
    @FindBy(linkText = "Sign Out")
    private WebElement logOutLink;
    @FindBy(xpath = "//*[text()='Edit Profile']")
    private WebElement editProfileButton;
    @FindBy(xpath = "//*[@id='editFirstName']")
    private WebElement firstNameInput;
    @FindBy(xpath = "//*[@id='editLastName']")
    private WebElement lastNameInput;
    @FindBy(xpath = "//*[text()='Save Changes']")
    private WebElement saveChangesButton;
    @FindBy(xpath = "//*[@id='__next']//h2")
    private WebElement profileName;

    /**
     * navigate to user icon
     *
     * @return this page
     */
    public MyProfilePage navigateToUserIcon() {
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
     * click 'Edit Profile' button
     * @return this page
     */
    public MyProfilePage clickEditProfileButton(){
        waitUntilElementIsVisible(editProfileButton);
        waitUntilElementIsClickable(editProfileButton);
        editProfileButton.click();
        return this;
    }

    /**
     * enter first name in (@code firstNameInput)
     * @param firstName required first name
     * @return this page
     */
    public MyProfilePage enterFirstName(String firstName){
        firstNameInput.clear();
        firstNameInput.sendKeys(firstName);
        return this;
    }

    /**
     * enter last name in (@code lastNameInput)
     * @param lastName required last name
     * @return this page
     */
    public MyProfilePage enterLastName(String lastName){
        lastNameInput.clear();
        lastNameInput.sendKeys(lastName);
        return this;
    }

    /**
     * click 'Save Changes' button
     * @return this page
     */
    public MyProfilePage clickSaveChangesButton(){
        saveChangesButton.click();
        return this;
    }

    /**
     * @return current profile name
     */
    public String getProfileName(){
        String name = profileName.getAttribute("innerHTML");
        return name;
    }

    /**
     * @return WebElement (@code profileName)
     */
    public WebElement getProfileNameWebElement(){
        return profileName;
    }
}
