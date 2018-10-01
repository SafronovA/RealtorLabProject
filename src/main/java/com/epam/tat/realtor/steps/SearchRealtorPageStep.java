package com.epam.tat.realtor.steps;

import com.epam.tat.realtor.pages.SearchRealtorPage;
import org.openqa.selenium.WebDriver;

public class SearchRealtorPageStep extends BasePageStep{

    private SearchRealtorPage searchRealtorPage;

    public SearchRealtorPageStep(WebDriver driver) {
        super(driver);
        searchRealtorPage = new SearchRealtorPage(driver);
    }

    public FindRealtorPageStep findRealtor(String realtorName){
        searchRealtorPage.enterRealtorName(realtorName).clickSearchButton();
        return new FindRealtorPageStep(driver);
    }
}
