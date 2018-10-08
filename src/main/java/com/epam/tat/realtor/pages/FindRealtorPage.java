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

    @FindBy(xpath = "(//div[@class='agent-detail-item ellipsis']/a/strong)[2]")
    private WebElement realtorSoldHouses;
    @FindBy(xpath = "//div[@class='agent-list-card-img']/img")
    private WebElement userIcon;
    @FindBy(xpath = "//div[@class='rating-count']")
    private WebElement ratingCount;
    @FindBy(xpath = "//div[contains(@class,'agent-recommendation')]//strong")
    private WebElement recommendationsCount;

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
     * get recommendations count
     *
     * @return recommendations count
     */
    public WebElement getRecommendations() {
        return recommendationsCount;
    }
}
