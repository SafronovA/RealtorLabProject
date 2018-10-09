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
     * set city for realtor
     *
     * @param city which realtors work in
     * @return RealtorPageStep
     */
    public SearchRealtorPageStep setCity(String city) {
        searchRealtorPage.setCity(city);
        return this;
    }


    /**
     * create realtor search request
     *
     * @param realtorName realtor name to be searched
     * @return new FindRealtorPageStep
     */
    public RealtorSearchResultPageStep findRealtor(String realtorName) {
        searchRealtorPage.enterRealtorName(realtorName).clickSearchButton();
        return new RealtorSearchResultPageStep(driver);
    }
}
