package com.epam.tat.realtor.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class RealtorSearchResultPage extends BasePage {
    public RealtorSearchResultPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "(//div[@class='agent-detail-item ellipsis']/a/strong)[2]")
    private WebElement realtorSoldHouses;
    @FindBy(xpath = "//div[@class='agent-list-card-img']/img")
    private WebElement userIcon;
    @FindBy(xpath = "//div[@class='rating-count']")
    private WebElement ratingCount;
    @FindBy(xpath = "//*[@id='filter_5']")
    private WebElement recommendationFilterButton;
    @FindBy(xpath = "//*[@id='recommendation_container']//span")
    private List<WebElement> recommendationContainer;
    @FindBy(xpath = "//*[@class='dropdown-menu list-sort-dropdown']//a")
    private List<WebElement> sortByOptions;
    @FindBy(id = "list_sort")
    private WebElement sortByButton;
    @FindBy(xpath = "//*[@class='agent-recommendation ellipsis']//strong")
    private List<WebElement> numberOfRecommendationsList;
    @FindBy(xpath = "//a[@class='next']")
    private List<WebElement> nextPageButton;
    @FindBy(xpath = "//div[@id='map_link']")
    private WebElement activityMapButton;

    /**
     * get number of realtor sold houses
     *
     * @return get number of realtor sold houses
     */
    public String getRealtorSoldHouses() {
        return realtorSoldHouses.getText();
    }

    /**
     * get rating count
     *
     * @return rating count
     */
    public WebElement getRatingCount() {
        return ratingCount;
    }

    /**
     * get recommendation container
     *
     * @return recommendation container
     */
    public List<WebElement> getRecommendationContainer() {
        return recommendationContainer;
    }

    /**
     * get realtor rating
     *
     * @return realtor rating
     */
    public List<WebElement> getSortByOptions() {
        return sortByOptions;
    }

    /**
     * get numberOfRecommendations list
     *
     * @return number of recommendations list
     */
    public List<WebElement> getNumberOfRecommendationsList() {
        waitForJQueryIsLoad();
        return numberOfRecommendationsList;
    }

    /**
     * get next button
     * @return nextButton
     */
    public List<WebElement> getNextPageButton(){
        return nextPageButton;
    }

    /**
     * click on activity map button
     *
     * @return this page
     */
    public RealtorSearchResultPage clickActivityMapButton(){
        activityMapButton.click();
        return this;
    }

    /**
     * click on the realtor icon
     *
     * @return new RealtorPage
     */
    public RealtorPage clickRealtorIcon() {
        waitUntilElementIsClickable(userIcon);
        userIcon.click();
        return new RealtorPage(driver);
    }

    /**
     * click sortBy button
     *
     * @return this page
     */
    public RealtorSearchResultPage clickSortByButton() {
        waitForJQueryIsLoad();
        sortByButton.click();
        return this;
    }

    /**
     * click sortBy button
     *
     * @return this page
     */
    public RealtorSearchResultPage clickRecommendationFilterButton() {
        waitForJQueryIsLoad();
        recommendationFilterButton.click();
        return this;
    }

    /**
     * click sortBy button
     *
     * @return this page
     */
    public RealtorSearchResultPage clickNextPageButton() {
        waitForJQueryIsLoad();
        nextPageButton.get(0).click();
        return this;
    }

}
