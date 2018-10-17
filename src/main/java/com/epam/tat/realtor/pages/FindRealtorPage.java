package com.epam.tat.realtor.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FindRealtorPage extends BasePage {
    public FindRealtorPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "srchHomeAgent")
    private WebElement searchInput;
    @FindBy(id = "srchHomeLocation")
    private WebElement locationInput;

    /**
     * enter realtor name in the search input
     *
     * @param realtorName realtor name as search criteria
     * @return this page
     */
    public FindRealtorPage enterRealtorName(String realtorName) {
        searchInput.clear();
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
     * perform submit operation
     *
     * @return new RealtorSearchResultPage
     */
    public RealtorSearchResultPage clickSearchButton() {
        new Actions(driver).sendKeys(Keys.ENTER).perform();
        return new RealtorSearchResultPage(driver);
    }
}
