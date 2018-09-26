package com.epam.tat.realtor.steps;

import com.epam.tat.realtor.ConfigProperties;
import com.epam.tat.realtor.bo.House;
import com.epam.tat.realtor.pages.SearchPage;
import com.epam.tat.realtor.util.RealtorUtil;
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
        List<House> homesList = new ArrayList<>();
        for (int i = 0; i < searchPage.getSearchedHousePricesList().size() ; i++) {
            homesList.add(new House( RealtorUtil.parse(searchPage.getSearchedHouseBedList().get(i).getText()),
                    RealtorUtil.parse(searchPage.getSearchedHouseBathList().get(i).getText()),
                    RealtorUtil.parse(searchPage.getSearchedHousePricesList().get(i).getText()),
                    RealtorUtil.parse(searchPage.getSearchedHouseSqftList().get(i).getText())));
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

    /**
     * check if parameters of houses in the list match search criteria
     * @param homeList list of house according search result
     * @param minPrice min price value
     * @param maxPrice max price value
     * @param bedNumber bed number
     * @param bathNumber bath number
     * @param minSqft min square feet house size
     * @param maxSqft max square feet house size
     * @return if true list match search criteria
     */
    public boolean checkSearchResult (List<House> homeList, int minPrice, int maxPrice, int bedNumber, int bathNumber, int minSqft, int maxSqft ){
        System.out.println(minPrice+" "+maxPrice+" "+bedNumber+" "+bathNumber+" "+minSqft+" "+maxSqft);
        return homeList.stream().allMatch(x->((x.getPrice()>=minPrice) && (x.getPrice()<=maxPrice) &&
                (x.getBedNumber()>=bedNumber) &&
                (x.getBathNumber()>=bathNumber) &&
                (x.getSquare()>=minSqft) && (x.getSquare()<=maxSqft)));
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
    public boolean checkMapMarks(int minPrice, int maxPrice, int bedNumber, int bathNumber, int minSqft, int maxSqft ){
        searchPage.clickViewMapButton();
        return searchPage.getMapMarks().stream().allMatch(x->{RealtorUtil.clickByJEx(x,driver);;
            return (minPrice<=RealtorUtil.parse(searchPage.getMapMarkPrice()))
                    && (maxPrice>=RealtorUtil.parse(searchPage.getMapMarkPrice()))
                    && (bedNumber<=RealtorUtil.parse(searchPage.getMapMarkBed()))
                    && (bathNumber<=RealtorUtil.parse(searchPage.getMapMarkBath()))
                    && (minSqft<=RealtorUtil.parse(searchPage.getMapMarkSqft()))
                    && (maxSqft>=RealtorUtil.parse(searchPage.getMapMarkSqft()));});
    }
}
