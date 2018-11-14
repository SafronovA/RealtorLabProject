package com.epam.tat.realtor.bddsteps;

import com.epam.tat.realtor.bo.House;
import com.epam.tat.realtor.drivers.DriverFactory;
import com.epam.tat.realtor.pages.*;
import com.epam.tat.realtor.util.Parser;
import cucumber.api.java.en.But;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ProfilePageStep {
    private WebDriver driver = DriverFactory.CHROMEDRIVER.getDriver();
    private HomePage homePage = new HomePage(driver);
    private MyProfilePage myProfilePage = new MyProfilePage(driver);
    private MyHomePage myHomePage = new MyHomePage(driver);
    private SavedHomesPage savedHomesPage = new SavedHomesPage(driver);
    private SearchPage searchPage = new SearchPage(driver);
    private SavedSearchesPage savedSearchesPage = new SavedSearchesPage(driver);
    private MortgageCalculatorPage mortgageCalculatorPage = new MortgageCalculatorPage(driver);
    private House house;
    private int savedHomes;

    @Given("user login")
    public void userPerformLogIn() {
        homePage.clickSignInButton()
                .enterEmail()
                .enterPassword()
                .clickLoginSubmitButton();
    }

    @When("user moved to my profile page")
    public void moveToMyProfilePage() {
        myProfilePage = homePage.clickUserIcon()
                .clickMyProfileLink();
    }

    @When("user changes first name to \"([^\"]*)\" and last name to \"([^\"]*)\"")
    public void editProfileName(String firstName, String lastName) {
        myProfilePage.enterFirstName(firstName)
                .enterLastName(lastName);
    }

    @When("user click save changes button")
    public void clickSaveChangesButton() {
        myProfilePage.clickSaveChangesButton();
    }

    @When("user wait until profile name become: \"([^\"]*)\", \"([^\"]*)\"")
    public void waitRequiredName(String firstName, String lastName) {
        myProfilePage.waitUntilAttributeInnerHTMLToBe(myProfilePage.getProfileNameWebElement(), firstName + " " + lastName);
    }

    @Then("profile name should be equal \"([^\"]*)\"")
    @Test
    public void nameIsCorrect(String name) {
        boolean result = myProfilePage.getProfileName().equals(name);
        assertTrue(result, "Profile name has not changed to the required");
    }

    @When("user click EditProfile button")
    public void clickEditProfileButton() {
        myProfilePage.clickEditProfileButton();
    }

    @When("user chooses: country = \"([^\"]*)\", address = \"([^\"]*)\", city = \"([^\"]*)\", state = \"([^\"]*)\"")
    public void editProfileLocation(String country, String address, String city, String state) {
        myProfilePage.enterCountry(country)
                .enterAddress(address)
                .enterCity(city)
                .enterState(state);
    }

    @But("user chooses: state = \"([^\"]*)\", address = \"([^\"]*)\", city = \"([^\"]*)\", country = \"([^\"]*)\"")
    public void revertProfileLocation(String state, String address, String city, String country) {
        myProfilePage.enterState(state)
                .enterAddress(address)
                .enterCity(city)
                .enterCountry(country);
    }

    @When("user wait until profile location info become: \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"")
    public void waitRequiredValue(String country, String address, String city, String state) {
        myProfilePage.waitUntilAttributeInnerHTMLToBe(myProfilePage.getProfileAddressWebElement(), address);
        myProfilePage.waitUntilAttributeInnerHTMLToBe(myProfilePage.getProfileCityAndStateWebElement(), (city + ", " + state + " "));
        myProfilePage.waitUntilAttributeInnerHTMLToBe(myProfilePage.getProfileCountryWebElement(), country);
    }

    @Then("profile location info should be: country = \"([^\"]*)\", address = \"([^\"]*)\", city = \"([^\"]*)\", state = \"([^\"]*)\"")
    public void profileLocationIsCorrect(String country, String address, String city, String state) {
        boolean countryResult = myProfilePage.getProfileCountry().equals(country);
        boolean addressResult = myProfilePage.getProfileAddress().equals(address);
        boolean cityResult = myProfilePage.getProfileCityAndState().replaceAll(",.*$", "").trim().equals(city);
        boolean stateResult = myProfilePage.getProfileCityAndState().replaceAll(".*, $*", "").trim().equals(state);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(countryResult, "Profile country has not changed to the required");
        softAssert.assertTrue(addressResult, "Profile address has not changed to the required");
        softAssert.assertTrue(cityResult, "Profile city has not changed to the required");
        softAssert.assertTrue(stateResult, "Profile state has not changed to the required");
        softAssert.assertAll();
    }

    @When("user move to my home page")
    public void moveToMyHomePage() {
        myHomePage = homePage.clickMyHomeButton();
    }

    @When("user click EditHomeFacts button")
    public void clickEditHomeFactsButton() {
        myHomePage.clickEditHomeFactsButton();
    }


    @When("user chooses bedrooms = \"([^\"]*)\", bathrooms = \"([^\"]*)\", car spaces = \"([^\"]*)\", square = \"([^\"]*)\", lot size = \"([^\"]*)\"")
    public void editMyHomeInfo(String bedrooms, String bathrooms, String carSpaces, String square, String lotSize) {
        myHomePage.enterBedrooms(bedrooms)
                .enterBathrooms(bathrooms)
                .enterCarSpaces(carSpaces)
                .enterSquare(square)
                .enterLotSize(lotSize);
    }

    @When("user click save button")
    public void clickSaveButton() {
        myHomePage.clickSaveButton();
    }

    @When("user close verification window")
    public void closeVerificationWindows() {
        myHomePage.closeVerificationWindow();
    }

    @Then("changed parameters should be; bedrooms = \"([^\"]*)\", bathrooms = \"([^\"]*)\", car spaces = \"([^\"]*)\", square = \"([^\"]*)\", lot size = \"([^\"]*)\"")
    public void myHomeInfoIsCorrect(String bedrooms, String bathrooms, String carSpaces, String square, String lotSize) {
        house = myHomePage.getHouse();
        String houseBedrooms = String.valueOf(house.getBedNumber());
        String houseBathrooms = String.valueOf(house.getBathNumber());
        String houseCarSpaces = String.valueOf(house.getCarSpaces());
        String houseSquare = String.valueOf(house.getSquare());
        String houseLotSize = String.valueOf(house.getLotSize());

        boolean bedroomsResult = houseBedrooms.equals(bedrooms);
        boolean bathroomsResult = houseBathrooms.equals(bathrooms);
        boolean carSpacesResult = houseCarSpaces.equals(carSpaces);
        boolean squareResult = houseSquare.equals(square);
        boolean lotSizeResult = houseLotSize.equals(lotSize);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(bedroomsResult, "Bedrooms value has not changed to the required");
        softAssert.assertTrue(bathroomsResult, "Bathrooms value has not changed to the required");
        softAssert.assertTrue(carSpacesResult, "Car spaces value has not changed to the required");
        softAssert.assertTrue(squareResult, "Square value has not changed to the required");
        softAssert.assertTrue(lotSizeResult, "Lot size value has not changed to the required");
        softAssert.assertAll();
    }

    @When("user clear saved homes")
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

    @When("user clear all old saved searches")
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

    @Then("user check that search saved with selected parameters: city \"([^\"]*)\", min price \"([^\"]*)\", max price \"([^\"]*)\"")
    public void checkSavedSearchDescriptionContainsInputText(String city, String minPrice, String maxPrice) {
        int min = Parser.parse(minPrice);
        int max = Parser.parse(maxPrice);
        boolean containingInputTextInDescription = savedSearchesPage.getCity().contains(city)
                && doesSavedSearchDescriptionContainPrice(min, max);
        assertTrue(containingInputTextInDescription, "Saved search description does not contain selected min or max, or entered town");
    }

    @Given("move to mortgage calculator page")
    public void moveToMortgageCalculatorPage() {
        mortgageCalculatorPage = homePage.navigateCursorOnMortgageLink()
                .clickMortgageCalculatorLink();
    }

    @When("select loan type as \"([^\"]*)\"")
    public void selectLoanType(String loanType) {
        mortgageCalculatorPage.clickMortgageLoanTypeDropDown();
        mortgageCalculatorPage.getLoanTypeOptionList().stream()
                .filter(element -> !element.getText().equals("") && loanType.equals(element.getText()))
                .findFirst().get().click();
    }

    @When("select rate as \"([^\"]*)\"")
    public void setRate(String rate) {
        mortgageCalculatorPage.setRateInput(rate);
    }

    @When("select home price as \"([^\"]*)\"")
    public void setHomePrice(String homePrice) {
        mortgageCalculatorPage.setHomePrice(homePrice);
    }

    @When("select down payment as \"([^\"]*)\"")
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
