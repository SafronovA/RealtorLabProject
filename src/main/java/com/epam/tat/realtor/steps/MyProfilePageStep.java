package com.epam.tat.realtor.steps;

import com.epam.tat.realtor.pages.MyProfilePage;
import org.openqa.selenium.WebDriver;

public class MyProfilePageStep extends BasePageStep {

    private MyProfilePage myProfilePage;

    public MyProfilePageStep(WebDriver driver){
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
     * click 'Just Sold ' button
     * navigate to user icon
     * waiting for the 'Sign Out' link to appear
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
