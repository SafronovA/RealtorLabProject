package com.epam.tat.realtor.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SearchPage extends BasePage {

    public SearchPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "desktop-price-div")
    private WebElement priceButton;
    @FindBy (xpath = "(//*[@id='price-input-1-list'])[1]/li")
    private List<WebElement> minPriceRange;
    @FindBy (xpath = "(//*[@id='price-input-2-list'])[1]/li")
    private List<WebElement> maxPriceRange;
    @FindBy(id = "facet-followbtn")
    private WebElement saveSearchButton;
    @FindBy(xpath = "//*[@id='my-account-url']/following-sibling::span[1]")
    private WebElement userIcon;
    @FindBy(xpath = "//*[@id='my_search_div']/div/a")
    private WebElement savedSearchLink;

    /**
     * get list of min prices
     * @return
     */
    public List<WebElement> getMinPriceRange() {
        return minPriceRange;
    }

    /**
     * get list of max prices
     * @return
     */
    public List<WebElement> getMaxPriceRange() {
        return maxPriceRange;
    }

    /**
     * click price button
     * @return
     */
    public SearchPage clickPriceButton(){
        priceButton.click();
        return this;
    }

    /**
     * click save search button
     * @return
     */
    public SearchPage clickSaveSearchButton(){
        saveSearchButton.click();
        return this;
    }

    /**
     * navigate to user icon
     * @return this page
     */
    public SearchPage navigateToUserIcon(){
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Actions(driver).moveToElement(userIcon).perform();
        return this;
    }

    /**
     * click saved search link to navigate to page with saved searches
     * @return Saved Searches Page (navigate to new page)
     */
    public SavedSearchesPage clickSavedSearchLink(){
        waitUntilElementIsClickable(savedSearchLink);
        savedSearchLink.click();
        return new SavedSearchesPage(driver);
    }


}
