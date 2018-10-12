package com.epam.tat.realtor.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FindRealtorPage extends BasePage {
    public FindRealtorPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }


    @FindBy(id = "srchHomeAgent")
    private WebElement searchInput;
    @FindBy(id = "far_search_button")
    private WebElement searchButton;
    @FindBy(id = "srchHomeLocation")
    private WebElement locationInput;
    @FindBy(xpath = "(//div[@class='agent-detail-item ellipsis']/a/strong)[2]")
    private WebElement realtorSoldHouses;
    @FindBy(xpath = "//div[@class='agent-list-card-img']/img")
    private WebElement userIcon;
    @FindBy(xpath = "//div[@class='rating-count']")
    private WebElement ratingCount;
    @FindBy(xpath = "//div[contains(@class,'agent-recommendation')]//strong")
    private WebElement recommendationsCount;


    /**
     * enter realtor name in the search input
     *
     * @param realtorName realtor name as search criteria
     * @return this page
     */
    public FindRealtorPage enterRealtorName(String realtorName) {
        searchInput.click();
        searchInput.sendKeys(realtorName);
        return this;
    }

    /**
     * enter realtor location in the location input
     *
     * @param realtorLocation realtor name as search criteria
     * @return this page
     */
    public FindRealtorPage enterLocation(String realtorLocation) {
        locationInput.clear();
        locationInput.sendKeys(realtorLocation);
        return this;
    }

    /**
     * click search button
     *
     * @return new RealtorSearchResultPage
     */
    public RealtorSearchResultPage clickSearchButton() {
        waitUntilElementIsClickable(searchButton);
        searchButton.click();
        return new RealtorSearchResultPage(driver);
    }


    /**
     * get recommendations count
     *
     * @return recommendations count
     */
    public WebElement getRecommendations() {
        return recommendationsCount;
    }

}
