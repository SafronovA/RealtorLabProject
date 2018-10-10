package com.epam.tat.realtor.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchPage extends BasePage {

    public SearchPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    private final String XPATH_FOR_RESTAURANT = "//div[contains(@class,'pin-restaurants')]";
    private final String XPATH_FOR_SCHOOL = "//div[contains(@class,'pin-school')]";
    By priceList = By.xpath("//span[@class='data-price']");
    @FindBy(id = "desktop-price-div")
    private WebElement priceButton;
    @FindBy(xpath = "(//*[@id='price-input-1-list'])[1]/li")
    private List<WebElement> minPriceRange;
    @FindBy(xpath = "(//*[@id='price-input-2-list'])[1]/li")
    private List<WebElement> maxPriceRange;
    @FindBy(id = "price-input-1-desktop")
    private WebElement minPriceInput;
    @FindBy(id = "price-input-2-desktop")
    private WebElement maxPriceInput;
    @FindBy(id = "desktop-bedroom-div")
    private WebElement bedButton;
    @FindBy(xpath = "//*[@id='filter-section-bedroom-desktop']//label")
    private List<WebElement> bedQuantityList;
    @FindBy(id = "desktop-bathroom-div")
    private WebElement bathButton;
    @FindBy(xpath = "//*[@id='filter-section-bathroom-desktop']//label")
    private List<WebElement> bathQuantityList;
    @FindBy(xpath = "//span[contains(text(),'Filters')]")
    private WebElement moreFiltersButton;
    @FindBy(xpath = "//div[contains(@class,'filter-section filter-section-home-size')]/a")
    private WebElement homeSizeButton;
    @FindBy(id = "home-size-input-1")
    private WebElement minHomeSizeDropdownButton;
    @FindBy(xpath = "//*[@id='home-size-input-1']/option")
    private List<WebElement> minHomeSizeList;
    @FindBy(id = "home-size-input-2")
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
    @FindBy(xpath = "//a[contains(@class,'view-map')]")
    private WebElement viewMapButton;
    @FindBy(xpath = "//div[contains(@class,'map-property-pin for_sale')]")
    private List<WebElement> mapMarksList;
    @FindBy(xpath = "//div[@class='minicard-price']/span")
    private WebElement mapMarkPrice;
    @FindBy(xpath = "//ul[@class='minicard-meta ellipsis']/li[@data-label='property-meta-beds']/span")
    private WebElement mapMarkBed;
    @FindBy(xpath = "//ul[@class='minicard-meta ellipsis']/li[@data-label='property-meta-baths']/span")
    private WebElement mapMarkBath;
    @FindBy(xpath = "//ul[@class='minicard-meta ellipsis']/li[@data-label='property-meta-sqft']")
    private WebElement mapMarkSqft;
    @FindBy(xpath = "//li[@id='js-home-size-filter-pill-xx']/label[contains(text(),'2,000')]")
    private WebElement homeSizeFilterIcon;
    @FindBy(id = "facet-followbtn")
    private WebElement saveSearchButton;
    @FindBy(xpath = "//*[@id='my-account-url']/following-sibling::span[1]")
    private WebElement userIcon;
    @FindBy(xpath = "//*[@id='js-price-filter-pill-xx']")
    private WebElement chosenCriteria;
    @FindBy(xpath = "(//*[@id='facet-followbtn'])[2]/span")
    private WebElement saveButtonText;
    @FindBy(xpath = "//select[@id='srp-sortby']")
    private WebElement sortOptionsDropDown;
    @FindBy(xpath = "//*[@id='srp-sortby']/option")
    private List<WebElement> sortOptionsList;
    @FindBy(xpath = "//*[contains(@class,'data-price')]")
    private List<WebElement> homePricesList;
    @FindBy(xpath = "//*[@class='next ']")
    private List<WebElement> nextPageLink;
    @FindBy(xpath = "//a[contains(@data-omtag,'amenities')]")
    private WebElement lifestyleButton;
    @FindBy(xpath = "//input[contains(@data-omtag,'restaurants')]")
    private WebElement restaurantsRadioButton;
    @FindBy(xpath = "//div[contains(@class,'restaurants')]")
    private List<WebElement> allFoundRestaurantsList;
    @FindBy(xpath = "//div[@class='amenity-card-label']")
    private WebElement lifestyleType;
    @FindBy(id = "search-result-count")
    private WebElement searchResultCount;
    @FindBy(xpath = "//i[contains(@class,\"ra-ml-cap ra\")]")
    private WebElement schoolsButton;
    @FindBy(xpath = "//input[contains(@data-omtag,'elementary')]")
    private WebElement elementarySchool;
    @FindBy(xpath = "//input[contains(@data-omtag,'secondary')]")
    private WebElement middleSchool;
    @FindBy(xpath = "//input[contains(@data-omtag,'private')]")
    private WebElement privateSchool;
    @FindBy(xpath = "//div[contains(@class,'min-slider-handle')]")
    private WebElement schoolRatingSlider;
    @FindBy(xpath = "//div[contains(@class,'slider-tick-label')][8]")
    private WebElement eightRating;
    @FindBy(xpath = "//div[contains(@class,'pin-school')]")
    private List<WebElement> schoolOnMapList;
    @FindBy(xpath = "//div[@class='rating']")
    private WebElement schoolRating;
    @FindBy(xpath = "//a[@class='card-title']")
    private WebElement schoolName;

    /**
     * get list of available min prices in the dropdown menu
     *
     * @return list of the min price constants
     */
    public List<WebElement> getMinPriceRange() {
        waitUntilElementIsVisible(minPriceRange.get(0));
        return minPriceRange;
    }

    /**
     * get list of available min prices in the dropdown menu
     *
     * @return list of the max price constants
     */
    public List<WebElement> getMaxPriceRange() {
        waitUntilElementIsVisible(maxPriceRange.get(0));
        return maxPriceRange;
    }

    /**
     * get list of sort option
     *
     * @return list of sort options
     */
    public List<WebElement> getSortOptionsList() {
        return sortOptionsList;
    }

    /**
     * get list of homes satisfying the search criteria
     *
     * @return list of homes
     */
    public List<WebElement> getHomePricesList() {
        waitForJQueryIsLoad();
        return homePricesList;
    }

    /**
     * get list with one element (link on next page). Created list to avoid NullPointerException, because on the last
     * page there are no link on the next page. In this case will be empty list, and not will be null element.
     *
     * @return list of next pages
     */
    public List<WebElement> getNextPageLink() {
        return nextPageLink;
    }

    /**
     * get list of available bed number constants
     *
     * @return list of the bed number constants
     */
    public List<WebElement> getBedQuantityList() {
        return bedQuantityList;
    }

    /**
     * get list of available bath number constants
     *
     * @return list of the bath number constants
     */
    public List<WebElement> getBathQuantity() {
        return bathQuantityList;
    }

    /**
     * get list of all found restaurants
     *
     * @return list of all found restaurants
     */
    public int getRestaurantsCount() {
        return allFoundRestaurantsList.size();
    }

    /**
     * get school name
     *
     * @return school name
     */
    public String getSchoolName(){
        return schoolName.getText();
    }

    /**
     * get restaurants in turn
     *
     * @param number restaurant in turn
     * @return get restaurants in turn
     */
    public WebElement getRestaurant(int number){
        return driver.findElement(By.xpath(XPATH_FOR_RESTAURANT+"["+number+"]"));
    }

    /**
     * get search result count of find houses from title
     *
     * @return search result count element
     */
    public WebElement getSearchResultCountElement() {
        return searchResultCount;
    }

    /**
     * get lifestyle type
     *
     * @return lifestyle type
     */
    public String getLifestyleType() {
        waitUntilElementIsVisible(lifestyleType);
        return lifestyleType.getText();
    }

    /**
     * get price from map mark photo
     *
     * @return map mark price
     */
    public String getMapMarkPrice() {
        return mapMarkPrice.getText();
    }

    /**
     * get beds number  from map mark photo
     *
     * @return map mark beds number
     */
    public String getMapMarkBed() {
        return mapMarkBed.getText();
    }

    /**
     * get baths number  from map mark photo
     *
     * @return map mark baths number
     */
    public String getMapMarkBath() {
        return mapMarkBath.getText();
    }

    /**
     * get square feet house size from map mark photo
     *
     * @return map mark square feet size
     */
    public String getMapMarkSqft() {
        return mapMarkSqft.getText();
    }

    /**
     * get school rating
     *
     * @return school rating
     */
    public String getSchoolRating(){
        return schoolRating.getText();
    }

    /**
     * get map marks of houses according search result on the iframe map
     *
     * @return list of map marks
     */
    public List<WebElement> getMapMarks() {
        return mapMarksList;
    }

    /**
     * get price list of the searched houses
     *
     * @return list of prices according search result
     */
    public List<WebElement> getSearchedHousePricesList() {
        return searchedHousePricesList;
    }

    /**
     * get bed list of the searched houses
     *
     * @return list of beds according search result
     */
    public List<WebElement> getSearchedHouseBedList() {
        return searchedHouseBedList;
    }

    /**
     * get bath list of the searched houses
     *
     * @return list of bathes according search result
     */
    public List<WebElement> getSearchedHouseBathList() {
        return searchedHouseBathList;
    }

    /**
     * get house square feet size list of the searched houses
     *
     * @return list of house square feet size according search result
     */
    public List<WebElement> getSearchedHouseSqftList() {
        return searchedHouseSqftList;
    }

    /**
     * get list of available min square constants in the Home Size section
     *
     * @return list of min square constants
     */
    public List<WebElement> getMinHomeSizeList() {
        return minHomeSizeList;
    }

    /**
     * get list of available max square constants in the Home Size section
     *
     * @return list of max square constants
     */
    public List<WebElement> getMaxHomeSizeList() {
        return maxHomeSizeList;
    }

    /**
     * get count of schools on map
     *
     * @return count schools are displayed on map
     */
    public int getSchoolOnMapListCount() {
        return schoolOnMapList.size();
    }

    /**
     * get schools in turn
     *
     * @param number school in turn
     * @return get school in turn
     */
    public WebElement getSchool(int number){
        return driver.findElement(By.xpath(XPATH_FOR_SCHOOL+"["+number+"]"));
    }

    /**
     * click Price button
     *
     * @return this page
     */
    public SearchPage clickPriceButton() {
        waitUntilElementIsClickable(priceButton);
        priceButton.click();
        return this;
    }

    /**
     * click No Min input in the Price section
     *
     * @return this page
     */
    public SearchPage clickMinPriceInput() {
        waitUntilElementIsClickable(minPriceInput);
        minPriceInput.click();
        return this;
    }

    /**
     * click No Max input in the Price section
     *
     * @return this page
     */
    public SearchPage clickMaxPriceInput() {
        waitUntilElementIsClickable(maxPriceInput);
        maxPriceInput.click();
        return this;
    }

    /**
     * click More Filters button
     *
     * @return this page
     */
    public SearchPage clickMoreFiltersButton() {
        moreFiltersButton.click();
        return this;
    }

    /**
     * click Home Size button in the MoreFilters section
     *
     * @return
     */
    public SearchPage clickHomeSizeButton() {
        homeSizeButton.click();
        return this;
    }

    /**
     * click Bed button
     *
     * @return this page
     */
    public SearchPage clickBedButton() {
        bedButton.click();
        return this;
    }

    /**
     * click Bath button
     *
     * @return this page
     */
    public SearchPage clickBathButton() {
        bathButton.click();
        return this;
    }

    /**
     * click save search button
     *
     * @return this page
     */
    public SearchPage clickSaveSearchButton() {
        waitUntilElementIsVisible(chosenCriteria);
        saveSearchButton.click();
        return this;
    }

    /**
     * click on user icon
     *
     * @return new SavedHomesPage
     */
    public SavedHomesPage clickUserIcon() {
        waitUntilElementIsClickable(userIcon);
        userIcon.click();
        return new SavedHomesPage(driver);
    }

    /**
     * click MinSquare dropdown menu in the Home Size section
     *
     * @return
     */
    public SearchPage clickMinDropdownMenu() {
        minHomeSizeDropdownButton.click();
        return this;
    }

    /**
     * click MaxSquare dropdown menu in the Home Size section
     *
     * @return
     */
    public SearchPage clickMaxDropdownMenu() {
        maxHomeSizeDropdownButton.click();
        return this;
    }

    /**
     * click on sort by drop-down
     *
     * @return
     */
    public SearchPage clickSortOptionsDropDown() {
        waitUntilElementIsVisible(chosenCriteria);
        sortOptionsDropDown.click();
        return this;
    }

    /**
     * get first(and single) element from nextPageLink list, and click on link to go on next page with homes
     *
     * @return new SearchPage to load new houses
     */
    public SearchPage clickNextLink() {
        nextPageLink.get(0).click();
        return new SearchPage(driver);
    }

    /**
     * click View()Listings button(submit search request)
     * wait for result download
     *
     * @return this page
     */
    public SearchPage clickViewListingsButton() {
        viewListinsButton.click();
        waitUntilElementIsVisible(homeSizeFilterIcon);
        waitForElements(priceList);
        return this;
    }

    /**
     * click View Map button
     *
     * @return this page
     */
    public SearchPage clickViewMapButton() {
        waitUntilElementIsClickable(viewMapButton);
        viewMapButton.click();
        return this;
    }

    /**
     * click in lifestyle button
     *
     * @return this page
     */
    public SearchPage clickLifestyleButton() {
        waitUntilElementIsVisible(lifestyleButton);
        lifestyleButton.click();
        return this;
    }

    /**
     * click on restaurants radio button
     *
     * @return this page
     */
    public SearchPage selectRestaurants() {
        waitUntilElementIsVisible(restaurantsRadioButton);
        restaurantsRadioButton.click();
        return this;
    }

    /**
     * click school button
     *
     * @return this page
     */
    public SearchPage clickSchoolButton() {
        waitUntilElementIsVisible(schoolsButton);
        schoolsButton.click();
        return this;
    }

    /**
     * click elementary school checkbox
     *
     * @return this page
     */
    public SearchPage clickElementarySchool() {
        waitUntilElementIsClickable(elementarySchool);
        elementarySchool.click();
        return this;
    }

    /**
     * click elementary school checkbox
     *
     * @return this page
     */
    public SearchPage clickMiddleSchool() {
        waitUntilElementIsClickable(middleSchool);
        middleSchool.click();
        return this;
    }

    /**
     * click elementary school checkbox
     *
     * @return this page
     */
    public SearchPage clickPrivateSchool() {
        waitUntilElementIsClickable(privateSchool);
        privateSchool.click();
        return this;
    }

    /**
     * click on school rating slider and select ten rating
     *
     * @return this page
     */
    public SearchPage selectEightRating(){
        new Actions(driver).dragAndDrop(schoolRatingSlider, eightRating).perform();
        return this;
    }

    /**
     * wait until save button will be saved
     *
     * @return this page
     */
    public SearchPage waitUntilSaveButtonChangeState() {
        waitUntilElementIsVisible(saveButtonText);
        return this;
    }

}
