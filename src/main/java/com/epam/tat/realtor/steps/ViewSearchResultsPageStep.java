package com.epam.tat.realtor.steps;

import com.epam.tat.realtor.pages.ViewSearchResultsPage;
import com.epam.tat.realtor.util.Parser;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.WebElement;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ViewSearchResultsPageStep extends BasePageStep {
    private ViewSearchResultsPage viewSearchResultsPage;
    private Set<Integer> propertyPrice = new HashSet<>();
    private Set<Integer> propertyBed = new HashSet<>();
    private Set<Integer> propertyBath = new HashSet<>();

    public ViewSearchResultsPageStep(AppiumDriver driver) {
        super(driver);
        viewSearchResultsPage = new ViewSearchResultsPage(driver);
    }


    public HousePageStep clickFirstHouseCard(){
        viewSearchResultsPage.clickFirstHouseCard();
        return new HousePageStep(driver);
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
}
