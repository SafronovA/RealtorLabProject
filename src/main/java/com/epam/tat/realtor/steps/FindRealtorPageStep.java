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
    public FindRealtorPageStep setLocation(String city) {
        findRealtorPage.enterLocation(city);
        return this;
    }

    /**
     * set name for realtor
     *
     * @param name realtor name
     * @return RealtorPageStep
     */
    public FindRealtorPageStep setName(String name) {
        findRealtorPage.enterRealtorName(name);
        return this;
    }

    /**
     * perform submit operation
     *
     * @return RealtorPageStep
     */
    public RealtorSearchResultPageStep clickSearchButton() {
        findRealtorPage.clickSearchButton();
        return new RealtorSearchResultPageStep(driver);
    }

}
