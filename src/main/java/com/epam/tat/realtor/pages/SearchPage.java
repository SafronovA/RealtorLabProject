package com.epam.tat.realtor.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchPage extends BasePage {

    public SearchPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy (id = "desktop-price-div")
    private WebElement priceButton;
    @FindBy (id = "price-input-1-desktop")
    private WebElement minPriceInput;
    @FindBy (id = "price-input-2-desktop")
    private WebElement maxPriceInput;
    @FindBy (xpath = "(//*[@id='price-input-1-list'])[1]/li")
    private List<WebElement> minPriceRange;
    @FindBy (xpath = "(//*[@id='price-input-2-list'])[1]/li")
    private List<WebElement> maxPriceRange;
    @FindBy (id = "desktop-bedroom-div")
    private WebElement bedButton;
    @FindBy (xpath = "//*[@id='filter-section-bedroom-desktop']//label")
    private List<WebElement> bedQuantityList;
    @FindBy (id = "desktop-bathroom-div")
    private WebElement bathButton;
    @FindBy (xpath = "//*[@id='filter-section-bathroom-desktop']//label")
    private List<WebElement> bathQuantityList;
    @FindBy (xpath = "//span[contains(text(),'Filters')]")
    private WebElement moreFiltersButton;
    @FindBy (xpath = "//div[contains(@class,'filter-section filter-section-home-size')]/a")
    private WebElement homeSizeButton;
    @FindBy (id="home-size-input-1")
    private WebElement minHomeSizeDropdownButton;
    @FindBy(xpath = "//*[@id='home-size-input-1']/option")
    private List<WebElement> minHomeSizeList;
    @FindBy (id="home-size-input-2")
    private WebElement maxHomeSizeDropdownButton;
    @FindBy(xpath = "//*[@id='home-size-input-2']/option")
    private List<WebElement> maxHomeSizeList;
    @FindBy(xpath = "//button[@class='btn-filter-submit btn btn-primary btn-block']")
    private WebElement viewListinsButton;
    @FindBy(xpath = "//span[@class='data-price']")
    private List<WebElement> searchedHousePricesList;
    @FindBy(xpath = "//span[@class='data-value meta-beds']")
    private List<WebElement> searchedHouseBedList;
    @FindBy(xpath = "//li[@data-label='property-meta-baths']/span")
    private List<WebElement> searchedHouseBathList;
    @FindBy(xpath = "//li[@data-label='property-meta-sqft']/span")
    private List<WebElement> searchedHouseSqftList;
    @FindBy(xpath = "//div[@class='srp-view-toggle btn-group']/a[@class='btn btn-default srp-view-map-toggle ']")
    private WebElement viewMapButton;
    //@FindBy(xpath = "//span[@class='pinIcon pin-dot']")
    @FindBy(xpath = "//div[contains(@class,'map-property-pin for_sale')]")
    private List<WebElement> mapMarksList;
    @FindBy (xpath = "//div[@class='minicard-price']/span")
    private WebElement mapMarkPrice;
    @FindBy (xpath = "//ul[@class='minicard-meta ellipsis']/li[@data-label='property-meta-beds']/span")
    private WebElement mapMarkBed;
    @FindBy (xpath = "//ul[@class='minicard-meta ellipsis']/li[@data-label='property-meta-baths']/span")
    private WebElement mapMarkBath;
    @FindBy (xpath = "//ul[@class='minicard-meta ellipsis']/li[@data-label='property-meta-sqft']")
    private WebElement mapMarkSqft;
    @FindBy (xpath = "//li[@id='js-home-size-filter-pill-xx']/label[contains(text(),'2,000')]")
    private WebElement homeSizeFilterIcon;

    /**
     * click Price button
     * @return this page
     */
    public SearchPage clickPriceButton() {
        waitUntilElementIsClickable(priceButton);
        priceButton.click();
        return this;
    }

    /**
     * click No Min input in the Price section
     * @return this page
     */
    public SearchPage clickMinPriceInput() {
        waitUntilElementIsClickable(minPriceInput);
        minPriceInput.click();
        return this;
    }
    /**
     * click No Max input in the Price section
     * @return this page
     */
    public SearchPage clickMaxPriceInput() {
        waitUntilElementIsClickable(maxPriceInput);
        maxPriceInput.click();
        return this;
    }

    /**
     * get list of available min prices in the dropdown menu
     * @return list of the min price constants
     */
    public List<WebElement> getMinPriceRange() {
        return minPriceRange;
    }
    /**
     * get list of available min prices in the dropdown menu
     * @return list of the max price constants
     */
    public List<WebElement> getMaxPriceRange() {
        return maxPriceRange;
    }

    /**
     * click Bed button
     * @return this page
     */
    public SearchPage clickBedButton() {
        bedButton.click();
        return this;
    }
    /**
     * click Bath button
     * @return this page
     */
    public SearchPage clickBathButton() {
        bathButton.click();
        return this;
    }
    /**
     * get list of available bed number constants
     * @return list of the bed number constants
     */
    public List<WebElement> getBedQuantityList() {
        return bedQuantityList;
    }
    /**
     * get list of available bath number constants
     * @return list of the bath number constants
     */
    public List<WebElement> getBathQuantity() {
        return bathQuantityList;
    }

    /**
     * click More Filters button
     * @return this page
     */
    public SearchPage clickMoreFiltersButton() {
        moreFiltersButton.click();
        return this;
    }

    /**
     * click Home Size button in the MoreFilters section
     * @return
     */
    public SearchPage clickHomeSizeButton() {
        homeSizeButton.click();
        return this;
    }

    /**
     * click MinSquare dropdown menu in the Home Size section
     * @return
     */
    public SearchPage clickMinDropdownMenu() {
        minHomeSizeDropdownButton.click();
        return this;
    }
    /**
     * click MaxSquare dropdown menu in the Home Size section
     * @return
     */
    public SearchPage clickMaxDropdownMenu() {
        maxHomeSizeDropdownButton.click();
        return this;
    }

    /**
     * get list of available min square constants in the Home Size section
     * @return list of min square constants
     */
    public List<WebElement> getMinHomeSizeList(){
        return minHomeSizeList;
    }
    /**
     * get list of available max square constants in the Home Size section
     * @return list of max square constants
     */
    public List<WebElement> getMaxHomeSizeList(){
        return maxHomeSizeList;
    }

    /**
     * click View()Listings button(submit search request)
     * wait for result download
     * @return this page
     */
    public SearchPage clickViewListingsButton() {
        viewListinsButton.click();
        return this;
    }

    /**
     * get price list of the searched houses
     * @return list of prices according search result
     */
    public List<WebElement> getSearchedHousePricesList(){
        return searchedHousePricesList;
    }
    /**
     * get bed list of the searched houses
     * @return list of beds according search result
     */
    public List<WebElement> getSearchedHouseBedList(){
        return searchedHouseBedList;
    }
    /**
     * get bath list of the searched houses
     * @return list of bathes according search result
     */
    public List<WebElement> getSearchedHouseBathList(){
        return searchedHouseBathList;
    }
    /**
     * get house square feet size list of the searched houses
     * @return list of house square feet size according search result
     */
    public List<WebElement> getSearchedHouseSqftList(){
        return searchedHouseSqftList;
    }

    /**
     * click View Map button
     * @return this page
     */
    public SearchPage clickViewMapButton(){
        viewMapButton.click();
        return this;
    }

    /**
     * get map marks of houses according search result on the iframe map
     * @return list of map marks
     */
    public List<WebElement> getMapMarks(){
        return mapMarksList;
    }

    /**
     * get price from map mark photo
     * @return map mark price
     */
    public String getMapMarkPrice(){
        return mapMarkPrice.getText();
    }
    /**
     * get beds number  from map mark photo
     * @return map mark beds number
     */
    public String getMapMarkBed(){
        return mapMarkBed.getText();
    }
    /**
     * get baths number  from map mark photo
     * @return map mark baths number
     */
    public String getMapMarkBath(){
        return mapMarkBath.getText();
    }
    /**
     * get square feet house size from map mark photo
     * @return map mark square feet size
     */
    public String getMapMarkSqft(){
        return mapMarkSqft.getText();
    }

    /**
     * wait for home size filter to appear in order to download search results
     * @return this page
     */
    public SearchPage waitForHomeSizeFilter(){
        waitUntilElementIsVisible(homeSizeFilterIcon);
        return this;
    }

}


