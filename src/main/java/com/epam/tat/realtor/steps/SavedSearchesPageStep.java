package com.epam.tat.realtor.steps;

import com.epam.tat.realtor.pages.SavedSearchesPage;
import com.epam.tat.realtor.util.Parser;
import org.openqa.selenium.WebDriver;

public class SavedSearchesPageStep extends BasePageStep {

    private SavedSearchesPage savedSearchesPage;

    public SavedSearchesPageStep(WebDriver driver) {
        super(driver);
        savedSearchesPage = new SavedSearchesPage(driver);
    }

    /**
     * delete saved searches
     * @return
     */
    public SavedSearchesPageStep clearAllOldSavedSearches(){
        if(!savedSearchesPage.getSavedSearchesList().isEmpty()) {
            savedSearchesPage.getSavedSearchesList().stream().forEach(WebElement -> {
                savedSearchesPage.clickDeleteButton();
                savedSearchesPage.clickConfirmDeleteButton();
            });
        }
        return this;
    }

    /**
     * check that saved search description contains entered parameters
     * @param city entered city
     * @param minPrice selected min price
     * @param maxPrice selected max price
     * @return 
     */
    public boolean checkSavedSearchDescriptionContainsInputText(String city, String minPrice, String maxPrice){
        int min = Parser.parse(minPrice);
        int max = Parser.parse(maxPrice);
        boolean containingInputTextInDescription = savedSearchesPage.getCity().contains(city)
                && checkSavedSearchDescriptionContainsPrice(min, max);
        return containingInputTextInDescription;
    }

    private boolean checkSavedSearchDescriptionContainsPrice(int minPrice, int maxPrice){
        String[] minMaxPrices = savedSearchesPage.getPrice().split("-");
        return minPrice == Parser.parse(minMaxPrices[0]) && maxPrice == Parser.parse(minMaxPrices[1]);
    }

}
