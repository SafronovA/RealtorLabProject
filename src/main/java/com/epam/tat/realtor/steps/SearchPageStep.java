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

    /**
     * set min and max price to drop-down menu
     * @param minPrice will be set to drop-down menu
     * @param maxPrice will be set to drop-down menu
     * @return SearchPageStep
     */
    public SearchPageStep selectMinMaxPrices(String minPrice, String maxPrice){
        searchPage.clickPriceButton();
        searchPage.getMinPriceRange().stream().filter(WebElement -> WebElement.getText().equals(minPrice)).findFirst().get().click();
        searchPage.getMaxPriceRange().stream().filter(WebElement -> WebElement.getText().equals(maxPrice)).findFirst().get().click();
        return this;
    }

    /**
     * click save button to save search
     * @return SearchPageStep
     */
    public SearchPageStep clickSaveSearchButton(){
        searchPage.clickSaveSearchButton();
        return this;
    }

    /**
     * open saved searches page
     * @return SavedSearchesPageStep
     */
    public SavedSearchesPageStep openSavedSearches(){
        searchPage.waitUntilSaveButtonChangeState()
                .clickUserIcon()
                .clickSavedSearches();
        return new SavedSearchesPageStep(driver);
    }
}
