package com.epam.tat.realtor.mobilesteps;

import com.epam.tat.realtor.mobilepages.FilterPage;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

public class FilterPageStep extends BasePageStep {
    private FilterPage filterPage;
    public FilterPageStep(AppiumDriver<WebElement> driver){
        super(driver);
        filterPage= new FilterPage(driver);
    }
    public HomePageStep createFilterRequest(String minPrice, String maxPrice){
        filterPage.enterMinPrice(minPrice)
                .enterMaxPrice(maxPrice)
                .tapBedsSection()
                .swipeToBedsSection()
                .chooseBeds()
                .chooseBath()
                .clickViewButton();
        return new HomePageStep(driver);
    }
}
