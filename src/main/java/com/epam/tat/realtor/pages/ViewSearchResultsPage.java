package com.epam.tat.realtor.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ViewSearchResultsPage extends BasePage {

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.move.realtor:id/sort_spinner\")")
    private AndroidElement sortByButton;
    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"Filter\"]")
    private AndroidElement filterButton;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.move.realtor:id/priceTextView\")")
    private List<AndroidElement> homePricesList;
    @AndroidFindBy(xpath = "//*[@text='Expand Search Area']")
    private List<AndroidElement> expandSearchAreaButton;

    public ViewSearchResultsPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public List<AndroidElement> getHomePricesList(){
        return homePricesList;
    }

    public List<AndroidElement> getExpandSearchAreaButton() {
        return expandSearchAreaButton;
    }

    public FilterPage clickFilterButton(){
        filterButton.click();
        return new FilterPage(driver);
    }

    public SortOptionsPage clickSortByButton(){
        waitUntilElementIsClickable(sortByButton);
        sortByButton.click();
        return new SortOptionsPage(driver);
    }

}
