package com.epam.tat.realtor.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchPage extends BasePage {

    public SearchPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "desktop-price-div")
    private WebElement priceButton;
    @FindBy(xpath = "(//*[@id='price-input-1-list'])[1]/li")
    private List<WebElement> minPriceRange;
    @FindBy(xpath = "(//*[@id='price-input-2-list'])[1]/li")
    private List<WebElement> maxPriceRange;
    @FindBy(id = "facet-followbtn")
    private WebElement saveSearchButton;
    @FindBy(xpath = "//*[@id='my-account-url']/following-sibling::span[1]")
    private WebElement userIcon;
    @FindBy(xpath = "//*[@id='js-price-filter-pill-xx']")
    private WebElement chosenCriteria;
    @FindBy(xpath = "(//*[@id='facet-followbtn'])[2]/span")
    private WebElement saveButtonText;
    @FindBy(xpath = "//select[@id='srp-sortby']")
    private WebElement sortOptionsDropDown;
    @FindBy(xpath = "//*[@id='srp-sortby']/option")
    private List<WebElement> sortOptionsList;
    @FindBy(xpath = "//*[@id='srp-list']/ul/li")
    private List<WebElement> searchResultList;

    /**
     * get list of min prices
     *
     * @return list of min prices
     */
    public List<WebElement> getMinPriceRange() {
        return minPriceRange;
    }

    /**
     * get list of max prices
     *
     * @return list of max prices
     */
    public List<WebElement> getMaxPriceRange() {
        return maxPriceRange;
    }

    /**
     * get list of sort option
     *
     * @return list of sort options
     */
    public List<WebElement> getSortOptionsList() {
        return sortOptionsList;
    }

    /**
     * get list of homes satisfying the search criteria
     *
     * @return list of homes
     */
    public List<WebElement> getSearchResultList() {
        return searchResultList;
    }

    /**
     * click price button
     *
     * @return this page
     */
    public SearchPage clickPriceButton() {
        priceButton.click();
        return this;
    }

    /**
     * click save search button
     *
     * @return this page
     */
    public SearchPage clickSaveSearchButton() {
        waitUntilElementIsVisible(chosenCriteria);
        saveSearchButton.click();
        return this;
    }

    /**
     * wait until save button will be saved
     *
     * @return this page
     */
    public SearchPage waitUntilSaveButtonChangeState() {
        waitUntilElementIsVisible(saveButtonText);
        return this;
    }

    /**
     * click on user icon
     *
     * @return new SavedHomesPage
     */
    public SavedHomesPage clickUserIcon() {
        waitUntilElementIsClickable(userIcon);
        userIcon.click();
        return new SavedHomesPage(driver);
    }

    /**
     * click on sort by drop-down
     *
     * @return
     */
    public SearchPage clickSortOptionsDropDown() {
        waitUntilElementIsClickable(sortOptionsDropDown);
        sortOptionsDropDown.click();
        return this;
    }

}
