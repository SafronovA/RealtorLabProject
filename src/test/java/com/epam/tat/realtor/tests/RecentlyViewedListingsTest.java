package com.epam.tat.realtor.tests;

import com.epam.tat.realtor.steps.HousePageStep;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RecentlyViewedListingsTest extends BaseTest {

    private static final String CITY = "Wildwood, NY";

    @Test
    public void recentlyViewedListings() {
        HousePageStep housePageStep = mainPageStep
//                .clickMenuButton()
//                .clickStartNewSearch()
//                .enterSearchCity(CITY)

//                .openViewListPage()
                .clickFirstHouseCard();
        String houseAddress = housePageStep.getHouseAddress();
        HousePageStep recentlyHousePageStep =
                housePageStep.clickGoBackButton()
                .clickMenuButton()
                .clickRecentlyViewedListingsButton()
                .clickOnFirstHouse();
        Assert.assertEquals(houseAddress, recentlyHousePageStep.getHouseAddress(),
                "Addresses do not match");
    }

}
