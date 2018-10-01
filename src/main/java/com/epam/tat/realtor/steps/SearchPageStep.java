package com.epam.tat.realtor.steps;

import com.epam.tat.realtor.ConfigProperties;
import com.epam.tat.realtor.bo.House;
import com.epam.tat.realtor.pages.SearchPage;
import com.epam.tat.realtor.util.Parser;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public class SearchPageStep extends BasePageStep{
    private SearchPage searchPage;

    public SearchPageStep(WebDriver driver){
        super(driver);
        searchPage = new SearchPage(driver);
    }

    /**
     * set min and max price to drop-down menu
     * @param minPrice will be set to drop-down menu
     * @param maxPrice will be set to drop-down menu
     * @return SearchPageStep
     */
    public SearchPageStep selectMinMaxPrices(String minPrice, String maxPrice){
        searchPage.clickPriceButton();
        searchPage.getMinPriceRange().stream().filter(WebElement -> WebElement.getText().equals(minPrice)).findFirst().get().click();
        searchPage.getMaxPriceRange().stream().filter(WebElement -> WebElement.getText().equals(maxPrice)).findFirst().get().click();
        return this;
    }

    /**
     * click save button to save search
     * @return SearchPageStep
     */
    public SearchPageStep clickSaveSearchButton(){
        searchPage.clickSaveSearchButton();
        return this;
    }

    /**
     * open saved searches page
     * @return SavedSearchesPageStep
     */
    public SavedSearchesPageStep openSavedSearches(){
        searchPage.waitUntilSaveButtonChangeState()
                .clickUserIcon()
                .clickSavedSearches();
        return new SavedSearchesPageStep(driver);
    }


    /**
     * navigate to home page
     * @return new Home page
     */
    public HomePageStep goToHomePage(){
        driver.navigate().to(ConfigProperties.getTestProperty("url"));
        return new HomePageStep(driver);
    }

    /**
     *create search request with parameters:
     * @param minValue min price value
     * @param maxValue max price value
     * @param bedNumber bed number
     * @param bathNumber bath number
     * @param minSqft min square feet house size
     * @param maxSqft max square feet house size
     * @return this page
     */
    public SearchPageStep createSearchRequest(String minValue, String maxValue, String bedNumber, String bathNumber, String minSqft, String maxSqft){
        searchPage.clickPriceButton();
        if(!minValue.equals("")){
            searchPage.clickMinPriceInput();
            setMinPriceValue(minValue);}
        if(!maxValue.equals("")){
            searchPage.clickMaxPriceInput();
            setMaxPriceValue(maxValue);}
        searchPage.clickBedButton();
        if(!bedNumber.equals("")){
            selectBedNumber(bedNumber);
        }
        searchPage.clickBathButton();
        if(!bathNumber.equals("")){
            selectBathNumber(bathNumber);
        }
        searchPage.clickMoreFiltersButton().clickHomeSizeButton();
        if (!minSqft.equals("")){
            searchPage.clickMinDropdownMenu();
            selectMinHomeSquare(minSqft);
        }
        if (!maxSqft.equals("")){
            searchPage.clickMaxDropdownMenu();
            selectMaxHomeSquare(maxSqft);
        }
        searchPage.clickViewListingsButton();
        return this;
    }

    /**
     * create list of searched houses according search result
     * @return list of searched houses
     */
    public List<House> createHomesList(){
        searchPage.waitForHomeSizeFilter();
        List<House> homesList = new ArrayList<>();
        for (int i = 0; i < searchPage.getSearchedHousePricesList().size() ; i++) {
            homesList.add(new House( Parser.parse(searchPage.getSearchedHouseBedList().get(i).getText()),
                    Parser.parse(searchPage.getSearchedHouseBathList().get(i).getText()),
                    Parser.parse(searchPage.getSearchedHousePricesList().get(i).getText()),
                    Parser.parse(searchPage.getSearchedHouseSqftList().get(i).getText())));
        }
        return homesList;
    }

    /**
     * print list of searched houses
     * @param homeList list of houses to be printed to the console
     */
    public void printList(List<House> homeList){
        homeList.forEach(x-> System.out.println(x.getPrice()+" "+x.getBedNumber()+" "+x.getBathNumber()+" "+x.getSquare()+" "));
    }
//
//    /**
//     * check if parameters of houses in the list match search criteria
//     * @param homeList list of house according search result
//     * @param minPrice min price value
//     * @param maxPrice max price value
//     * @param bedNumber bed number
//     * @param bathNumber bath number
//     * @param minSqft min square feet house size
//     * @param maxSqft max square feet house size
//     * @return if true list match search criteria
//     */
//    public boolean checkSearchResult (List<House> homeList, String minPrice, String maxPrice, String bedNumber, String bathNumber, String minSqft, String maxSqft ){
//        System.out.println(minPrice+" "+maxPrice+" "+bedNumber+" "+bathNumber+" "+minSqft+" "+maxSqft);
//        return homeList.stream().allMatch(x->((x.getPrice()>=Parser.parsePrice(minPrice)) && (x.getPrice()<=Parser.parsePrice(maxPrice)) &&
//                (x.getBedNumber()>=Parser.parse(bedNumber)) &&
//                (x.getBathNumber()>=Parser.parse(bathNumber)) &&
//                (x.getSquare()>=Parser.parse(minSqft)) && (x.getSquare()<=Parser.parse(maxSqft))));
//    }


    /**
     * check if parameters of houses in the list match search criteria
     * @param homeList list of house according search result
     * @param minPrice min price value
     * @param maxPrice max price value
     * @return if true list match search criteria
     */
    public boolean checkSearchResultPrice (List<House> homeList, String minPrice, String maxPrice ){
        return homeList.stream().allMatch(x->((x.getPrice()>=Parser.parsePrice(minPrice)) && (x.getPrice()<=Parser.parsePrice(maxPrice))));
    }

    /**
     * check if parameters of houses in the list match search criteria
     * @param homeList list of house according search result
     * @param bedNumber bed number
     * @return if true list match search criteria
     */
    public boolean checkSearchResultBed (List<House> homeList, String bedNumber ){
        return homeList.stream().allMatch(x->(x.getBedNumber()>=Parser.parse(bedNumber)));
    }
    /**
     * check if parameters of houses in the list match search criteria
     * @param homeList list of house according search result
     * @param bathNumber bath number
     * @return if true list match search criteria
     */
    public boolean checkSearchResultBath (List<House> homeList, String bathNumber ){
        return homeList.stream().allMatch(x->(x.getBathNumber()>=Parser.parse(bathNumber)));
    }
    /**
     * check if parameters of houses in the list match search criteria
     * @param homeList list of house according search result
     * @param minSqft min square feet house size
     * @param maxSqft max square feet house size
     * @return if true list match search criteria
     */
    public boolean checkSearchResultSqft (List<House> homeList, String minSqft, String maxSqft ){
        return homeList.stream().allMatch(x->((x.getSquare()>=Parser.parse(minSqft)) && (x.getSquare()<=Parser.parse(maxSqft))));
    }














    /**
     * set value in the max price dropdown list
     * @param maxValue value that is set in the dropdown list
     */
    private void setMaxPriceValue(String maxValue){
        searchPage.getMaxPriceRange().stream().filter(x->maxValue.equalsIgnoreCase(x.getText())).findFirst().get().click();
    }
    /**
     * set value in the min price dropdown list
     * @param minValue value that is set in the dropdown list
     */
    private void setMinPriceValue(String minValue){
        searchPage.getMinPriceRange().stream().filter(x->minValue.equalsIgnoreCase(x.getText())).findFirst().get().click();
    }

    /**
     * select bed number according search parameter
     * @param bedNumber bed number to be set
     */
    private void selectBedNumber(String bedNumber){
        searchPage.getBedQuantityList().stream().filter(x->bedNumber.equals(x.getText().trim())).findFirst().get().click();
    }
    /**
     * select bath number according search parameter
     * @param bathNumber bath number to be set
     */
    private void selectBathNumber(String bathNumber){
        searchPage.getBathQuantity().stream().filter(x->bathNumber.equals(x.getText().trim())).findFirst().get().click();
    }

    /**
     * set min square feet range value
     * @param minSqft min square feet to be set
     */
    private void selectMinHomeSquare(String minSqft){
        searchPage.getMinHomeSizeList().stream().filter(x->minSqft.equals(x.getText().trim())).findFirst().get().click();
    }
    /**
     * set max square feet range value
     * @param maxSqft max square feet to be set
     */
    private void selectMaxHomeSquare(String maxSqft){
        searchPage.getMaxHomeSizeList().stream().filter(x->maxSqft.equals(x.getText().trim())).findFirst().get().click();
    }

    /**
     * check if information in map cards on the iframe map match search criteria
     * @param minPrice min price value
     * @param maxPrice max price value
     * @param bedNumber bed number
     * @param bathNumber bath number
     * @param minSqft min square feet house size
     * @param maxSqft max square feet house size
     * @return if true map marks match search criteria
     */
    public boolean checkMapMarks(String minPrice, String maxPrice, String bedNumber, String bathNumber, String minSqft, String maxSqft ){
        searchPage.clickViewMapButton();
        return searchPage.getMapMarks().stream().allMatch(x->{ searchPage.clickByJEx(x,driver);
            return (Parser.parsePrice(minPrice)<=Parser.parse(searchPage.getMapMarkPrice()))
                    && (Parser.parsePrice(maxPrice)>=Parser.parse(searchPage.getMapMarkPrice()))
                    && (Parser.parse(bedNumber)<=Parser.parse(searchPage.getMapMarkBed()))
                    && (Parser.parse(bathNumber)<=Parser.parse(searchPage.getMapMarkBath()))
                    && (Parser.parse(minSqft)<=Parser.parse(searchPage.getMapMarkSqft()))
                    && (Parser.parse(maxSqft)>=Parser.parse(searchPage.getMapMarkSqft()));});
    }
}
