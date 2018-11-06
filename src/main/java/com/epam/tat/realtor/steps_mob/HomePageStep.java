package com.epam.tat.realtor.steps_mob;

import com.epam.tat.realtor.pages_mob.HomePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class HomePageStep extends BasePageStep {
    private HomePage homePage;

    public HomePageStep(AppiumDriver driver) {
        super(driver);
        homePage = new HomePage(driver);
    }


    public MenuPageStep clickMenu() {
        homePage.clickMenuButton();
        return new MenuPageStep(driver);
    }

    public HomePageStep openFilter() {
        homePage.clickFilterButton();
        return this;
    }

    public HomePageStep enterCity(String city) {
        homePage.clickClearCityIcon()
                .enterCity(city);
        return this;
    }

    public HomePageStep enterPriceRange(String minPrice, String maxPrice) {
        homePage.enterMinPrice(minPrice);
        homePage.enterMaxPrice(maxPrice);
        return this;
    }

    public HomePageStep openHousesList() {
        homePage.openViewPage();
        return this;
    }

    public HomePageStep clickViewResultsButton() {
        homePage.clickViewResultsButton();
        return this;
    }

    public HousePageStep clickFirstHouseCard(){
        homePage.clickFirstHouseCard();
        return new HousePageStep(driver);
    }

    public int getSearchResultCount(){
        return homePage.searchResultCount();
    }

    public int getNumberOfAllHousesFromSearchResult() {
        return getAllHouseAddressesFromSearchResult().size();
    }

    private Set getAllHouseAddressesFromSearchResult(){
        Set<String> homeAddresses = new HashSet<>();
        homeAddresses.addAll(receiveAddressesFromAndroidElementList(homePage.getHouseAddressesFromScreen()));
        while (homePage.getExpandSearchAreaButton().isEmpty()) {
            swipe(driver);
            homeAddresses.addAll(receiveAddressesFromAndroidElementList(homePage.getHouseAddressesFromScreen()));
        }
        return homeAddresses;
    }

    private Set<String> receiveAddressesFromAndroidElementList(List<AndroidElement> addresses) {
        try {                       // waiting for the page to become static after the swipe
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Set<String> homeAddresses = addresses.stream().map(AndroidElement::getText).collect(Collectors.toSet());
        return homeAddresses;
    }

}
