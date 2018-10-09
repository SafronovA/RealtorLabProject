package com.epam.tat.realtor.steps;

import com.epam.tat.realtor.pages.SearchRealtorPage;
import org.openqa.selenium.WebDriver;

public class SearchRealtorPageStep extends BasePageStep {

    private SearchRealtorPage searchRealtorPage;

    public SearchRealtorPageStep(WebDriver driver) {
        super(driver);
        searchRealtorPage = new SearchRealtorPage(driver);
    }

    /**
     * create realtor search request
     *
     * @param realtorName realtor name to be searched
     * @return new RealtorSearchResultPageStep
     */
    public RealtorSearchResultPageStep findRealtor(String realtorName) {
        searchRealtorPage.enterRealtorName(realtorName).clickSearchButton();
        return new RealtorSearchResultPageStep(driver);
    }

    /**
     * create search request by location
     *
     * @param location realtors location
     * @return new RealtorSearchResultPageStep
     */
    public RealtorSearchResultPageStep findRealtorsByLocation(String location) {
        searchRealtorPage.enterLocation(location).clickSearchButton();
        return new RealtorSearchResultPageStep(driver);
    }

}
