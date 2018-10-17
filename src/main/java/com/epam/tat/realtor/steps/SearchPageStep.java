package com.epam.tat.realtor.steps;

import com.epam.tat.realtor.bo.House;
import com.epam.tat.realtor.pages.BasePage;
import com.epam.tat.realtor.pages.SearchPage;
import com.epam.tat.realtor.util.Parser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SearchPageStep extends BasePageStep {
    private SearchPage searchPage;

    public SearchPageStep(WebDriver driver) {
        super(driver);
        searchPage = new SearchPage(driver);
    }

    /**
     * set min and max price to drop-down menu
     *
     * @param minPrice will be set to drop-down menu
     * @param maxPrice will be set to drop-down menu
     * @return SearchPageStep
     */
    public SearchPageStep selectMinMaxPrices(String minPrice, String maxPrice) {
        searchPage.clickPriceButton();
        searchPage.clickMinPriceInput();
        searchPage.getMinPriceRange().stream()
                .filter(WebElement -> WebElement.getText().equals(minPrice))
                .findFirst()
                .get().click();
        searchPage.getMaxPriceRange().stream()
                .filter(WebElement -> WebElement.getText().equals(maxPrice))
                .findFirst()
                .get().click();
        return this;
    }

    /**
     * click save button to save search
     *
     * @return SearchPageStep
     */
    public SearchPageStep clickSaveSearchButton() {
        searchPage.clickSaveSearchButton();
        return this;
    }

    /**
     * open saved searches page
     *
     * @return SavedSearchesPageStep
     */
    public SavedSearchesPageStep openSavedSearches() {
        searchPage.waitUntilSaveButtonChangeState()
                .clickUserIcon()
                .clickSavedSearches();
        return new SavedSearchesPageStep(driver);
    }

    /**
     * click on sortOption drop-down and select sort type, which is specified in parameter
     *
     * @param sortOption sort type, which will be specified in sort drop-down
     * @return this page
     */
    public SearchPageStep selectSortOption(String sortOption) {
        searchPage.clickSortOptionsDropDown();
        searchPage.getSortOptionsList().stream()
                .filter(WebElement -> sortOption.equals(WebElement.getText()))
                .findFirst()
                .get().click();
        return this;
    }

    /**
     * check that homes are displayed sorted by price
     *
     * @return true if they are displayed sorted by price, false if the are not
     */
    public boolean isHomesDisplayedSortedByPrice() {
        List<Integer> homePrices = findAllHouses();
        boolean sortedDescending =
                IntStream.range(0, homePrices.size() - 1)
                        .allMatch(i -> homePrices.get(i).compareTo(homePrices.get(i + 1)) >= 0);
        return sortedDescending;
    }

    /**
     * create search request with parameters:
     *
     * @param minValue   min price value
     * @param maxValue   max price value
     * @param bedNumber  bed number
     * @param bathNumber bath number
     * @param minSqft    min square feet house size
     * @param maxSqft    max square feet house size
     * @return this page
     */
    public SearchPageStep createSearchRequest(String minValue, String maxValue, String bedNumber, String bathNumber, String minSqft, String maxSqft) {
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
        return this;
    }

    /**
     * create list of searched houses according search result
     *
     * @return list of searched houses
     */
    public List<House> createHomesList() {
        List<House> homesList = new ArrayList<>();
        for (int i = 0; i < searchPage.getSearchedHousePricesList().size(); i++) {
            homesList.add(new House(Parser.parse(searchPage.getSearchedHouseBedList().get(i).getText()),
                    Parser.parse(searchPage.getSearchedHouseBathList().get(i).getText()),
                    Parser.parse(searchPage.getSearchedHousePricesList().get(i).getText()),
                    Parser.parse(searchPage.getSearchedHouseSqftList().get(i).getText())));
        }
        return homesList;
    }

    /**
     * check if parameters of houses in the list match search criteria
     *
     * @param homeList list of house according search result
     * @param minPrice min price value
     * @param maxPrice max price value
     * @return if true list match search criteria
     */
    public boolean checkSearchResultPrice(List<House> homeList, String minPrice, String maxPrice) {
        return homeList.stream()
                .allMatch(x -> ((x.getPrice() >= Parser.parsePrice(minPrice)) && (x.getPrice() <= Parser.parsePrice(maxPrice))));
    }

    /**
     * check if parameters of houses in the list match search criteria
     *
     * @param homeList  list of house according search result
     * @param bedNumber bed number
     * @return if true list match search criteria
     */
    public boolean checkSearchResultBed(List<House> homeList, String bedNumber) {
        return homeList.stream()
                .allMatch(x -> (x.getBedNumber() >= Parser.parse(bedNumber)));
    }

    /**
     * check if parameters of houses in the list match search criteria
     *
     * @param homeList   list of house according search result
     * @param bathNumber bath number
     * @return if true list match search criteria
     */
    public boolean checkSearchResultBath(List<House> homeList, String bathNumber) {
        return homeList.stream()
                .allMatch(x -> (x.getBathNumber() >= Parser.parse(bathNumber)));
    }

    /**
     * check if parameters of houses in the list match search criteria
     *
     * @param homeList list of house according search result
     * @param minSqft  min square feet house size
     * @param maxSqft  max square feet house size
     * @return if true list match search criteria
     */
    public boolean checkSearchResultSqft(List<House> homeList, String minSqft, String maxSqft) {
        return homeList.stream()
                .allMatch(x -> ((x.getSquare() >= Parser.parse(minSqft)) && (x.getSquare() <= Parser.parse(maxSqft))));
    }

    /**
     * compares the declared number of found houses with the actual number of houses on the pages
     *
     * @return true, if the declared and actual number of houses matches, otherwise returns false
     */
    public boolean checkFindHomesCount() {
        return getFindHomesCountFromSearchResult()==findAllHouses().size();
    }

    /**
     * counting the total number of found houses displayed on all pages
     *
     * @return total amount of houses
     */
    public int getFindHomesCountFromSearchResult() {
        int searchResultCount = Parser.parse(searchPage.getSearchResultCountElement().getText());
        return searchResultCount;
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
    public boolean checkPriceMapMarks(String minPrice, String maxPrice) {
        searchPage.clickViewMapButton();
        return searchPage.getMapMarks().stream()
                .allMatch(x -> {
                    BasePage.clickByJEx(x, driver);
                    return (Parser.parsePrice(minPrice) <= Parser.parse(searchPage.getMapMarkPrice()))
                            && (Parser.parsePrice(maxPrice) >= Parser.parse(searchPage.getMapMarkPrice()));
                });
    }

    /**
     * check if information in map cards on the iframe map match search criteria
     *
     * @param bedNumber bed number
     * @return if true map marks match search criteria
     */
    public boolean checkBedMapMarks(String bedNumber) {
        return searchPage.getMapMarks().stream().allMatch(x -> {
            BasePage.clickByJEx(x, driver);
            return Parser.parse(bedNumber) <= Parser.parse(searchPage.getMapMarkBed());
        });
    }

    /**
     * check if information in map cards on the iframe map match search criteria
     *
     * @param bathNumber bed number
     * @return if true map marks match search criteria
     */
    public boolean checkBathMapMarks(String bathNumber) {
        return searchPage.getMapMarks().stream()
                .allMatch(x -> {
                    BasePage.clickByJEx(x, driver);
                    return Parser.parse(bathNumber) <= Parser.parse(searchPage.getMapMarkBath());
                });
    }

    /**
     * check if information in map cards on the iframe map match search criteria
     *
     * @param minSqft min square feet house size
     * @param maxSqft max square feet house size
     * @return if true map marks match search criteria
     */
    public boolean checkSqftMapMarks(String minSqft, String maxSqft) {
        return searchPage.getMapMarks().stream()
                .allMatch(x -> {
                    BasePage.clickByJEx(x, driver);
                    return (Parser.parse(minSqft) <= Parser.parse(searchPage.getMapMarkSqft()))
                            && (Parser.parse(maxSqft) >= Parser.parse(searchPage.getMapMarkSqft()));
                });
    }

    /**
     * click on view map button to open map
     *
     * @return SearchPageStep
     */
    public SearchPageStep clickViewMapButton() {
        searchPage.clickViewMapButton();
        return this;
    }

    /**
     * click lifestyle button on map
     *
     * @return SearchPageStep
     */
    public SearchPageStep clickLifestyleButton() {
        searchPage.clickLifestyleButton();
        return this;
    }

    /**
     * click on restaurants
     *
     * @return SearchPageStep
     */
    public SearchPageStep selectRestaurants() {
        searchPage.selectRestaurants();
        return this;
    }

    /**
     * check that all found lifestyles are restaurants
     *
     * @return true, if all found lifestyles are restaurants, false, if they are not
     */
    public boolean areAllFoundLifestyleRestaurants() {
        boolean isRestaurant = true;
        for (int i = 1; i < searchPage.getRestaurantsCount() + 1; i++) {
            BasePage.clickByJEx(searchPage.getRestaurant(i), driver);
            isRestaurant &= searchPage.getLifestyleType().equalsIgnoreCase("restaurants");
        }
        return isRestaurant;
    }

    /**
     * click school button on map
     *
     * @return SearchPageStep
     */
    public SearchPageStep clickSchoolButton() {
        searchPage.clickSchoolButton();
        return this;
    }

    /**
     * select high school, remove ticks from other schools
     *
     * @return SearchPageStep
     */
    public SearchPageStep selectHighSchool() {
        searchPage.clickElementarySchool()
                .clickMiddleSchool()
                .clickPrivateSchool();
        return this;
    }

    /**
     * set school rating on 10
     *
     * @return SearchPageStep
     */
    public SearchPageStep selectSchoolRating(String rating) {
        searchPage.selectSchoolRating(rating);
        return this;
    }

    /**
     * check that all displayed on map school have rating mare than 8
     *
     * @return true, if all displayed on map school have rating mare than 8, false, if have not
     */
    public boolean doesAllSchoolHaveSelectedRating(String rating) {
        boolean isRatingMoreThanEight = true;
        for (int i = 1; i < searchPage.getSchoolOnMapListCount() + 1; i++) {
            BasePage.clickByJEx(searchPage.getSchool(i), driver);
            isRatingMoreThanEight &= Integer.valueOf(searchPage.getSchoolRating()) >= Integer.valueOf(rating);
        }
        return isRatingMoreThanEight;
    }

    /**
     * check that all displayed on map school are high
     *
     * @return true, if all displayed on map school are high, false, if are not
     */
    public boolean areAllSchoolsHigh(){
        boolean areAllSchoolsHigh = true;
        for (int i = 1; i < searchPage.getSchoolOnMapListCount() + 1; i++) {
            BasePage.clickByJEx(searchPage.getSchool(i), driver);
            areAllSchoolsHigh &= searchPage.getSchoolName().contains("High");
        }
        return areAllSchoolsHigh;
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
