package com.epam.tat.realtor.steps;


import com.epam.tat.realtor.pages.SearchPage;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

public class SearchPageStep extends BasePageStep{
    private SearchPage searchPage;
    public SearchPageStep(AppiumDriver<WebElement> driver){
        super(driver);
        searchPage= new SearchPage(driver);
    }
    public MainPageStep enterSearchCity(String cityName) {
        searchPage.searchInputSendKeys(cityName)
                .firstResultClick();
        return new MainPageStep(driver);
    }
}
