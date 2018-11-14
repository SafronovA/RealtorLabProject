package com.epam.tat.realtor.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MyProfilePage extends BasePage {

    public MyProfilePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    private By strangeLayer = By.xpath("//div[@class='modal fade modal-hero modal-mobile-fullscreen js-modal-lazyload-assets modalOverlayBase_after-open']");
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
    @FindBy(xpath = "//*[@class='address-line'][1]")
    private WebElement profileAddress;
    @FindBy(xpath = "//*[@class='address-line'][2]")
    private WebElement profileCityAndState;
    @FindBy(xpath = "//*[@class='address-line'][3]")
    private WebElement profileCountry;
    @FindBy(id = "editAddress1")
    private WebElement addressInput;
    @FindBy(id = "editCity")
    private WebElement cityInput;
    @FindBy(xpath = "//*[@id='editState']/option")
    private List<WebElement> stateSelect;
    @FindBy(xpath = "//*[@id='editCountry']/option")
    private List<WebElement> countrySelect;

    /**
     * @return current profile name
     */
    public String getProfileName() {
        String name = profileName.getAttribute("innerHTML");
        return name;
    }

    /**
     * @return WebElement (@code profileName)
     */
    public WebElement getProfileNameWebElement() {
        return profileName;
    }

    /**
     * @return current profile address
     */
    public String getProfileAddress() {
        String address = profileAddress.getAttribute("innerHTML");
        return address;
    }

    /**
     * @return current profile cityAndState
     */
    public String getProfileCityAndState() {
        String cityAndState = profileCityAndState.getAttribute("innerHTML");
        return cityAndState;
    }

    /**
     * @return current profile country
     */
    public String getProfileCountry() {
        String country = profileCountry.getAttribute("innerHTML");
        return country;
    }

    /**
     * @return WebElement (@code profileAddress)
     */
    public WebElement getProfileAddressWebElement() {
        return profileAddress;
    }


    /**
     * @return WebElement (@code profileCityAndState)
     */
    public WebElement getProfileCityAndStateWebElement() {
        return profileCityAndState;
    }

    /**
     * @return WebElement (@code profileCountry)
     */
    public WebElement getProfileCountryWebElement() {
        return profileCountry;
    }

    /**
     * enter first name in (@code firstNameInput)
     *
     * @param firstName required first name
     * @return this page
     */
    public MyProfilePage enterFirstName(String firstName) {
        firstNameInput.clear();
        firstNameInput.sendKeys(firstName);
        return this;
    }

    /**
     * enter last name in (@code lastNameInput)
     *
     * @param lastName required last name
     * @return this page
     */
    public MyProfilePage enterLastName(String lastName) {
        lastNameInput.clear();
        lastNameInput.sendKeys(lastName);
        return this;
    }

    /**
     * enter address in (@code addressInput)
     *
     * @param address required address
     * @return this page
     */
    public MyProfilePage enterAddress(String address) {
        addressInput.clear();
        addressInput.sendKeys(address);
        return this;
    }

    /**
     * enter city in (@code cityInput)
     *
     * @param city required city
     * @return this page
     */
    public MyProfilePage enterCity(String city) {
        cityInput.clear();
        cityInput.sendKeys(city);
        return this;
    }

    /**
     * select state in (@code stateSelect)
     *
     * @param state required state
     * @return this page
     */
    public MyProfilePage enterState(String state) {
        stateSelect.stream().filter(webElement -> webElement.getAttribute("innerHTML").equals(state)).forEach(WebElement::click);
        return this;
    }

    /**
     * select country in (@code countrySelect)
     *
     * @param country required country
     * @return this page
     */
    public MyProfilePage enterCountry(String country) {
        countrySelect.stream().filter(webElement -> webElement.getAttribute("innerHTML").equals(country)).forEach(WebElement::click);
        return this;
    }

    /**
     * click 'Save Changes' button
     *
     * @return this page
     */
    public MyProfilePage clickSaveChangesButton() {
        saveChangesButton.click();
        return this;
    }

//    /**
//     * click log out link in drop-down list, which appears after hovering the cursor on the user's logo
//     *
//     * @return new HomePage
//     */
//    public HomePage clickLogOutLink() {
//        waitUntilElementIsClickable(logOutLink);
//        logOutLink.click();
//        return new HomePage(driver);
//    }

    /**
     * click 'Edit Profile' button
     *
     * @return this page
     */
    public MyProfilePage clickEditProfileButton() {
        waitInvisibilityOfElementLocated(strangeLayer);
        editProfileButton.click();
        return this;
    }

//    /**
//     * navigate to user icon
//     *
//     * @return this page
//     */
//    public MyProfilePage navigateToUserIcon() {
//        new Actions(driver).moveToElement(userIcon).perform();
//        return this;
//    }
}
