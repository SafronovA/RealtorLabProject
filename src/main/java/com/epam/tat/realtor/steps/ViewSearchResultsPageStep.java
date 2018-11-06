package com.epam.tat.realtor.steps;

import com.epam.tat.realtor.pages.ViewSearchResultsPage;
import com.epam.tat.realtor.util.Parser;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ViewSearchResultsPageStep extends BasePageStep {

    private ViewSearchResultsPage viewSearchResultsPage;

    public ViewSearchResultsPageStep(AppiumDriver driver){
        super(driver);
        viewSearchResultsPage = new ViewSearchResultsPage(driver);
    }

    public FilterPageStep clickFilterButton(){
        viewSearchResultsPage.clickFilterButton();
        return new FilterPageStep(driver);
    }

    public SortOptionsPageStep clickSortByButton(){
        viewSearchResultsPage.clickSortByButton();
        return new SortOptionsPageStep(driver);
    }

    public boolean doesHomeDisplayedSortedByPrice(){
        List<Integer> homePrices = getAllHomePricesFromPage();
        boolean sortedDescending =
                IntStream.range(0, homePrices.size() - 1)
                        .allMatch(i -> homePrices.get(i).compareTo(homePrices.get(i + 1)) <= 0);
        return sortedDescending;

    }

    private List<Integer> getAllHomePricesFromPage(){
        List<Integer> homePricesList = new ArrayList<>();
        while (viewSearchResultsPage.getExpandSearchAreaButton().isEmpty()) {
            swipe(driver);
            homePricesList.addAll(parseAndroidElementsListToIntegerList(viewSearchResultsPage.getHomePricesList()));
        }
        return homePricesList;
    }

    private List<Integer> parseAndroidElementsListToIntegerList(List<AndroidElement> homePricesList){
        try {                       // waiting for the page to become static after the swipe
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return homePricesList.stream().map(AndroidElement::getText).map(Parser::parse).collect(Collectors.toList());
    }

}
