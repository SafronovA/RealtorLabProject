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
     * set city for realtor
     *
     * @param city which realtors work in
     * @return RealtorPageStep
     */
    public FindRealtorPageStep setCity(String city) {
        findRealtorPage.setCity(city);
        return this;
    }

    /**
     * create realtor search request
     *
     * @param realtorName realtor name to be searched
     * @return new RealtorSearchResultPageStep
     */
    public RealtorSearchResultPageStep findRealtor(String realtorName) {
        findRealtorPage.enterRealtorName(realtorName).clickSearchButton();
        return new RealtorSearchResultPageStep(driver);
    }

    /**
     * create search request by location
     *
     * @param location realtors location
     * @return new RealtorSearchResultPageStep
     */
    public RealtorSearchResultPageStep findRealtorsByLocation(String location) {
        findRealtorPage.enterLocation(location).clickSearchButton();
        return new RealtorSearchResultPageStep(driver);
    }

}
