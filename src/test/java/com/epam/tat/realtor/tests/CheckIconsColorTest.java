package com.epam.tat.realtor.tests;

import com.epam.jira.JIRATestKey;
import com.epam.jira.testng.RetryAnalyzer;
import com.epam.tat.realtor.steps.RealtorSearchResultPageStep;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckIconsColorTest extends BaseTest {
    private static final String LOCATION = "Boston, MA";
    private static final String NAME = "Kristen Gaughan";
    private RealtorSearchResultPageStep realtorSearchResultPageStep;

    /**
     * click find realtor button on home page
     * set realtor location
     * set realtor name
     * click submit
     * click activity map button
     * click get started button
     * select first realtor
     * click 'see agents nearby properties' if it presents on the page
     * check that the statuses of houses and the statuses of icons on the map correspond to each other
     */
    @JIRATestKey(key = "EPMFARMATS-5237", retryCountIfFailed = 2)
    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void checkIconsColor() {
        realtorSearchResultPageStep = homePageStep.clickFindRealtorButton()
                .enterRealtorsLocation(LOCATION)
                .enterRealtorName(NAME)
                .clickSearchButton()
                .clickActivityMapButton()
                .clickGetStartedConfirmButton()
                .selectFirstRealtorCard()
                .clickSeeAgentsNearbyProperties();

        Assert.assertTrue(realtorSearchResultPageStep.colorIsCorrect(),
                "Found at least 1 mismatch of home status and status of the icon on the map");
    }
}
