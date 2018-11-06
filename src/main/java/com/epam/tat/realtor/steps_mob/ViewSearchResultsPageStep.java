package com.epam.tat.realtor.steps_mob;

import com.epam.tat.realtor.pages_mob.ViewSearchResultsPage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ViewSearchResultsPageStep extends BasePageStep {
    private ViewSearchResultsPage viewSearchResultsPage;

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
}
