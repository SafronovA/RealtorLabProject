package com.epam.tat.realtor.steps;

import com.epam.tat.realtor.pages.HomePage;
import org.openqa.selenium.WebDriver;


public class HomePageStep extends BasePageStep{
    private HomePage homePage;

    public HomePageStep(WebDriver driver){
        super(driver);
        homePage = new HomePage(driver);
    }

    /**
     * User LogIn operation on Home page
     * click signIn button
     * enter user email
     * enter user password
     * submit credentials
     * @return HomePageStep
     */
    public HomePageStep userLogIn(){

        homePage.waitForSignInLinkToAppear()
                .clickSignInButton()
                .enterEmail()
                .enterPassword()
                .clickLoginSubmitButton();
        return this;
    }

    /**
     * clear entered by default city, enter city in input search field
     * @param city
     * @return search result page
     */
    public HomePageStep enterCityName(String city){
        homePage.clearInputField()
                .enterCityInMainSearchInput(city);
        return this;
    }

    /**
     * click search button
     * @return
     */
    public SearchPageStep clickSearchButton(){
        homePage.clickSearchButton();
        return new SearchPageStep(driver);
    }

    /**
     * click 'Just Sold ' button
     * navigate to user icon
     * waiting for the 'Sign Out' link to appear
     * click sign out button
     */
    public HomePageStep logOut(){
        homePage.clickJustSoldButton()
                .navigateToUserIcon()
                .waitForSignOutLinkToAppear()
                .clickLogOutLink();
        return this;
    }

    /**
     * perform the operation to go to the 'Saved Homes' section
     * click 'Just Sold' button (because often the page header disappears and this operation allows to return it)
     * click 'User Icon'
     * @return new SavedHomesPageStep
     */
    public SavedHomesPageStep goToSavedHomesSection(){
        homePage.clickJustSoldButton()
                .clickUserIcon();
        return new SavedHomesPageStep(driver);
    }

}
