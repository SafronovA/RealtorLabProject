package com.epam.tat.realtor.mobilesteps;

import com.epam.tat.realtor.mobilepages.SearchPage;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

public class SearchPageStep extends BasePageStep{
    private SearchPage searchPage;
    public SearchPageStep(AppiumDriver<WebElement> driver){
        super(driver);
        searchPage= new SearchPage(driver);
    }
    public HomePageStep  enterSearchCity(String cityName) {
        searchPage.searchInputSendKeys(cityName)
                .firstResultClick();
        return new HomePageStep(driver);
    }
}
