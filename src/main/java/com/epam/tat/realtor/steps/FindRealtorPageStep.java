package com.epam.tat.realtor.steps;

import com.epam.tat.realtor.pages.FindRealtorPage;
import org.openqa.selenium.WebDriver;

public class FindRealtorPageStep extends BasePageStep {

    private FindRealtorPage searchRealtorPage;

    public FindRealtorPageStep(WebDriver driver) {
        super(driver);
        searchRealtorPage = new FindRealtorPage(driver);
    }

    /**
     * set city for realtor
     *
     * @param city which realtors work in
     * @return RealtorPageStep
     */
    public FindRealtorPageStep setCity(String city) {
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
