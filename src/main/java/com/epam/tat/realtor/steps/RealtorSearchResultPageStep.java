package com.epam.tat.realtor.steps;

import com.epam.tat.realtor.pages.BasePage;
import com.epam.tat.realtor.pages.RealtorSearchResultPage;
import com.epam.tat.realtor.util.Parser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RealtorSearchResultPageStep extends BasePageStep {
    private RealtorSearchResultPage realtorSearchResultPage;

    public RealtorSearchResultPageStep(WebDriver driver) {
        super(driver);
        realtorSearchResultPage = new RealtorSearchResultPage(driver);
    }

    /**
     * get realtor sold houses number
     *
     * @return realtor sold houses number
     */
    public int getRealtorSoldHoses() {
        return Parser.parse(realtorSearchResultPage.getRealtorSoldHouses());
    }

    /**
     * get value of realtor rating count
     *
     * @return reating count
     */
    public int getRatingCount() {
        return Parser.parse(realtorSearchResultPage.getRatingCount().getText());
    }

    /**
     * click realtor icon
     *
     * @return new RealtorPageStep
     */
    public RealtorPageStep clickRealtorIcon() {
        realtorSearchResultPage.clickRealtorIcon();
        return new RealtorPageStep(driver);
    }

    /**
     * click activity map button
     *
     * @return this step
     */
    public RealtorSearchResultPageStep clickActivityMapButton() {
        realtorSearchResultPage.clickActivityMapButton();
        return this;
    }

    /**
     * click get started button
     *
     * @return this step
     */
    public RealtorSearchResultPageStep clickGetStartedButton() {
        realtorSearchResultPage.clickGetStartedButton();
        return this;
    }

    /**
     * chose required recommendations value in recommendations filter
     *
     * @param recommendation required value
     * @return this page
     */
    public RealtorSearchResultPageStep choseRecommendation(String recommendation) {
        realtorSearchResultPage.clickRecommendationFilterButton()
                .getRecommendationContainer().stream()
                .filter(x -> x.getAttribute("innerHTML").equals(recommendation))
                .findFirst().get().click();
        return this;
    }

    /**
     * chose required sort option
     *
     * @param sortBy required value
     * @return this page
     */
    public RealtorSearchResultPageStep choseSortOption(String sortBy) {
        realtorSearchResultPage.clickSortByButton()
                .getSortByOptions().stream()
                .filter(x -> x.getAttribute("innerHTML").trim().equalsIgnoreCase(sortBy))
                .findFirst().get().click();
        return this;
    }

    /**
     * check that realtors are displayed sorted by recommendations
     *
     * @return true if realtors are displayed sorted by recommendations, false if the are not
     */
    public boolean isRealtorsDisplayedSortedByRecommendations() {
        List<Integer> realtorRecommendations = findAllRecommendations();
        boolean sortedDescending =
                IntStream.range(0, realtorRecommendations.size() - 1)
                        .allMatch(i -> realtorRecommendations.get(i).compareTo(realtorRecommendations.get(i + 1)) >= 0);
        return sortedDescending;

    }

    /**
     * click on first realtor card
     *
     * @return this step
     */
    public RealtorSearchResultPageStep selectFirstRealtorCard() {
        realtorSearchResultPage.getRealtorCards()
                .get(0)
                .click();
        return this;
    }

    /**
     * click see agent's nearby properties button
     *
     * @return this step
     */
    public RealtorSearchResultPageStep clickSeeAgentsNearbyProperties() {
        realtorSearchResultPage.clickSeeAgentsNearbyProperties();
        return this;
    }

    /**
     * compare homes data with icons data
     *
     * @return true, if house statuses correspond to the status of icons on the map
     */
    public boolean colorIsCorrect() {
        return getHomesData().equals(getIconsData());
    }

    /**
     * @return true, if all icons react correctly on clicking on them
     */
    public boolean iconsReactCorrectly() {
        return iconsBecomeSelected(realtorSearchResultPage.getIconsFromMapLocator());
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
        List<Integer> recommendationsList = recommendations.stream().map(WebElement -> Integer.valueOf(WebElement.getText())).collect(Collectors.toList());
        return recommendationsList;
    }

    /**
     * icons must become selected after clicking on them
     *
     * @param locator that is used to search for all icons on the map
     * @return true, if all icons become selected after clicking on them
     */
    private boolean iconsBecomeSelected(String locator) {
        int numberOfIconsOnMap = realtorSearchResultPage.getIconsFromMap().size();
        boolean result = true;
        for (int i = 1; i < numberOfIconsOnMap + 1; i++) {
            By currentElement = By.xpath("(" + locator + ")[" + i + "]");
            WebElement element = driver.findElement(currentElement);
            if (!iconIsSelected(element)) {
                BasePage.clickByJEx(element, driver);
                result &= iconIsSelected(element);
            } else {
                result = false;
            }
        }
        return result;
    }

    /**
     * get id and status of icons from map
     *
     * @return HashMap with id and status of icons
     */
    private HashMap<String, Status> getIconsData() {
        HashMap<String, Status> iconsData = new HashMap<>();
        realtorSearchResultPage.getIconsFromMap().forEach(x -> iconsData.put(x.getAttribute("data-id"), getIconStatus(x)));
        return iconsData;
    }

    /**
     * get id and status of home cards
     *
     * @return HashMap with id and status of home cards
     */
    private HashMap<String, Status> getHomesData() {
        HashMap<String, Status> homesData = new HashMap<>();
        realtorSearchResultPage.getHomeCards().forEach(x -> homesData.put(x.getAttribute("data-mpr-id"), getHomeStatus(x)));
        return homesData;
    }

    /**
     * get icon status
     *
     * @param element icon to be checked
     * @return status passed element
     */
    private Status getIconStatus(WebElement element) {
        Status status;
        String classValue = Parser.getLastWord(element.getAttribute("class"));
        switch (classValue) {
            case "for_sale":
                status = Status.FOR_SALE;
                break;
            case "recently_sold":
                status = Status.JUST_SOLD;
                break;
            default:
                status = Status.UNKNOWN;
                break;
        }
        return status;
    }

    /**
     * get home status
     *
     * @param element home to be checked
     * @return status passed element
     */
    private Status getHomeStatus(WebElement element) {
        Status status;
        By passToHomeStatus = By.xpath("div/div");
        String classValue = Parser.getLastWord(element.findElement(passToHomeStatus).getAttribute("class"));
        switch (classValue) {
            case "for_sale":
                status = Status.FOR_SALE;
                break;
            case "recently_sold":
                status = Status.JUST_SOLD;
                break;
            default:
                status = Status.UNKNOWN;
                break;
        }
        return status;
    }

    /**
     * checks is web element selected or not
     *
     * @param webElement checked element
     * @return true, if attribute class contains 'selected' in the end
     */
    private boolean iconIsSelected(WebElement webElement) {
        String selected = "selected";
        String classValue = webElement.getAttribute("class");
        return Parser.getLastWord(classValue).equals(selected);
    }

    /**
     * possible web element statuses
     */
    private enum Status {
        FOR_SALE, JUST_SOLD, UNKNOWN
    }
}
