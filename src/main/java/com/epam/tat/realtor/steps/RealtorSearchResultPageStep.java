package com.epam.tat.realtor.steps;

import com.epam.tat.realtor.pages.BasePage;
import com.epam.tat.realtor.pages.RealtorSearchResultPage;
import com.epam.tat.realtor.util.Parser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
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
     * click on activity map button
     *
     * @return RealtorSearchResultPageStep
     */
    public RealtorSearchResultPageStep clickActivityMapButton() {
        realtorSearchResultPage.clickActivityMapButton();
        return this;
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

}
