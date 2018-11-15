package com.epam.tat.realtor.steps;

import com.epam.tat.realtor.pages.ViewSearchResultsPage;
import com.epam.tat.realtor.util.Parser;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ViewSearchResultsPageStep extends BasePageStep {
    private ViewSearchResultsPage viewSearchResultsPage;
    private Set<Integer> propertyPrice = new HashSet<>();
    private Set<Integer> propertyBed = new HashSet<>();
    private Set<Integer> propertyBath = new HashSet<>();

    public ViewSearchResultsPageStep(AppiumDriver driver) {
        super(driver);
        viewSearchResultsPage = new ViewSearchResultsPage(driver);
    }

    public int getNumberOfAllHousesFromSearchResult() {
        return getAllHouseAddressesFromSearchResult().size();
    }

    private Set getAllHouseAddressesFromSearchResult(){
        Set<String> homeAddresses = new HashSet<>();
        homeAddresses.addAll(receiveAddressesFromAndroidElementList(viewSearchResultsPage.getHouseAddressesFromScreen()));
        while (viewSearchResultsPage.getExpandSearchAreaButton().isEmpty()) {
            swipe(driver);
            homeAddresses.addAll(receiveAddressesFromAndroidElementList(viewSearchResultsPage.getHouseAddressesFromScreen()));
        }
        return homeAddresses;
    }

    private Set<String> receiveAddressesFromAndroidElementList(List<AndroidElement> addresses) {
        try {                       // waiting for the page to become static after the swipe
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Set<String> homeAddresses = addresses.stream().map(AndroidElement::getText).collect(Collectors.toSet());
        return homeAddresses;
    }

    public ViewSearchResultsPageStep createPropertyList(){
        viewSearchResultsPage.waitForViewList();

        do{
            propertyPrice.addAll(viewSearchResultsPage.getHomePrice().stream().map(x-> Parser.parse(x.getText())).collect(Collectors.toList()));
            propertyBed.addAll(viewSearchResultsPage.getHomeBedCount().stream().map(x->Parser.parse(x.getText())).collect(Collectors.toList()));
            propertyBath.addAll(viewSearchResultsPage.getHomeBathCount().stream().map(x->Parser.parse(x.getText())).collect(Collectors.toList()));
            viewSearchResultsPage.swipeView();
        }
        while(viewSearchResultsPage.getExpandButton()<1);
        return this;
    }

    public boolean checkSearchResults(String MIN_PRICE_VALUE, String MAX_PRICE_VALUE, int BATH_QUANTITY, int BED_QUANTITY) {
        return propertyPrice.stream().peek(x->System.out.print(x+" ")).allMatch(x->(x<=Integer.valueOf(MAX_PRICE_VALUE))&&(x>=Integer.valueOf(MIN_PRICE_VALUE)))
                && propertyBed.stream().peek(x->System.out.print(x+" ")).allMatch(x->x>= BED_QUANTITY)
                && propertyBath.stream().peek(x->System.out.print(x+" ")).allMatch(x->x>=BATH_QUANTITY);
    }
    public boolean checkSoldStatus() {
        viewSearchResultsPage.waitForViewList();
        boolean soldStatus = true;
        do{
            soldStatus&=viewSearchResultsPage.getHomeStatus().stream().allMatch(x->x.getText().trim().equals("Sold"));
            viewSearchResultsPage.swipeView();
        }
        while(viewSearchResultsPage.getExpandButton()<1);
        return soldStatus;
    }

    //////////////////

    public FilterPageStep clickFilterButton(){
        viewSearchResultsPage.clickFilterButton();
        return new FilterPageStep(driver);
    }

    public HousePageStep clickOnFirstHouse(){
        viewSearchResultsPage.clickOnFirstHouse();
        return new HousePageStep(driver);
    }

    public SortOptionsPageStep clickSortByButton(){
        viewSearchResultsPage.clickSortByButton();
        return new SortOptionsPageStep(driver);
    }

    public boolean doesHomeDisplayedSortedByPrice(){
        List<Integer> homePrices = getAllHomePricesFromPage();
        boolean sortedDescending =
                IntStream.range(0, homePrices.size() - 1)
                        .allMatch(i -> homePrices.get(i).compareTo(homePrices.get(i + 1)) <= 0);
        return sortedDescending;

    }

    public MainPageStep clickGoBackButton(){
        viewSearchResultsPage.clickGoBackButton();
        return new MainPageStep(driver);
    }

    private List<Integer> getAllHomePricesFromPage(){
        List<Integer> homePricesList = new ArrayList<>();
        while (viewSearchResultsPage.getExpandSearchAreaButton().isEmpty()) {
            swipe(driver);
            homePricesList.addAll(parseAndroidElementsListToIntegerList(viewSearchResultsPage.getHomePricesList()));
        }
        return homePricesList;
    }

    private List<Integer> parseAndroidElementsListToIntegerList(List<AndroidElement> homePricesList){
        try {                       // waiting for the page to become static after the swipe
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return homePricesList.stream().map(AndroidElement::getText).map(Parser::parse).collect(Collectors.toList());
    }

}
