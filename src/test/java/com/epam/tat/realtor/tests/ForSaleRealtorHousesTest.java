package com.epam.tat.realtor.tests;

import com.epam.jira.JIRATestKey;
import com.epam.jira.testng.RetryAnalyzer;
import com.epam.tat.realtor.web.steps.RealtorPageStep;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ForSaleRealtorHousesTest extends BaseTest {

    private static final String CITY_NAME = "San Francisco, CA";
    private static final String REALTOR_NAME = "Grace Lucero";

    /**
     * check that for sale houses on realtor page have status for sale
     */
    @JIRATestKey(key = "EPMFARMATS-5232", retryCountIfFailed = 2)
    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void forSaleRealtorHouses() {
        RealtorPageStep realtorPageStep = homePageStep.clickFindRealtorButton()
                .enterRealtorsLocation(CITY_NAME)
                .enterRealtorName(REALTOR_NAME)
                .clickSearchButton()
                .clickRealtorIcon();
        Assert.assertTrue(realtorPageStep.areHousesHaveStatusForSale(),
                "One of houses do not have 'For Sale' status");
    }

}
