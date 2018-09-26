package com.epam.tat.realtor.steps;

import com.epam.tat.realtor.pages.HomePage;
import org.openqa.selenium.WebDriver;


public class  HomePageStep extends BasePageStep{
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

    public SavedSearchesPageStep openSavedSearches(){
        homePage.navigateToUserIcon()
                .waitForSavedSearchLinkToAppear()
                .clickSavedSearchLink();
        return new SavedSearchesPageStep(driver);
    }

    /**
     * navigate to user icon
     * click sign out button
     */
    public HomePageStep logOut(){
        homePage.navigateToUserIcon()
                .waitForSignOutLinkToAppear()
                .clickLogOutLink();
        return this;
    }


}
