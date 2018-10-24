package com.epam.tat.realtor.bddsteps;

import com.epam.tat.realtor.pages.*;
import com.epam.tat.realtor.util.Parser;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RealtorPageFeatureStep {

    private static HomePage homePage;
    private static FindRealtorPage findRealtorPage;
    private static RealtorPage realtorPage;
    private static RealtorSearchResultPage realtorSearchResultPage;
    private static WebDriver driver;
    private int recommendationCount;
    private int reviewCount;
    private int soldHousesCount;

    public void setDriver(WebDriver driver) {
        this.driver = driver;
        homePage = new HomePage(driver);
        findRealtorPage = new FindRealtorPage(driver);
        realtorPage = new RealtorPage(driver);
        realtorSearchResultPage = new RealtorSearchResultPage(driver);
    }

    /**
     * click Realtor button
     */
    @When("click find realtor button")
    public void clickFindRealtorButton() {
        homePage.clickRealtorButton();
    }

    /**
     * enter realtor name in the search input
     *
     * @param realtorName realtor name as search criteria
     */
    @And("enter realtor name \"([^\"]*)\"")
    public void enterRealtorName(String realtorName) {
        findRealtorPage.enterRealtorName(realtorName);
    }

    /**
     * enter realtor location in the location input
     *
     * @param realtorLocation realtor name as search criteria
     */
    @And("enter realtor location \"([^\"]*)\"")
    public void enterLocation(String realtorLocation) {
        findRealtorPage.enterLocation(realtorLocation);
    }

    /**
     * click search button
     */
    @And("click search button")
    public void clickSearchButton(){
        findRealtorPage.clickSearchButton();
    }

    /**
     * get sold houses map marks,
     * click on each mark in the list,
     * check status of every mark
     */
    @And("houses on the iframe map have sold status")
    public void checkSoldHousesMapMarks() {
        boolean areHousesHaveSoldStatus = realtorPage.getSoldHousesMapMarkList()
                .stream()
                .allMatch(x -> {
                    BasePage.clickByJEx(x, driver);
                    return isSold(realtorPage.getSoldHouseStatus());
                });
        Assert.assertTrue(areHousesHaveSoldStatus,
                "wrong status of sold houses on the iframe map");
    }

    /**
     * get number of sold houses
     */
    @Then("sold houses count in the realtor card match count on the iframe map")
    public void getSoldHousesQuantity() {
        Assert.assertEquals(soldHousesCount, realtorPage.getSoldHousesMapMarkList().size(),
                "number of sold houses in the realtor card mismatch number on the iframe map ");
    }

    /**
     * scroll to iframe,
     * click on "Recently Sold" section,
     * double click on zoom out button,
     * drag down iframe to 50 yOffset
     */
    @And("scroll to map, click realtor sold houses, double zoom out")
    public void prepareIFrameMap() {
        realtorPage.scrollToIFrame()
                .clickSoldHousesSection()
                .doubleZoomOut();
        dragDownIFrame();
    }

    /**
     * click load all reviews button untill all reviews won't be loaded
     */
    @And("click load all reviews")
    public void loadAllReviews() {
        while (realtorPage.isLoadMoreReviewsButtonDisplayed()) {
            realtorPage.clickLoadMoreReviewsButton();
        }
    }

    /**
     * click load all recommendations button until all recommendations won't be loaded
     */
    @And("click load all recommendation")
    public void loadAllRecommendations() {
        realtorPage.scrollDown();
        while (realtorPage.isLoadMoreRecommendationsButtonDisplayed()) {
            realtorPage.clickLoadMoreRecommendationsButton();
        }
    }

    /**
     * get realtor recommendations count
     */
    @Then("recommendation count on the page match recommendations count in the realtor's card")
    public void getRealtorRecommendationsCount() {
        Assert.assertEquals(recommendationCount, realtorPage.getRealtorRecommendations().size(),
                "number of realtor reviews in the realtor card mismatch reviews number on the realtor page");
    }

    /**
     * get realtor reviews count
     */
    @Then("reviews count on the page match reviews count in the realtor's card")
    public void getRealtorReviewsCount() {
        Assert.assertEquals(reviewCount, realtorPage.getRealtorReviews().size(),
                "number of realtor reviews in the realtor card mismatch reviews number on the realtor page");
    }

    /**
     * get value of realtor rating count
     *
     * @return reating count
     */
    @And("get rating count")
    public void getRatingCount() {
        reviewCount = Parser.parse(realtorSearchResultPage.getRatingCount().getText());
    }

    /**
     * scroll to map, click on icon and check that houses have status for sale
     */
    @Then("houses with red icon have for sale status")
    public void areHousesHaveStatusForSale() {
        realtorPage.scrollToMap();
        boolean areForSaleHousesHaveRedIcon = realtorPage.getForSaleHouses().stream()
                .allMatch(WebElement -> {
                    BasePage.clickByJEx(WebElement, driver);
                    return realtorPage.getForSaleHouseStatus().equalsIgnoreCase("for sale");
                });
        Assert.assertTrue(areForSaleHousesHaveRedIcon,
                "One of houses do not have 'For Sale' status");
    }

    /**
     * get realtor sold houses number
     */
    @And("get realtor sold houses count")
    public void getRealtorSoldHoses() {
        soldHousesCount = Parser.parse(realtorSearchResultPage.getRealtorSoldHouses());
    }

    /**
     * click realtor icon
     */
    @And("click on realtor icon")
    public void clickRealtorIcon() {
        realtorSearchResultPage.clickRealtorIcon();
    }

    /**
     * click activity map button
     */
    @And("click activity map button")
    public void clickActivityMapButton() {
        realtorSearchResultPage.clickActivityMapButton();
    }

    /**
     * click get started button
     */
    @And("click get started activity map button")
    public void clickGetStartedButton() {
        realtorSearchResultPage.clickGetStartedButton();
    }

    /**
     * chose required recommendations value in recommendations filter
     *
     * @param recommendation required value
     */
    @And("choose recommendation")
    public void choseRecommendation(String recommendation) {
        realtorSearchResultPage.clickRecommendationFilterButton()
                .getRecommendationContainer().stream()
                .filter(x -> x.getAttribute("innerHTML").equals(recommendation))
                .findFirst().get().click();
    }

    /**
     * chose required sort option
     *
     * @param sortBy required value
     */
    @And("choose sort option")
    public void choseSortOption(String sortBy) {
        realtorSearchResultPage.clickSortByButton()
                .getSortByOptions().stream()
                .filter(x -> x.getAttribute("innerHTML").trim().equalsIgnoreCase(sortBy))
                .findFirst().get().click();
    }

    /**
     * check that all photos shown on map match with selected realtor photo
     */
    @Then("photos on map match realtor photo")
    public void arePhotosOnMapMatchSelectedRealtorPhoto() {
        String selectedRealtorPhoto = realtorSearchResultPage.getRealtorPhotoLink();
        boolean arePhotosOnMapMatchSelectedRealtorPhoto = IntStream.range(1, realtorSearchResultPage.getPhotosOnMapCount() + 1)
                .allMatch(i -> {
                    WebElement photoOnMap = realtorSearchResultPage.getPhotosOnMap(i);
                    BasePage.clickByJEx(photoOnMap, driver);
                    return photoOnMap.getAttribute("src").equals(selectedRealtorPhoto);
                });
        Assert.assertTrue(arePhotosOnMapMatchSelectedRealtorPhoto,
                "One of photos shown on map do not match with selected realtor photo");
    }

    /**
     * check that realtors are displayed sorted by recommendations
     */
    @Then("realtors are displayed sorted by recommendation")
    public void isRealtorsDisplayedSortedByRecommendations() {
        List<Integer> realtorRecommendations = findAllRecommendations();
        boolean sortedDescending =
                IntStream.range(0, realtorRecommendations.size() - 1)
                        .allMatch(i -> realtorRecommendations.get(i).compareTo(realtorRecommendations.get(i + 1)) >= 0);
        Assert.assertTrue(sortedDescending,
                "Realtors are not sorted by descending number of reviews");

    }

    /**
     * click on first realtor card
     */
    @And("select first realtor card")
    public void selectFirstRealtorCard() {
        realtorSearchResultPage.getFirstRealtorCard().click();
    }

    /**
     * click see agent's nearby properties button
     */
    @And("click see agents nearby properties")
    public void clickSeeAgentsNearbyProperties() {
        realtorSearchResultPage.clickSeeAgentsNearbyProperties();
    }

    /**
     * compare homes data with icons data
     */
    @Then("icon colors on map match house status")
    public void colorIsCorrect() {
        Assert.assertTrue(getHomesData().equals(getIconsData()),
                "Found at least 1 mismatch of home status and status of the icon on the map");
    }

    /**
     * icons must become selected after clicking on them
     */
    @Then("icon become selected after click")
    public void iconsBecomeSelected() {
        int numberOfIconsOnMap = realtorSearchResultPage.getIconsFromMap().size();
        boolean iconBecomeSelected = true;
        for (int i = 1; i < numberOfIconsOnMap + 1; i++) {
            WebElement icon = realtorSearchResultPage.getIconByIndex(i);
            if (!iconIsSelected(icon)) {
                BasePage.clickByJEx(icon, driver);
                iconBecomeSelected &= iconIsSelected(icon);
            } else {
                iconBecomeSelected = false;
                i = numberOfIconsOnMap + 1;
            }
        }
        Assert.assertTrue(iconBecomeSelected,
                "Found at least one icon on the map, which did not change status / did not increase after clicking on it");
    }

    /**
     * get value of realtor recommendations count
     *
     * @return recommendations count
     */
    @And("get recommendation count")
    public void getRecommendationsCount() {
        recommendationCount = Integer.valueOf(realtorSearchResultPage.getRecommendations().getText());
    }

    /**
     * add homes from all pages to integer list. Add homes from first page, while exist next page, click next link
     * and add home prices from this page.
     *
     * @return list integer prices from all pages
     */
    private List<Integer> findAllRecommendations() {
        List<Integer> recommendationsNumber = new ArrayList<>();
        recommendationsNumber.addAll(receiveRecommendationsListFromWebElementList(realtorSearchResultPage.getNumberOfRecommendationsList()));
        while (!realtorSearchResultPage.getNextPageButton().isEmpty()) {
            realtorSearchResultPage.clickNextPageButton();
            recommendationsNumber.addAll(receiveRecommendationsListFromWebElementList(realtorSearchResultPage.getNumberOfRecommendationsList()));
        }
        return recommendationsNumber;
    }

    /**
     * receive list of recommendation numbers from list WebElement
     *
     * @param recommendations List<WebElement> found on page
     * @return List<Integer> int recommendations received from WebElement list
     */
    private List<Integer> receiveRecommendationsListFromWebElementList(List<WebElement> recommendations) {
        return recommendations.stream().map(WebElement -> Integer.valueOf(WebElement.getText())).collect(Collectors.toList());
    }

    /**
     * get id and status of icons from map
     *
     * @return Map with id and status of icons
     */
    private Map<String, String> getIconsData() {
        return realtorSearchResultPage.getIconsFromMap().stream()
                .collect(Collectors.toMap(x -> x.getAttribute("data-id"), this::getIconStatus));
    }

    /**
     * get id and status of home cards
     *
     * @return Map with id and status of home cards
     */
    private Map<String, String> getHomesData() {
        return realtorSearchResultPage.getHomeCards().stream()
                .collect(Collectors.toMap(x -> x.getAttribute("data-mpr-id"), this::getHomeStatus));
    }

    /**
     * get icon status
     *
     * @param iconElement icon to be checked
     * @return status passed element
     */
    private String getIconStatus(WebElement iconElement) {
        String statusFromClassAttribute = Parser.getLastWord(iconElement.getAttribute("class"));
        return statusFromClassAttribute;
    }

    /**
     * get home status
     *
     * @param homeElement home to be checked
     * @return status passed element
     */
    private String getHomeStatus(WebElement homeElement) {
        By passToAttributeWithStatus = By.xpath("div/div");
        String statusFromClassAttribute = Parser.getLastWord(homeElement.findElement(passToAttributeWithStatus).getAttribute("class"));
        return statusFromClassAttribute;
    }

    /**
     * checks is web element selected or not
     *
     * @param webElement checked element
     * @return true, if attribute class contains 'selected' in the end
     */
    private boolean iconIsSelected(WebElement webElement) {
        String classValue = webElement.getAttribute("class");
        return Parser.getLastWord(classValue).equals("selected");
    }

    /**
     * check if map mark has "sold" text inside
     *
     * @param houseStatus text of the map mark
     */
    private boolean isSold(String houseStatus) {
        return houseStatus.trim().equalsIgnoreCase("sold");
    }


    /**
     * drag down iframe to 100 yOffset
     */
    private void dragDownIFrame() {
        new Actions(driver).dragAndDropBy(realtorPage.getSoldHousesMapMarkList().get(0), 0, 100).click().perform();
    }

}
