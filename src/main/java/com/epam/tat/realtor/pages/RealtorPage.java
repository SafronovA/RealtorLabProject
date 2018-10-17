package com.epam.tat.realtor.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class RealtorPage extends BasePage {
    public RealtorPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    private By soldHouses = By.xpath("//div[@class='leaflet-marker-pane']/div");
    @FindBy(xpath = "//ul[@class='nav nav-tabs nav-pills']//a[contains(text(),'Recently Sold')]")
    private WebElement soldHousesSection;
    @FindBy(xpath = "//div[@class='leaflet-marker-pane']/div")
    private List<WebElement> soldHousesMapMarkList;
    @FindBy(xpath = "//div[@class='leaflet-popup-content']//strong")
    private WebElement saleHouseStatus;
    @FindBy(xpath = "//a[@class='leaflet-control-zoom-out']")
    private WebElement zoomOutButton;
    @FindBy(xpath = "//p/a[@id='inquiry_cta']")
    private WebElement askQuestionButton;
    @FindBy(xpath = "//a[contains(@class,'btn btn-plain load-more-button load-more-review-button')]")
    private WebElement loadMoreReviewsButton;
    @FindBy(xpath = "//*[@id='footer-links-secondary']")
    private WebElement bottomElement;
    @FindBy(xpath = "//ul[@id='agent-review-list']/li[not(@style='display: none;')]")
    private List<WebElement> realtorReviews;
    @FindBy(xpath = "//button[contains(text(),'re Re')]")
    private WebElement loadMoreRecommendationsButton;
    @FindBy(xpath = "//div[@class='recommendation-card']")
    private List<WebElement> realtorRecommendations;

    /**
     * get realtor reviews list
     *
     * @return realtor reviews
     */
    public List<WebElement> getRealtorReviews() {
        return realtorReviews;
    }

    /**
     * get sold houses map marks
     *
     * @return list of sold houses map marks
     */
    public List<WebElement> getSoldHousesMapMarkList() {
        waitForPresenceOfAllElementsLocatedBy(soldHouses);
        return soldHousesMapMarkList;
    }

    /**
     * get status of the house on the map mark
     *
     * @return sold status of the house on the map mark
     */
    public String getSaleHouseStatus() {
        waitUntilElementIsVisible(saleHouseStatus);
        return saleHouseStatus.getText();
    }

    /**
     * get realtor recommendations list
     *
     * @return realtor recommendations
     */
    public List<WebElement> getRealtorRecommendations() {
        return realtorRecommendations;
    }


    /**
     * click "Recently Sold" section above iframe map
     *
     * @return this page
     */
    public RealtorPage clickSoldHousesSection() {
        waitUntilElementIsClickable(soldHousesSection);
        soldHousesSection.click();
        return this;
    }

    /**
     * scroll to iframe map
     *
     * @return this page
     */
    public RealtorPage scrollToIFrame() {
        waitForPresenceOfAllElementsLocatedBy(soldHouses);
        BasePage.scrollToElement(askQuestionButton, driver);
        return this;
    }

    /**
     * double click on zoom out button
     *
     * @return this page
     */
    public RealtorPage doubleZoomOut() {
        waitUntilElementIsVisible(zoomOutButton);
        zoomOutButton.click();
        zoomOutButton.click();
        return this;
    }

    /**
     * click Load More Reviews button
     *
     * @return this page
     */
    public RealtorPage clickLoadMoreReviewsButton() {
        waitUntilElementIsClickable(loadMoreReviewsButton);
        loadMoreReviewsButton.click();
        return this;
    }

    /**
     * check if LoadMoreReviews button is displayed
     *
     * @return if LoadMoreReviews button is displayed
     */
    public boolean isLoadMoreReviewsButtonDisplayed() {
        return loadMoreReviewsButton.isDisplayed();
    }

    /**
     * scroll down the page
     */
    public void scrollDown() {
        scrollToElement(bottomElement, driver);
    }

    /**
     * check if LoadMoreRecommendations button is displayed
     *
     * @return if LoadMoreRecommendations button is displayed
     */
    public boolean isLoadMoreRecommendationsButtonDisplayed() {
        return loadMoreRecommendationsButton.isDisplayed();
    }

    /**
     * click Load More Recommendations button
     *
     * @return this page
     */
    public RealtorPage clickLoadMoreRecommendationsButton() {
        scrollToElement(loadMoreRecommendationsButton, driver);
        waitForJQueryIsLoad();
        loadMoreRecommendationsButton.click();
        return this;
    }


}
