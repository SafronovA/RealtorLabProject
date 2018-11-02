package com.epam.tat.realtor.web.steps;

import com.epam.tat.realtor.web.pages.HomePage;
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
    public HomePageStep enterCityName(String city) {
        homePage.clearInputField()
                .enterCityInMainSearchInput(city);
        return this;
    }

    /**
     * click search button
     *
     * @return HomePageStep
     */
    public SearchPageStep clickSearchButton() {
        homePage.clickSearchButton();
        return new SearchPageStep(driver);
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
     * create search request in the home estimate section
     * @return this page
     */
    public PropertyRecordsPageStep goToHomeEstimate() {
        homePage.clickHomeEstimate()
                .clickSearchButton();
        return new PropertyRecordsPageStep(driver);
    }

    /**
     * navigate cursor on mortgage calculator to show drop-down menu
     *
     * @return HomePageStep
     */
    public HomePageStep navigateCursorToMortgageLink() {
        homePage.navigateCursorOnMortgageLink();
        return this;
    }

    /**
     * click on mortgage calculator link
     *
     * @return new MortgageCalculatorPageStep
     */
    public MortgageCalculatorPageStep clickMortgageCalculatorLink() {
        homePage.clickMortgageCalculatorLink();
        return new MortgageCalculatorPageStep(driver);
    }

    /**
     * click on the My Home button
     *
     * @return new MyHomePageStep
     */
    public MyHomePageStep clickMyHomeButton() {
        homePage.clickMyHomeButton();
        return new MyHomePageStep(driver);
    }

}
