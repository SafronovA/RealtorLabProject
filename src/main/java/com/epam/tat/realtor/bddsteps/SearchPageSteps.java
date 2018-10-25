package com.epam.tat.realtor.bddsteps;

import com.epam.tat.realtor.ConfigProperties;
import com.epam.tat.realtor.bo.House;
import com.epam.tat.realtor.drivers.DriverFactory;
import com.epam.tat.realtor.pages.BasePage;
import com.epam.tat.realtor.pages.HomePage;
import com.epam.tat.realtor.pages.SearchPage;
import com.epam.tat.realtor.steps.HomePageStep;
import com.epam.tat.realtor.steps.SearchPageStep;
import com.epam.tat.realtor.util.Parser;
import cucumber.api.PendingException;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SearchPageSteps {
    private WebDriver driver = DriverFactory.CHROMEDRIVER.getDriver();
    private List<House> searchResult =new ArrayList<>();;
    private SearchPageStep searchPageStep;
    private HomePageStep homePageStep;
    private SearchPage searchPage = new SearchPage(driver);
    private HomePage homePage = new HomePage(driver);

    @Before
    public void initResources(){
        driver.manage().deleteAllCookies();
        driver.navigate().to(ConfigProperties.getTestProperty("url"));
    }
    @After
    public void getScenarioInfo(Scenario scenario) {
        System.out.println(scenario.getId());
        System.out.println(scenario.getName());
        System.out.println(scenario.getStatus());
        System.out.println(scenario.isFailed());
        System.out.println(scenario.getSourceTagNames());
    }


    @Given("^user perform search by \"([^\"]*)\"$")
    public void userPerformSearchBy(String city_Name)  {
        new HomePage(driver).clearInputField()
                .enterCityInMainSearchInput(city_Name).clickSearchButton();

    }


    @When("^user create search request by \"([^\"]*)\", \"([^\"]*)\",\"([^\"]*)\", \"([^\"]*)\",\"([^\"]*)\", \"([^\"]*)\"$")
    public void userCreateSearchRequestBy(String minValue, String maxValue, String bedNumber, String bathNumber, String minSqft, String maxSqft)  {
        searchPage.clickPriceButton();
        if (!minValue.equals("")) {
            searchPage.clickMinPriceInput();
            setMinPriceValue(minValue);
        }
        if (!maxValue.equals("")) {
            searchPage.clickMaxPriceInput();
            setMaxPriceValue(maxValue);
        }
        searchPage.clickBedButton();
        if (!bedNumber.equals("")) {
            selectBedNumber(bedNumber);
        }
        searchPage.clickBathButton();
        if (!bathNumber.equals("")) {
            selectBathNumber(bathNumber);
        }
        searchPage.clickMoreFiltersButton().clickHomeSizeButton();
        if (!minSqft.equals("")) {
            searchPage.clickMinDropdownMenu();
            selectMinHomeSquare(minSqft);
        }
        if (!maxSqft.equals("")) {
            searchPage.clickMaxDropdownMenu();
            selectMaxHomeSquare(maxSqft);
        }
        searchPage.clickViewListingsButton();
    }


    @Then("^prices on map marks on the iframe map should be between \"([^\"]*)\" and \"([^\"]*)\"$")
    public void pricesOnMapMarksOnTheIframeMapShouldBeBetweenAnd(String minPrice, String maxPrice) {
        searchPage.clickViewMapButton();
        assertTrue(searchPage.getMapMarks().stream()
                .allMatch(x -> {
                    BasePage.clickByJEx(x, driver);
                    return (Parser.parsePrice(minPrice) <= Parser.parse(searchPage.getMapMarkPrice()))
                            && (Parser.parsePrice(maxPrice) >= Parser.parse(searchPage.getMapMarkPrice()));
                }),
                "price value on the map mark mismatch search criteria");
    }

    @Then("^map marks on the iframe map should have beds more than \"([^\"]*)\"$")
    public void mapMarksOnTheIframeMapShouldHaveBedsMoreThan(String bedNumber)  {
        assertTrue(searchPage.getMapMarks().stream().allMatch(x -> {
                    BasePage.clickByJEx(x, driver);
                    return Parser.parse(bedNumber) <= Parser.parse(searchPage.getMapMarkBed());
                }),
                "bed quantity on the map mark mismatch search criteria");
    }

    @Then("^map marks on the iframe map should have baths more than \"([^\"]*)\"$")
    public void mapMarksOnTheIframeMapShouldHaveBathsMoreThan(String bathNumber) {
        assertTrue(searchPage.getMapMarks().stream()
                        .allMatch(x -> {
                            BasePage.clickByJEx(x, driver);
                            return Parser.parse(bathNumber) <= Parser.parse(searchPage.getMapMarkBath());
                        }),
                "bath quantity on the map mark mismatch search criteria");
    }

    @Then("^house sqft on map marks on the iframe map should be between \"([^\"]*)\" and \"([^\"]*)\"$")
    public void houseSqftOnMapMarksOnTheIframeMapShouldBeBetweenAnd(String minSqft, String maxSqft) {
        assertTrue(searchPage.getMapMarks().stream()
                .allMatch(x -> {
                    BasePage.clickByJEx(x, driver);
                    return (Parser.parse(minSqft) <= Parser.parse(searchPage.getMapMarkSqft()))
                            && (Parser.parse(maxSqft) >= Parser.parse(searchPage.getMapMarkSqft()));
                }),
                "square feet house size on the map mark mismatch search criteria");
    }

    @Then("^prices in search result should be between \"([^\"]*)\" and \"([^\"]*)\"$")
    public void pricesInSearchResultShouldBeBetweenAnd(String minPrice, String maxPrice) throws Throwable {
        for (int i = 0; i < searchPage.getSearchedHousePricesList().size(); i++) {
            searchResult.add(new House(Parser.parse(searchPage.getSearchedHouseBedList().get(i).getText()),
                    Parser.parse(searchPage.getSearchedHouseBathList().get(i).getText()),
                    Parser.parse(searchPage.getSearchedHousePricesList().get(i).getText()),
                    Parser.parse(searchPage.getSearchedHouseSqftList().get(i).getText())));
        }

        assertTrue(searchResult.stream()
                .allMatch(x -> ((x.getPrice() >= Parser.parsePrice(minPrice)) && (x.getPrice() <= Parser.parsePrice(maxPrice)))),
                "price value mismatch search criteria");
    }


    @And("^bed quantity in search results should have beds more than \"([^\"]*)\"$")
    public void bedQuantityInSearchResultsShouldHaveBedsMoreThan(String bedNumber) throws Throwable {
        assertTrue( searchResult.stream()
                .allMatch(x -> (x.getBedNumber() >= Parser.parse(bedNumber))),
                "bed quantity mismatch search criteria");
    }

    @And("^bath quantity in search result should have baths more than \"([^\"]*)\"$")
    public void bathQuantityInSearchResultShouldHaveBathsMoreThan(String bathNumber) throws Throwable {
        assertTrue( searchResult.stream()
                        .allMatch(x -> (x.getBathNumber() >= Parser.parse(bathNumber))),
                "bath quantity mismatch search criteria");
    }

    @And("^house sqft in search result should be between \"([^\"]*)\" and \"([^\"]*)\"$")
    public void houseSqftInSearchResultShouldBeBetweenAnd(String minSqft, String maxSqft) throws Throwable {
        assertTrue(searchResult.stream()
                        .allMatch(x -> ((x.getSquare() >= Parser.parse(minSqft)) && (x.getSquare() <= Parser.parse(maxSqft)))),
                "square feet house size mismatch search criteria");
    }

    @Then("^number of found houses match result information$")
    public void numberOfFoundHousesMatchResultInformation() throws Throwable {
        int elementCount = searchPage.getHomePricesList().size();
        while (!searchPage.getNextPageLink().isEmpty()) {
            searchPage.clickNextLink();
            elementCount+=searchPage.getHomePricesList().size();
        }
        assertEquals((int) Parser.parse(searchPage.getSearchResultCountElement().getText()), elementCount,
                "The number of homes found and displayed is not equal");
    }

    @And("^user choose to sort houses by \"([^\"]*)\"$")
    public void userChooseToSortHousesBy(String SORT_OPTION) throws Throwable {
        searchPageStep.selectSortOption(SORT_OPTION);
    }

    @Then("^elements on the page displayed sorted by price$")
    public void elementsOnThePageDisplayedSortedByPrice() throws Throwable {
        assertTrue(searchPageStep.isHomesDisplayedSortedByPrice(),
                "Homes are not displayed on the page sorted by price");
    }

    @When("^user create search request by price \"([^\"]*)\", \"([^\"]*)\"$")
    public void userCreateSearchRequestByPrice(String MIN_PRICE, String MAX_PRICE) throws Throwable {
        searchPageStep.selectMinMaxPrices(MIN_PRICE, MAX_PRICE);
    }

    @And("^user choose high school and select school \"([^\"]*)\"$")
    public void userChooseHighSchoolAndSelectSchool(String RATING) throws Throwable {
        searchPageStep.clickSchoolButton()
                .selectHighSchool()
                .selectSchoolRating(RATING);
    }

    @Then("^schools that are displayed on map have rating more than selected \"([^\"]*)\"$")
    public void schoolsThatAreDisplayedOnMapHaveRatingMoreThanSelected(String RATING) throws Throwable {
        assertTrue(searchPageStep.doesAllSchoolHaveSelectedRating(RATING),
                "One of the schools shown on the map does not have a rating more that " + RATING);
    }

    @When("^user click on View Map button$")
    public void userClickOnViewMapButton() throws Throwable {
        searchPageStep.clickViewMapButton();
    }

    @And("^click on \"([^\"]*)\" button and select restaurants$")
    public void clickOnButtonAndSelectRestaurants(String arg0) throws Throwable {
        searchPageStep.clickLifestyleButton()
                .selectRestaurants();
    }

    @Then("^all marks on the map are restaurants$")
    public void allMarksOnTheMapAreRestaurants() throws Throwable {
        assertTrue(searchPageStep.areAllFoundLifestyleRestaurants(),
                "One of found lifestyle is not a restaurant");
    }
    /**
     * set value in the max price dropdown list
     *
     * @param maxValue value that is set in the dropdown list
     */
    private void setMaxPriceValue(String maxValue) {
        searchPage.getMaxPriceRange().stream()
                .filter(x -> maxValue.equalsIgnoreCase(x.getText()))
                .findFirst()
                .get().click();
    }

    /**
     * set value in the min price dropdown list
     *
     * @param minValue value that is set in the dropdown list
     */
    private void setMinPriceValue(String minValue) {
        searchPage.getMinPriceRange().stream()
                .filter(x -> minValue.equalsIgnoreCase(x.getText())).findFirst()
                .get().click();

    }

    /**
     * select bed number according search parameter
     *
     * @param bedNumber bed number to be set
     */
    private void selectBedNumber(String bedNumber) {
        searchPage.getBedQuantityList().stream()
                .filter(x -> bedNumber.equals(x.getText().trim()))
                .findFirst()
                .get().click();
    }

    /**
     * select bath number according search parameter
     *
     * @param bathNumber bath number to be set
     */
    private void selectBathNumber(String bathNumber) {
        searchPage.getBathQuantity().stream()
                .filter(x -> bathNumber.equals(x.getText().trim()))
                .findFirst()
                .get().click();
    }

    /**
     * set min square feet range value
     *
     * @param minSqft min square feet to be set
     */
    private void selectMinHomeSquare(String minSqft) {
        searchPage.getMinHomeSizeList().stream()
                .filter(x -> minSqft.equals(x.getText().trim()))
                .findFirst()
                .get().click();
    }

    /**
     * set max square feet range value
     *
     * @param maxSqft max square feet to be set
     */
    private void selectMaxHomeSquare(String maxSqft) {
        searchPage.getMaxHomeSizeList().stream()
                .filter(x -> maxSqft.equals(x.getText().trim()))
                .findFirst()
                .get().click();
    }

}
