package com.epam.tat.realtor.pages;

import com.epam.tat.realtor.util.RealtorUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SearchPage extends BasePage {

    public SearchPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy (id = "desktop-price-div")
    WebElement priceButton;
    @FindBy (id = "price-input-1-desktop")
    WebElement minPriceInput;
    @FindBy (id = "price-input-2-desktop")
    WebElement maxPriceInput;
    @FindBy (xpath = "(//*[@id='price-input-1-list'])[1]/li")
    List<WebElement> minPriceRange;
    @FindBy (xpath = "(//*[@id='price-input-2-list'])[1]/li")
    List<WebElement> maxPriceRange;
    @FindBy (id = "desktop-bedroom-div")
    WebElement bedButton;
    @FindBy (xpath = "//*[@id='filter-section-bedroom-desktop']//label")
    List<WebElement> bedQuantityList;
    @FindBy (id = "desktop-bathroom-div")
    WebElement bathButton;
    @FindBy (xpath = "//*[@id='filter-section-bathroom-desktop']//label")
    List<WebElement> bathQuantityList;
    @FindBy (xpath = "//span[contains(text(),'Filters')]")
    WebElement moreFiltersButton;
    @FindBy (xpath = "//div[@class='filter-section filter-section-home-size']/a")
    WebElement homeSizeButton;
    @FindBy (id="home-size-input-1")
    WebElement minHomeSizeDropdownButton;
    @FindBy(xpath = "//*[@id='home-size-input-1']/option")
    List<WebElement> minHomeSizeList;
    @FindBy (id="home-size-input-2")
    WebElement maxHomeSizeDropdownButton;
    @FindBy(xpath = "//*[@id='home-size-input-2']/option")
    List<WebElement> maxHomeSizeList;
    @FindBy(xpath = "//button[@class='btn-filter-submit btn btn-primary btn-block']")
    WebElement viewListinsButton;
    @FindBy(xpath = "//span[@class='data-price']")
    List<WebElement> searchedHousePricesList;
    @FindBy(xpath = "//span[@class='data-value meta-beds']")
    List<WebElement> searchedHouseBedList;
    @FindBy(xpath = "//li[@data-label='property-meta-baths']/span")
    List<WebElement> searchedHouseBathList;
    @FindBy(xpath = "//li[@data-label='property-meta-sqft']/span")
    List<WebElement> searchedHouseSqftList;



    public SearchPage clickPriceButton() {
        priceButton.click();
        return this;
    }

    public SearchPage clickMinPriceInput() {
        minPriceInput.click();
        return this;
    }
    public SearchPage clickMaxPriceInput() {
        maxPriceInput.click();
        return this;
    }
    public List<WebElement> getMinPriceRange() {
        RealtorUtil.sleep(1000);
        return minPriceRange;
    }
    public List<WebElement> getMaxPriceRange() {
        waitJSExecuteScriptDocumentReady();
        return maxPriceRange;
    }

    public SearchPage clickBedButton() {
        bedButton.click();
        return this;
    }
    public SearchPage clickBathButton() {
        bathButton.click();
        return this;
    }

    public List<WebElement> getBedQuantityList() {
        return bedQuantityList;
    }

    public List<WebElement> getBathQuantity() {
        return bathQuantityList;
    }

    public SearchPage clickMoreFiltersButton() {
        moreFiltersButton.click();
        return this;
    }

    public SearchPage clickHomeSizeButton() {
        homeSizeButton.click();
        return this;
    }

    public SearchPage clickMinDropdownMenu() {
        minHomeSizeDropdownButton.click();
        return this;
    }
    public SearchPage clickMaxDropdownMenu() {
        maxHomeSizeDropdownButton.click();
        return this;
    }
    public List<WebElement> getMinHomeSizeList(){
        return minHomeSizeList;
    }
    public List<WebElement> getMaxHomeSizeList(){
        return maxHomeSizeList;
    }

    public SearchPage clickViewListingsButton() {
        viewListinsButton.click();
        RealtorUtil.sleep(3000);
        return this;
    }
    public List<WebElement> getSearchedHousePricesList(){
        waitJSExecuteScriptDocumentReady();
        return searchedHousePricesList;
    }
    public List<WebElement> getSearchedHouseBedList(){
        return searchedHouseBedList;
    }
    public List<WebElement> getSearchedHouseBathList(){
        return searchedHouseBathList;
    }
    public List<WebElement> getSearchedHouseSqftList(){
        return searchedHouseSqftList;
    }

}
