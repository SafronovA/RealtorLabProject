package com.epam.tat.realtor.steps;

import com.epam.tat.realtor.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePageStep extends BasePageStep {
    private HomePage homePage;

    public HomePageStep(WebDriver driver) {
        super(driver);
        homePage = new HomePage(driver);
    }

    /**
     * User LogIn operation on Home page
     * click signIn button
     * enter user email
     * enter user password
     * submit credentials
     *
     * @return HomePageStep
     */
    public HomePageStep userLogIn() {
        homePage.clickSignInButton()
                .enterEmail()
                .enterPassword()
                .clickLoginSubmitButton();
        return this;
    }

    /**
     * clear entered by default city, enter city in input search field
     *
     * @param city
     * @return search result page
     */
    public void enterCityName(String city) {
        homePage.clearInputField()
                .enterCityInMainSearchInput(city);
    }

    /**
     * click search button
     *
     * @return SearchPageStep
     */
    public void clickSearchButton() {
        homePage.clickSearchButton();
    }

    /**
     * navigate to user icon
     * waiting for the 'Sign Out' link to appear
     * click sign out button
     *
     * @return this page
     */
    public HomePageStep logOut() {
        homePage.navigateToUserIcon()
                .clickLogOutLink();
        return this;
    }

    /**
     * click on user icon
     *
     * @return new SavedHomesPageStep
     */
    public SavedHomesPageStep clickUserIcon() {
        homePage.clickUserIcon();
        return new SavedHomesPageStep(driver);
    }

    /**
     * click Realtor button
     *
     * @return new FindRealtorPageStep
     */
    public FindRealtorPageStep clickFindRealtorButton() {
        homePage.clickRealtorButton();
        return new FindRealtorPageStep(driver);
    }

    /**
     * save all homes on the home page
     *
     * @return saved homes list size
     */
    public int saveHomes() {
        homePage.getHeartIconsList().forEach(WebElement::click);
        return homePage.getHeartIconsList().size();
    }

    /**
     * navigate cursor on mortgage calculator to show drop-down menu
     *
     * @return HomePageStep
     */
    public void navigateCursorToMortgageLink() {
        homePage.navigateCursorOnMortgageLink();
    }

    /**
     * click on mortgage calculator link
     *
     * @return new MortgageCalculatorPageStep
     */
    public void clickMortgageCalculatorLink() {
        homePage.clickMortgageCalculatorLink();
    }

}
