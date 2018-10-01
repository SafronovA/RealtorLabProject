package com.epam.tat.realtor.steps;

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
        searchPage.getMinPriceRange().stream().filter(WebElement -> WebElement.getText().equals(minPrice)).findFirst().get().click();
        searchPage.getMaxPriceRange().stream().filter(WebElement -> WebElement.getText().equals(maxPrice)).findFirst().get().click();
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
        searchPage.getSortOptionsList().stream().filter(WebElement -> sortOption.equals(WebElement.getText())).findFirst().get().click();
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
