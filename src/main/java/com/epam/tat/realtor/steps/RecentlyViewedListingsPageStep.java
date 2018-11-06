package com.epam.tat.realtor.steps;

import com.epam.tat.realtor.pages.RecentlyViewedListingsPage;
import io.appium.java_client.AppiumDriver;

public class RecentlyViewedListingsPageStep extends BasePageStep {

    private RecentlyViewedListingsPage recentlyViewedListingsPage;

    public RecentlyViewedListingsPageStep(AppiumDriver driver) {
        super(driver);
        recentlyViewedListingsPage = new RecentlyViewedListingsPage(driver);
    }

    public boolean chechAddresses(String address){
        return address.contains(recentlyViewedListingsPage.getHouseAddress());
    }
}
