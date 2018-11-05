package com.epam.tat.realtor.steps_mob;

import com.epam.tat.realtor.pages_mob.BasePage;
import com.epam.tat.realtor.pages_mob.HomePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.remote.RemoteWebElement;

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

    public int getSearchResultCount(){
        return homePage.searchResultCount();
    }

    public int getNumberOfAllHousesFromScreen(){
        int expectedNumberOfHomes = getSearchResultCount();
        Set<String> homes = new HashSet<>();
        homes.addAll(receiveAddressesFromAndroidElementList(homePage.getHouseAddressesFromScreen()));
        while (homes.size() < expectedNumberOfHomes) {
            BasePage.swipeUp(driver);
            homes.addAll(receiveAddressesFromAndroidElementList(homePage.getHouseAddressesFromScreen()));
        }
        return homes.size();
    }

    private Set<String> receiveAddressesFromAndroidElementList(List<AndroidElement> addresses) {
        Set<String> homeAddresses = addresses.stream().map(AndroidElement::getText).collect(Collectors.toSet());
        return homeAddresses;
    }

    public void HFS(){
        List<AndroidElement> list = homePage.getHouseAddressesFromScreen();
        System.out.println(list.size());
        BasePage.swipeUp(driver);

        list.addAll(homePage.getHouseAddressesFromScreen());
        System.out.println(list.size());
    }
}
