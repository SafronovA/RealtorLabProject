package com.epam.tat.realtor.steps;

import com.epam.tat.realtor.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class HomePageStep extends BasePageStep {
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
        homePage.waitForSearchInput()
                .clearInputField()
                .enterCityInMainSearchInput(city);
        return this;
    }

    /**
     * click search button
     * @return SearchPageStep
     */
    public SearchPageStep clickSearchButton(){
        homePage.clickSearchButton();
        return new SearchPageStep(driver);
    }

    /**
     * navigate to user icon
     * waiting for the 'Sign Out' link to appear
     * click sign out button
     *
     * @return this page
     */
    public HomePageStep logOut(){
        homePage.navigateToUserIcon()
                .waitForSignOutLinkToAppear()
                .clickLogOutLink();
        return this;
    }

    /**
     * click on user icon
     * @return new SavedHomesPageStep
     */
    public SavedHomesPageStep clickUserIcon(){
        homePage.clickUserIcon();
        return new SavedHomesPageStep(driver);
    }

    /**
     * click Realtor button
     * @return new SearchRealtorPageStep
     */
    public SearchRealtorPageStep clickFindRealtorButton(){
        homePage.clickRealtorButton();
        return new SearchRealtorPageStep(driver);
    }

    /**
     * save all homes on the home page
     * @return saved homes list size
     */
    public int saveHomes() {
        homePage.getHeartIconsList().forEach(WebElement::click);
        return homePage.getHeartIconsList().size();
    }
}
