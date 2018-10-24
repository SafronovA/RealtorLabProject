package com.epam.tat.realtor.bddsteps;

import com.epam.tat.realtor.ConfigProperties;
import com.epam.tat.realtor.bo.House;
import com.epam.tat.realtor.drivers.DriverFactory;
import com.epam.tat.realtor.pages.*;
import com.epam.tat.realtor.util.Parser;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ProfileBDDSteps {
    private WebDriver driver = DriverFactory.CHROMEDRIVER.getDriver();
    private HomePage homePage;
    private MyProfilePage myProfilePage;
    private MyHomePage myHomePage;
    private SavedHomesPage savedHomesPage;
    private House house;


    @Before
    public void initResources() {
        driver.manage().deleteAllCookies();
        driver.navigate().to(ConfigProperties.getTestProperty("url"));
    }

    @Given("user login")
    public void userPerformLogIn() {
        homePage = new HomePage(driver).clickSignInButton()
                .enterEmail()
                .enterPassword()
                .clickLoginSubmitButton();
    }

    @Given("user moved to my profile page")
    public void moveToMyProfilePage() {
        myProfilePage = homePage.clickUserIcon()
                .clickMyProfileLink();
    }

    @When("user changes first name to \"([^\"]*)\" and last name to \"([^\"]*)\"")
    public void editProfileName(String firstName, String lastName) {
        myProfilePage.clickEditProfileButton()
                .enterFirstName(firstName)
                .enterLastName(lastName)
                .clickSaveChangesButton();
        myProfilePage.waitUntilAttributeInnerHTMLToBe(myProfilePage.getProfileNameWebElement(), firstName + " " + lastName);
    }

    @Then("profile name should be equal \"([^\"]*)\"")
    public void nameIsCorrect(String name) {
        myProfilePage.getProfileName()
                .replace(" ", "")
                .equals(name);
    }

    @When("user click EditProfile button")
    public void clickEditProfileButton() {
        myProfilePage.clickEditProfileButton();
    }

    @And("user edit country on \"([^\"]*)\"")
    public void editCountry(String country) {
        myProfilePage.enterCountry(country);
    }

    @And("user edit address on \"([^\"]*)\"")
    public void editAddress(String address) {
        myProfilePage.enterAddress(address);
    }

    @And("user edit city on \"([^\"]*)\"")
    public void editCity(String city) {
        myProfilePage.enterCity(city);
    }

    @And("user edit state on \"([^\"]*)\"")
    public void editState(String state) {
        myProfilePage.enterState(state);
    }

    @And("user wait until profile location info become: \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"")
    public void editState(String country, String address, String city, String state) {
        myProfilePage.waitUntilAttributeInnerHTMLToBe(myProfilePage.getProfileAddressWebElement(), address);
        myProfilePage.waitUntilAttributeInnerHTMLToBe(myProfilePage.getProfileCityAndStateWebElement(), (city + ", " + state + " "));
        myProfilePage.waitUntilAttributeInnerHTMLToBe(myProfilePage.getProfileCountryWebElement(), country);
    }

    @Then("profile country should be equal \"([^\"]*)\"")
    public void countryIsCorrect(String country) {
        boolean result = myProfilePage.getProfileCountry().equals(country);
        assertTrue(result, "Profile country has not changed to the required");
    }

    @And("profile address should be equal \"([^\"]*)\"")
    public void addressIsCorrect(String address) {
        boolean result = myProfilePage.getProfileAddress().equals(address);
        assertTrue(result, "Profile address has not changed to the required");
    }

    @And("profile city should be equal \"([^\"]*)\"")
    public void cityIsCorrect(String city) {
        boolean result = myProfilePage.getProfileCityAndState().replaceAll(",.*$", "").trim().equals(city);
        assertTrue(result, "Profile city  has not changed to the required");
    }

    @And("profile state should be equal \"([^\"]*)\"")
    public void stateIsCorrect(String state) {
        boolean result = myProfilePage.getProfileCityAndState().replaceAll(".*, $*", "").trim().equals(state);
        assertTrue(result, "Profile state  has not changed to the required");
    }

//    MyHomeTest

    @Given("user move to my home page")
    public void moveToMyHomePage() {
        homePage.clickMyHomeButton();
    }

    @When("user click EditHomeFacts button")
    public void clickEditHomeFactsButton() {
        myHomePage.clickEditHomeFactsButton();
    }

    @And("user edit bedrooms on \"([^\"]*)\"")
    public void editBedrooms(String bedrooms) {
        myHomePage.enterBedrooms(bedrooms);
    }

    @And("user edit bathrooms on \"([^\"]*)\"")
    public void editBathrooms(String bathrooms) {
        myHomePage.enterBathrooms(bathrooms);
    }

    @And("user edit car spaces on \"([^\"]*)\"")
    public void editCarSpaces(String carSpaces) {
        myHomePage.enterCarSpaces(carSpaces);
    }

    @And("user edit square on \"([^\"]*)\"")
    public void editSquare(String square) {
        myHomePage.enterSquare(square);
    }

    @And("user edit lot size on \"([^\"]*)\"")
    public void editLotSize(String lotSize) {
        myHomePage.enterLotSize(lotSize);
    }

    @Then("my home bedrooms value should be equal \"([^\"]*)\"")
    public void bedroomsValueIsCorrect(String bedrooms) {
        house = myHomePage.getHouse();
        String houseBedrooms = String.valueOf(house.getBedNumber());
        boolean result = houseBedrooms.equals(bedrooms);
        assertTrue(result, "Bedrooms value has not changed to the required");
    }

    @And("my home bathrooms value should be equal \"([^\"]*)\"")
    public void bathroomsValueIsCorrect(String bathrooms) {
        String houseBathrooms = String.valueOf(house.getBathNumber());
        boolean result = houseBathrooms.equals(bathrooms);
        assertTrue(result, "Bathrooms value has not changed to the required");
    }

    @And("my home car spaces value should be equal \"([^\"]*)\"")
    public void carSpacesValueIsCorrect(String carSpaces) {
        String houseCarSpaces = String.valueOf(house.getCarSpaces());
        boolean result = houseCarSpaces.equals(carSpaces);
        assertTrue(result, "Car spaces value has not changed to the required");
    }

    @And("my home square value should be equal \"([^\"]*)\"")
    public void squareValueIsCorrect(String square) {
        String houseSquare = String.valueOf(house.getSquare());
        boolean result = houseSquare.equals(square);
        assertTrue(result, "Square value has not changed to the required");
    }

    @And("my home lot size value should be equal \"([^\"]*)\"")
    public void lotSizeIsCorrect(String lotSize) {
        String houseLotSize = String.valueOf(house.getLotSize());
        boolean result = houseLotSize.equals(lotSize);
        assertTrue(result, "Lot size has not changed to the required");
    }

    //    SavedHomes
    private int savedHomes;

    @Given("user clear saved homes")
    public void clearSavedHomes() {
        savedHomesPage = homePage.clickUserIcon();
        if (!savedHomesPage.getSaveHomesButtonList().isEmpty()) {
            savedHomesPage.clickLayerToStartDelete();
            for (int j = savedHomesPage.getSaveHomesButtonList().size(); j > 0; j--) {
                savedHomesPage.clickDeleteButtonByIndex(j).clickDeleteButton();
            }
        }
        savedHomesPage.clickRealtorIcon();
    }

    @When("user save all homes on the main page and remember the number of houses saved")
    public void saveHomes() {
        homePage.getHeartIconsList().forEach(WebElement::click);
        savedHomes = homePage.getHeartIconsList().size();
    }

    @Then("check if saved homes number match saved homes on the main page")
    public void checkSavedHomes() {
        homePage.clickUserIcon();
        int actualSaveHomes = savedHomesPage.getSaveHomesButtonList().size();
        assertEquals(savedHomes, actualSaveHomes, "saved homes number in saved homes section mismatch number of saved homes on the search page");
    }


    //    SavedSearch
    private SearchPage searchPage;
    private SavedSearchesPage savedSearchesPage;

    @Given("user clear all old saved searches")
    public void clearSavedSearches() {
        savedSearchesPage = homePage.clickUserIcon().clickSavedSearches();
        if (!savedSearchesPage.getSavedSearchesList().isEmpty()) {
            savedSearchesPage.getSavedSearchesList().stream().forEach(WebElement -> {
                savedSearchesPage.clickDeleteButton();
                savedSearchesPage.clickConfirmDeleteButton();
            });
        }
        savedSearchesPage.clickHomePageLink();
    }

    @Given("user perform search by \"([^\"]*)\"")
    public void userPerformSearchBy(String city_Name) {
        homePage.clearInputField()
                .enterCityInMainSearchInput(city_Name)
                .clickSearchButton();
    }

    @When("user save \"([^\"]*)\" - \"([^\"]*)\" search")
    public void saveSearch(String minPrice, String maxPrice) {
        searchPage.clickPriceButton()
                .clickMinPriceInput();
        searchPage.getMinPriceRange().stream()
                .filter(WebElement -> WebElement.getText().equals(minPrice))
                .findFirst()
                .get().click();
        searchPage.getMaxPriceRange().stream()
                .filter(WebElement -> WebElement.getText().equals(maxPrice))
                .findFirst()
                .get().click();
        searchPage.clickSaveSearchButton();
    }

    @Then("user check that search saved with selected parameters:\"([^\"]*)\" - \"([^\"]*)\"")
    public void checkSavedSearchDescriptionContainsInputText(String city, String minPrice, String maxPrice) {
        int min = Parser.parse(minPrice);
        int max = Parser.parse(maxPrice);
        boolean containingInputTextInDescription = savedSearchesPage.getCity().contains(city)
                && doesSavedSearchDescriptionContainPrice(min, max);
        assertTrue(containingInputTextInDescription, "Saved search description does not contain selected min or max, or entered town");
    }

    /**
     * check that saved search description min and max price corresponds to entered min and max price
     *
     * @param minPrice
     * @param maxPrice
     * @return true if description contains input prices, false if if does not
     */
    private boolean doesSavedSearchDescriptionContainPrice(int minPrice, int maxPrice) {
        String[] minMaxPrices = savedSearchesPage.getPrice().split("-");
        return minPrice == Parser.parse(minMaxPrices[0]) && maxPrice == Parser.parse(minMaxPrices[1]);
    }

    //mortgageCalculatorTest
    private MortgageCalculatorPage mortgageCalculatorPage;

    @Given("move to mortgage calculator page")
    public void moveToMortgageCalculatorPage() {
        homePage.navigateCursorOnMortgageLink()
                .clickMortgageCalculatorLink();
    }

    @When("select loan type as \"([^\"]*)\"")
    public void selectLoanType(String loanType) {
        mortgageCalculatorPage.clickMortgageLoanTypeDropDown();
        mortgageCalculatorPage.getLoanTypeOptionList().stream()
                .filter(element -> !element.getText().equals("") && loanType.equals(element.getText()))
                .findFirst().get().click();
    }

    @And("select rate as \"([^\"]*)\"")
    public void setRate(String rate) {
        mortgageCalculatorPage.setRateInput(rate);
    }

    @And("select rate as \"([^\"]*)\"")
    public void setHomePrice(String homePrice) {
        mortgageCalculatorPage.setHomePrice(homePrice);
    }

    @And("select down payment as \"([^\"]*)\"")
    public void setDownPayment(String downPayment) {
        mortgageCalculatorPage.setDownPayment(downPayment);
    }


    @Then("check that price calculated correctly with loan type = \"([^\"]*)\", rate = \"([^\"]*)\", home price = \"([^\"]*)\", down payment = \"([^\"]*)\"")
    public void isDisplayedPriceCorrect(String loanType, String rate, String homePrice, String downPayment) {
        boolean result = Parser.parse(mortgageCalculatorPage.getPricePerMonth())
                == calculateMortgagePricePerMonth(homePrice, downPayment, rate, loanType);
        assertTrue(result, "Mortgage calculator calculated incorrect monthly payment");
    }

    /**
     * calculate monthly payment for input parameters by formula
     * calculate money which left to pay(Home price - Down payment)
     * calculate rate (input rate divide on month per year)
     * calculate all necessary payment(multiply month per year on year in loan type)
     * calculate monthly payment
     *
     * @param homePrice   input parameter to calculator
     * @param downPayment input parameter to calculator
     * @param rate        input parameter to calculator
     * @param loanType    input parameter to calculator
     * @return monthly payment
     */
    private static int calculateMortgagePricePerMonth(String homePrice, String downPayment, String rate, String loanType) {
        final int MONTH_IN_YEAR = 12;
        final int PERCENT = 100;
        int moneyLeftToPay = Integer.valueOf(homePrice) - Integer.valueOf(downPayment);
        double rateInt = (Double.valueOf(rate) / PERCENT) / MONTH_IN_YEAR;
        int allPaymentCount = MONTH_IN_YEAR * Parser.parse(loanType);
        double paymentPerMonth = moneyLeftToPay * (rateInt * Math.pow(1 + rateInt, allPaymentCount)) / (Math.pow((1 + rateInt), allPaymentCount) - 1);
        return (int) Math.round(paymentPerMonth);
    }
}
