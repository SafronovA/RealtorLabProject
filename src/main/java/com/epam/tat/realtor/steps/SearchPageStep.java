package com.epam.tat.realtor.steps;

import com.epam.tat.realtor.pages.SearchPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchPageStep extends BasePageStep{
    private SearchPage searchPage;

    public SearchPageStep(WebDriver driver){
        super(driver);
        searchPage = new SearchPage(driver);
    }

    public SearchPageStep selectMinMaxPrices(String minPrice, String maxPrice){
        searchPage.clickPriceButton();
        searchPage.getMinPriceRange().stream().filter(WebElement -> WebElement.getText().equals(minPrice)).findFirst().get().click();
        searchPage.getMaxPriceRange().stream().filter(WebElement -> WebElement.getText().equals(maxPrice)).findFirst().get().click();
        return this;
    }

}
