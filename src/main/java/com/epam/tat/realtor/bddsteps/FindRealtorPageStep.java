package com.epam.tat.realtor.bddsteps;

import com.epam.tat.realtor.pages.FindRealtorPage;
import com.epam.tat.realtor.steps.BasePageStep;
import cucumber.api.java.en.And;
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
    @And("enter realtor name ")
    public void enterRealtorName(String realtorName) {
        findRealtorPage.enterRealtorName(realtorName);
    }

    /**
     * create search request by location
     *
     * @param location realtors location
     * @return new RealtorSearchResultPageStep
     */
    @And("enter realtor location ")
    public void enterRealtorsLocation(String location) {
        findRealtorPage.enterLocation(location);
    }

    /**
     * click search button
     *
     * @return new RealtorSearchResultPageStep
     */
    @And("click search button")
    public void clickSearchButton(){
        findRealtorPage.clickSearchButton();
    }

}
