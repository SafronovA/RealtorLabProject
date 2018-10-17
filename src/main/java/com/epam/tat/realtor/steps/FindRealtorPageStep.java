package com.epam.tat.realtor.steps;

import com.epam.tat.realtor.pages.FindRealtorPage;
import org.openqa.selenium.WebDriver;

public class FindRealtorPageStep extends BasePageStep {

    private FindRealtorPage findRealtorPage;

    public FindRealtorPageStep(WebDriver driver) {
        super(driver);
        findRealtorPage = new FindRealtorPage(driver);
    }

    /**
     * create realtor search request
     *
     * @param realtorName realtor name to be searched
     * @return new RealtorSearchResultPageStep
     */
    public FindRealtorPageStep enterRealtorName(String realtorName) {
        findRealtorPage.enterRealtorName(realtorName);
        return this;
    }

    /**
     * create search request by location
     *
     * @param location realtors location
     * @return new RealtorSearchResultPageStep
     */
    public FindRealtorPageStep enterRealtorsLocation(String location) {
        findRealtorPage.enterLocation(location);
        return this;
    }

    /**
     * click search button
     *
     * @return new RealtorSearchResultPageStep
     */
    public RealtorSearchResultPageStep clickSearchButton(){
        findRealtorPage.clickSearchButton();
        return new RealtorSearchResultPageStep(driver);
    }

}
