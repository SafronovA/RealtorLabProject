package com.epam.tat.realtor.bddsteps;

import com.epam.tat.realtor.bo.House;
import com.epam.tat.realtor.drivers.DriverFactory;
import com.epam.tat.realtor.pages.BasePage;
import com.epam.tat.realtor.pages.HomePage;
import com.epam.tat.realtor.pages.SearchPage;
import com.epam.tat.realtor.util.Parser;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SearchPageSteps {
    private WebDriver driver = DriverFactory.CHROMEDRIVER.getDriver();
    private List<House> searchResult = new ArrayList<>();
    private HomePage homePage = new HomePage(driver);
    private SearchPage searchPage = new SearchPage(driver);

    @Given("user perform search by \"([^\"]*)\"")
    public void userPerformSearchBy(String city_Name) {
        homePage.clearInputField()
                .enterCityInMainSearchInput(city_Name).clickSearchButton();

    }

    @When("user create search request by \"([^\"]*)\", \"([^\"]*)\",\"([^\"]*)\", \"([^\"]*)\",\"([^\"]*)\", \"([^\"]*)\"")
    public void userCreateSearchRequestBy(String minValue, String maxValue, String bedNumber, String bathNumber, String minSqft, String maxSqft) {
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

    @Then("prices on map marks on the iframe map should be between \"([^\"]*)\" and \"([^\"]*)\"")
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

    @Then("map marks on the iframe map should have beds more than \"([^\"]*)\"")
    public void mapMarksOnTheIframeMapShouldHaveBedsMoreThan(String bedNumber) {
        assertTrue(searchPage.getMapMarks().stream().allMatch(x -> {
                    BasePage.clickByJEx(x, driver);
                    return Parser.parse(bedNumber) <= Parser.parse(searchPage.getMapMarkBed());
                }),
                "bed quantity on the map mark mismatch search criteria");
    }

    @Then("map marks on the iframe map should have baths more than \"([^\"]*)\"")
    public void mapMarksOnTheIframeMapShouldHaveBathsMoreThan(String bathNumber) {
        assertTrue(searchPage.getMapMarks().stream()
                        .allMatch(x -> {
                            BasePage.clickByJEx(x, driver);
                            return Parser.parse(bathNumber) <= Parser.parse(searchPage.getMapMarkBath());
                        }),
                "bath quantity on the map mark mismatch search criteria");
    }

    @Then("house sqft on map marks on the iframe map should be between \"([^\"]*)\" and \"([^\"]*)\"")
    public void houseSqftOnMapMarksOnTheIframeMapShouldBeBetweenAnd(String minSqft, String maxSqft) {
        assertTrue(searchPage.getMapMarks().stream()
                        .allMatch(x -> {
                            BasePage.clickByJEx(x, driver);
                            return (Parser.parse(minSqft) <= Parser.parse(searchPage.getMapMarkSqft()))
                                    && (Parser.parse(maxSqft) >= Parser.parse(searchPage.getMapMarkSqft()));
                        }),
                "square feet house size on the map mark mismatch search criteria");
    }

    @Then("prices in search result should be between \"([^\"]*)\" and \"([^\"]*)\"")
    public void pricesInSearchResultShouldBeBetweenAnd(String minPrice, String maxPrice) {
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


    @And("bed quantity in search results should have beds more than \"([^\"]*)\"")
    public void bedQuantityInSearchResultsShouldHaveBedsMoreThan(String bedNumber) {
        assertTrue(searchResult.stream()
                        .allMatch(x -> (x.getBedNumber() >= Parser.parse(bedNumber))),
                "bed quantity mismatch search criteria");
    }

    @And("bath quantity in search result should have baths more than \"([^\"]*)\"")
    public void bathQuantityInSearchResultShouldHaveBathsMoreThan(String bathNumber) {
        assertTrue(searchResult.stream()
                        .allMatch(x -> (x.getBathNumber() >= Parser.parse(bathNumber))),
                "bath quantity mismatch search criteria");
    }

    @And("house sqft in search result should be between \"([^\"]*)\" and \"([^\"]*)\"")
    public void houseSqftInSearchResultShouldBeBetweenAnd(String minSqft, String maxSqft) {
        assertTrue(searchResult.stream()
                        .allMatch(x -> ((x.getSquare() >= Parser.parse(minSqft)) && (x.getSquare() <= Parser.parse(maxSqft)))),
                "square feet house size mismatch search criteria");
    }

    @And("click on LifeStyle button and select restaurants")
    public void clickOnLifeStyleButtonAndSelectRestaurants() {
        searchPage.clickLifestyleButton()
                .selectRestaurants();
    }

    @Then("number of found houses match result information")
    public void numberOfFoundHousesMatchResultInformation() {
        int elementCount = searchPage.getHomePricesList().size();
        while (!searchPage.getNextPageLink().isEmpty()) {
            searchPage.clickNextLink();
            elementCount += searchPage.getHomePricesList().size();
        }
        assertEquals((int) Parser.parse(searchPage.getSearchResultCountElement().getText()), elementCount,
                "The number of homes found and displayed is not equal");
    }

    @And("user choose to sort houses by \"([^\"]*)\"")
    public void userChooseToSortHousesBy(String sortOption) {
        searchPage.clickSortOptionsDropDown();
        searchPage.getSortOptionsList().stream()
                .filter(WebElement -> sortOption.equals(WebElement.getText()))
                .findFirst()
                .get().click();
    }

    @Then("elements on the page displayed sorted by price")
    public void elementsOnThePageDisplayedSortedByPrice() {
        List<Integer> homePrices = findAllHouses();
        boolean sortedDescending =
                IntStream.range(0, homePrices.size() - 1)
                        .allMatch(i -> homePrices.get(i).compareTo(homePrices.get(i + 1)) >= 0);
        assertTrue(sortedDescending,
                "Homes are not displayed on the page sorted by price");
    }


    @When("user create search request by price \"([^\"]*)\", \"([^\"]*)\"")
    public void userCreateSearchRequestByPrice(String minPrice, String maxPrice) {
        searchPage.clickPriceButton()
                .clickMinPriceInput()
                .getMinPriceRange()
                .stream()
                .filter(WebElement -> WebElement.getText().equals(minPrice))
                .findFirst()
                .get().click();
        searchPage.getMaxPriceRange()
                .stream()
                .filter(WebElement -> WebElement.getText().equals(maxPrice))
                .findFirst()
                .get().click();
    }

    @And("user choose high school and select school \"([^\"]*)\"")
    public void userChooseHighSchoolAndSelectSchool(String rating) {
        searchPage.clickSchoolButton()
                .clickElementarySchool()
                .clickMiddleSchool()
                .clickPrivateSchool()
                .selectSchoolRating(rating);
    }

    @Then("schools that are displayed on map have rating more than selected \"([^\"]*)\"")
    public void schoolsThatAreDisplayedOnMapHaveRatingMoreThanSelected(String rating) {
        boolean doesAllSchoolHaveSelectedRating = IntStream.range(1, searchPage.getSchoolOnMapListCount() + 1).allMatch(i -> {
            BasePage.clickByJEx(searchPage.getSchool(i), driver);
            return Integer.valueOf(searchPage.getSchoolRating()) >= Integer.valueOf(rating);
        });
        assertTrue(doesAllSchoolHaveSelectedRating,
                "One of the schools shown on the map does not have a rating more that " + rating);
    }

    @When("user click on View Map button")
    public void userClickOnViewMapButton() {
        searchPage.clickViewMapButton();
    }

    @Then("all marks on the map are restaurants")
    public void allMarksOnTheMapAreRestaurants() {
        boolean areAllFoundLifestyleRestaurants = IntStream.range(1, searchPage.getRestaurantsCount() + 1).allMatch(i -> {
            BasePage.clickByJEx(searchPage.getRestaurant(i), driver);
            return searchPage.getLifestyleType().equalsIgnoreCase("restaurants");
        });
        assertTrue(areAllFoundLifestyleRestaurants,
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

    /**
     * add homes from all pages to integer list. Add homes from first page, while exist next page, click next link
     * and add home prices from this page.
     *
     * @return list integer prices from all pages
     */
    private List<Integer> findAllHouses() {
        List<Integer> homePrices = new ArrayList<>();
        homePrices.addAll(receivePricesListFromWebElementList(searchPage.getHomePricesList()));
        while (!searchPage.getNextPageLink().isEmpty()) {
            searchPage.clickNextLink();
            homePrices.addAll(receivePricesListFromWebElementList(searchPage.getHomePricesList()));
        }
        return homePrices;
    }

    /**
     * receive list home prices from list WebElement
     *
     * @param prices List<WebElement> found on page
     * @return List<Integer> int prices received from WebElement list
     */
    private List<Integer> receivePricesListFromWebElementList(List<WebElement> prices) {
        List<Integer> homePrices = prices.stream().map(WebElement -> Parser.parse(WebElement.getText())).collect(Collectors.toList());
        return homePrices;
    }

}