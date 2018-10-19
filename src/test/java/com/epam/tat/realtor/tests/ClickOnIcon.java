package com.epam.tat.realtor.tests;

import com.epam.tat.realtor.steps.RealtorSearchResultPageStep;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ClickOnIcon extends BaseTest {
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
     * check that icon status become 'selected' after clicking on it. In other words icon should increase.
     */
    @Test
    public void checkIconsColor() {
        realtorSearchResultPageStep = homePageStep.clickFindRealtorButton()
                .enterRealtorsLocation(LOCATION)
                .enterRealtorName(NAME)
                .clickSearchButton()
                .clickActivityMapButton()
                .clickGetStartedButton()
                .selectFirstRealtorCard();

        Assert.assertTrue(realtorSearchResultPageStep.iconsBecomeSelected(),
                "Found at least one icon on the map, which did not change status / did not increase after clicking on it");
    }
}