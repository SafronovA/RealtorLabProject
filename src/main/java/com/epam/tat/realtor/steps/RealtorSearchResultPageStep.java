package com.epam.tat.realtor.steps;

import com.epam.tat.realtor.pages.BasePage;
import com.epam.tat.realtor.pages.RealtorSearchResultPage;
import com.epam.tat.realtor.util.Parser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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
     * get value of realtor recommendations count
     *
     * @return recommendations count
     */
    public int getRecommendationsCount() {
        return Integer.valueOf(realtorSearchResultPage.getRecommendations().getText());
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

    public RealtorSearchResultPageStep clickGetStartedConfirmButton() {
        realtorSearchResultPage.clickGetStartedConfirmButton();
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
     * check that all photos shown on map match with selected realtor photo
     *
     * @return true, if match, false, if do not match
     */
    public boolean arePhotosOnMapMatchSelectedRealtorPhoto() {
        boolean arePhotosTheSame = true;
        String selectedRealtorPhoto = realtorSearchResultPage.getRealtorPhotoLink();
        for (int i = 1; i < realtorSearchResultPage.getPhotosOnMapCount() + 1; i++) {
            WebElement photoOnMap = realtorSearchResultPage.getPhotosOnMap(i);
            BasePage.clickByJEx(photoOnMap, driver);
            arePhotosTheSame = photoOnMap.getAttribute("src").equals(selectedRealtorPhoto);
        }
        return arePhotosTheSame;
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
        realtorSearchResultPage.getFirstRealtorCard().click();
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
     * icons must become selected after clicking on them
     *
     * @return true, if all icons become selected after clicking on them
     */
    public boolean iconsBecomeSelected() {
        int numberOfIconsOnMap = realtorSearchResultPage.getIconsFromMap().size();
        boolean result = true;
        for (int i = 1; i < numberOfIconsOnMap + 1; i++) {
            WebElement icon = realtorSearchResultPage.getIconByIndex(i);
            if (!iconIsSelected(icon)) {
                BasePage.clickByJEx(icon, driver);
                result &= iconIsSelected(icon);
            } else {
                return false;
            }
        }
        return result;
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

}
