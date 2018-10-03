package com.epam.tat.realtor.steps;

import com.epam.tat.realtor.pages.SavedSearchesPage;
import com.epam.tat.realtor.util.Parser;
import org.openqa.selenium.WebDriver;

public class SavedSearchesPageStep extends BasePageStep {

    private static final String DASH = "-";
    private SavedSearchesPage savedSearchesPage;

    public SavedSearchesPageStep(WebDriver driver) {
        super(driver);
        savedSearchesPage = new SavedSearchesPage(driver);
    }

    /**
     * delete saved searches
     *
     * @return this page
     */
    public SavedSearchesPageStep clearAllOldSavedSearches() {
        if (!savedSearchesPage.getSavedSearchesList().isEmpty()) {
            savedSearchesPage.getSavedSearchesList().stream().forEach(WebElement -> {
                savedSearchesPage.clickDeleteButton();
                savedSearchesPage.clickConfirmDeleteButton();
            });
        }
        return this;
    }

    /**
     * check that saved search description contains entered parameters
     *
     * @param city     entered city
     * @param minPrice selected min price
     * @param maxPrice selected max price
     * @return true if saved search description contains selected min and max prices, entered town, false if does not contain
     */
    public boolean checkSavedSearchDescriptionContainsInputText(String city, String minPrice, String maxPrice) {
        int min = Parser.parse(minPrice);
        int max = Parser.parse(maxPrice);
        boolean containingInputTextInDescription = savedSearchesPage.getCity().contains(city)
                && doesSavedSearchDescriptionContainPrice(min, max);
        return containingInputTextInDescription;
    }

    /**
     * navigate to user icon
     * click sign out button
     */
    public HomePageStep logOut() {
        savedSearchesPage.navigateToUserIcon()
                .clickLogOutLink();
        return new HomePageStep(driver);
    }

    /**
     * go to home page
     *
     * @return
     */
    public HomePageStep goToHomePage() {
        savedSearchesPage.clickHomePageLink();
        return new HomePageStep(driver);
    }

    /**
     * check that saved search description min and max price corresponds to entered min and max price
     *
     * @param minPrice
     * @param maxPrice
     * @return true if description contains input prices, false if if does not
     */
    private boolean doesSavedSearchDescriptionContainPrice(int minPrice, int maxPrice) {
        String[] minMaxPrices = savedSearchesPage.getPrice().split(DASH);
        return minPrice == Parser.parse(minMaxPrices[0]) && maxPrice == Parser.parse(minMaxPrices[1]);
    }

}
