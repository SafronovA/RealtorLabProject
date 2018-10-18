package com.epam.tat.realtor.pages;

import org.openqa.selenium.By;
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

    private final String ICONS_ON_MAP_LOCATOR = "//*[@id='agent_pin']/div";
    private By getStartedWindow = By.className("modal-header");
    @FindBy(xpath = "//*[@class='btn btn-secondary block-center']")
    private WebElement getStartedButton;
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
    @FindBy(xpath = "(//div[@class='agent-list-card-img'])[2]/img")
    private WebElement secondRealtor;
    @FindBy(id = "map_view_link")
    private WebElement activityMapButton;
    @FindBy(xpath = "(//*[@id='agent_map_card'])[1]")
    private WebElement firstRealtorCard;
    @FindBy(xpath = "//div[@id='agent_search_detail_more_properties_container']/div")
    private List<WebElement> homeCards;
    @FindBy(id = "btn_show_more_property")
    private WebElement seeAgentsNearbyPropertiesButton;
    @FindBy(xpath = "//div[contains(@class,'agent-recommendation')]//strong")
    private WebElement recommendationsCount;


    /**
     * get recommendations count
     *
     * @return recommendations count
     */
    public WebElement getRecommendations() {
        return recommendationsCount;
    }

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
     *
     * @return nextButton
     */
    public List<WebElement> getNextPageButton() {
        return nextPageButton;
    }

    /**
     * @return list of realtor cards
     */
    public WebElement getFirstRealtorCard() {
        waitForJQueryIsLoad();
        return firstRealtorCard;
    }

    /**
     * @return list of home cards
     */
    public List<WebElement> getHomeCards() {
        waitForJQueryIsLoad();
        return homeCards;
    }

    /**
     * @return list of icons on the map
     */
    public List<WebElement> getIconsFromMap() {
        waitForJQueryIsLoad();
        return driver.findElements(By.xpath(ICONS_ON_MAP_LOCATOR));
    }

    /**
     * find icon on map by index and return it
     *
     * @param index by which the icon will be searched
     * @return icon web element
     */
    public WebElement getIconByIndex(int index) {
        By currentElement = By.xpath("(" + ICONS_ON_MAP_LOCATOR + ")[" + index + "]");
        WebElement icon = driver.findElement(currentElement);
        return icon;
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

    /**
     * click activity map button
     *
     * @return this page
     */
    public RealtorSearchResultPage clickActivityMapButton() {
        waitUntilElementIsClickable(activityMapButton);
        activityMapButton.click();
        return this;
    }

    /**
     * click get started button
     *
     * @return this page
     */
    public RealtorSearchResultPage clickGetStartedButton() {
        waitUntilElementIsVisible(getStartedButton);
        BasePage.clickByJEx(getStartedButton, driver);
        waitInvisibilityOfElementLocated(getStartedWindow);
        return this;
    }

    /**
     * click see agent's nearby properties button, if it presents on the page
     *
     * @return this page
     */
    public RealtorSearchResultPage clickSeeAgentsNearbyProperties() {
        if (seeAgentsNearbyPropertiesButton.isDisplayed()) {
            seeAgentsNearbyPropertiesButton.click();
        }
        return this;
    }

}
