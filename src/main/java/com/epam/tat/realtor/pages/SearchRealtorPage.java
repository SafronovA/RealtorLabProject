package com.epam.tat.realtor.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchRealtorPage extends BasePage {
    public SearchRealtorPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "srchHomeAgent")
    private WebElement searchInput;
    @FindBy(id = "far_search_button")
    private WebElement searchButton;

    /**
     * enter realtor name in the search input
     *
     * @param realtorName realtor name as search criteria
     * @return this page
     */
    public SearchRealtorPage enterRealtorName(String realtorName) {
        searchInput.click();
        searchInput.sendKeys(realtorName);
        return this;
    }

    /**
     * click search button
     *
     * @return new FindRealtorPage
     */
    public FindRealtorPage clickSearchButton() {
        waitUntilElementIsClickable(searchButton);
        searchButton.click();
        return new FindRealtorPage(driver);
    }
}
