package com.epam.tat.realtor.steps;

import com.epam.tat.realtor.pages.MyProfilePage;
import org.openqa.selenium.WebDriver;

public class MyProfilePageStep extends BasePageStep {

    private MyProfilePage myProfilePage;

    public MyProfilePageStep(WebDriver driver) {
        super(driver);
        myProfilePage = new MyProfilePage(driver);
    }

    /**
     * performs the operation of changing the profile name
     * click 'Edit Profile' button
     * enter first name
     * enter last name
     * click 'Save Changes' button
     * wait until the profile name changes to the desired one
     *
     * @param firstName required first name
     * @param lastName  required last name
     * @return this page
     */
    public MyProfilePageStep editName(String firstName, String lastName) {
        myProfilePage.clickEditProfileButton()
                .enterFirstName(firstName)
                .enterLastName(lastName)
                .clickSaveChangesButton();
        myProfilePage.waitUntilAttributeInnerHTMLToBe(myProfilePage.getProfileNameWebElement(), firstName + " " + lastName);
        return this;
    }

    /**
     * performs the operation of changing the profile name
     * click 'Edit Profile' button
     * enter country
     * enter address
     * enter city
     * enter state
     * click 'Save Changes' button
     * wait until the changed fields changes to the desired one
     *
     * @param address required address
     * @param city    required city
     * @param state   required state
     * @param country required country
     * @return this step
     */
    public MyProfilePageStep editAddress(String address, String city, String state, String country) {
        myProfilePage.clickEditProfileButton()
                .enterCountry(country)
                .enterAddress(address)
                .enterCity(city)
                .enterState(state)
                .clickSaveChangesButton();
        myProfilePage.waitUntilAttributeInnerHTMLToBe(myProfilePage.getProfileAddressWebElement(), address);
        myProfilePage.waitUntilAttributeInnerHTMLToBe(myProfilePage.getProfileCityAndStateWebElement(), (city + ", " + state + " "));
        myProfilePage.waitUntilAttributeInnerHTMLToBe(myProfilePage.getProfileCountryWebElement(), country);
        return this;
    }

    /**
     * performs the operation of changing the profile name
     * click 'Edit Profile' button
     * enter state
     * enter address
     * enter city
     * enter country
     * click 'Save Changes' button
     * wait until the changed fields changes to the desired one
     *
     * @param address required address
     * @param city    required city
     * @param state   required state
     * @param country required country
     * @return this step
     */
    public MyProfilePageStep editAddressRevert(String address, String city, String state, String country) {
        myProfilePage.clickEditProfileButton()
                .enterState(state)
                .enterAddress(address)
                .enterCity(city)
                .enterCountry(country)
                .clickSaveChangesButton();
        myProfilePage.waitUntilAttributeInnerHTMLToBe(myProfilePage.getProfileAddressWebElement(), address);
        myProfilePage.waitUntilAttributeInnerHTMLToBe(myProfilePage.getProfileCityAndStateWebElement(), (city + ", " + state + " "));
        myProfilePage.waitUntilAttributeInnerHTMLToBe(myProfilePage.getProfileCountryWebElement(), country);
        return this;
    }

    /**
     * perform operation of comparing required and current name
     *
     * @param requiredName required profile name
     * @return this page
     */
    public boolean nameIsCorrect(String requiredName) {
        boolean result = myProfilePage.getProfileName()
                .replace(" ", "")
                .equals(requiredName);
        return result;
    }

    /**
     * perform operation of comparing required and current address
     *
     * @param requiredAddress required profile address
     * @return boolean
     */
    public boolean addressIsCorrect(String requiredAddress) {
        boolean result = myProfilePage.getProfileAddress().equals(requiredAddress);
        return result;
    }

    /**
     * perform operation of comparing required and current city
     *
     * @param requiredCity required profile city
     * @return boolean
     */
    public boolean cityIsCorrect(String requiredCity) {
        boolean result = myProfilePage.getProfileCityAndState().replaceAll(",.*$", "").trim().equals(requiredCity);
        return result;
    }

    /**
     * perform operation of comparing required and current state
     *
     * @param requiredState required profile state
     * @return boolean
     */
    public boolean stateIsCorrect(String requiredState) {
        boolean result = myProfilePage.getProfileCityAndState().replaceAll(".*, $*", "").trim().equals(requiredState);
        return result;
    }

    /**
     * perform operation of comparing required and current country
     *
     * @param requiredCountry required profile country
     * @return boolean
     */
    public boolean countryIsCorrect(String requiredCountry) {
        boolean result = myProfilePage.getProfileCountry().equals(requiredCountry);
        return result;
    }

    /**
     * navigate to user icon
     * click sign out button
     *
     * @return this step
     */
    public MyProfilePageStep logOut() {
        myProfilePage.navigateToUserIcon()
                .clickLogOutLink();
        return this;
    }

}
