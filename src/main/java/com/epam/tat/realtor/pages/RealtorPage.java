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

    By soldHouses = By.xpath("//div[@class='leaflet-marker-pane']/div");
    @FindBy(xpath = "//ul[@class='nav nav-tabs nav-pills']//a[contains(text(),'Recently Sold')]")
    private WebElement soldHousesSection;
    @FindBy(xpath = "//div[@class='leaflet-marker-pane']/div")
    private List<WebElement> soldHousesMapMarkList;
    @FindBy(xpath = "//div[@class='leaflet-popup-content']//strong")
    private WebElement soldHouseStatus;
    @FindBy(xpath = "//a[@class='leaflet-control-zoom-out']")
    private WebElement zoomOutButton;
    @FindBy(xpath = "//p/a[@id='inquiry_cta']")
    private WebElement askQuestionButton;
    @FindBy(xpath = "//a[@class='btn btn-plain load-more-button load-more-review-button']")
    private WebElement loadMoreReviewsButton;
    @FindBy(xpath = "//ul[@id='agent-review-list']/li[not(@style='display: none;')]")
    private List<WebElement> realtorReviews;
    @FindBy(xpath = "//div[contains(@class,'price leaflet-marker-icon-for-sale')]")
    private List<WebElement> forSaleHouses;
    @FindBy(xpath = "//div[@class='leaflet-popup-content']/a/p/strong")
    private WebElement houseStatusDescription;
    @FindBy(xpath = "//*[@id='team_nav_holder']/h2")
    private WebElement listingActivity;

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
    public String getSoldHouseStatus() {
        waitUntilElementIsVisible(soldHouseStatus);
        return soldHouseStatus.getText();
    }

    /**
     * get list of for sale houses
     *
     * @return list of for sale houses
     */
    public List<WebElement> getForSaleHouses(){
        return forSaleHouses;
    }

    /**
     * get status of the house on the map mark
     *
     * @return for sale status of the house on the map mark
     */
    public String getForSaleHouseStatus() {
        waitUntilElementIsVisible(houseStatusDescription);
        return houseStatusDescription.getText();
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
     * scroll to map
     *
     * @return this page
     */
    public RealtorPage scrollToMap() {
        waitForJQueryIsLoad();
        BasePage.scrollToElement(listingActivity, driver);
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
}
