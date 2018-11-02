package com.epam.tat.realtor.mobile.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class ViewPage extends BasePage {

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.move.realtor:id/sort_spinner\")")
    private AndroidElement sortByButton;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.move.realtor:id/text1\")")
    private AndroidElement lowToHighSortOption;
    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"Filter\"]")
    private AndroidElement filterButton;

    public ViewPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public FilterPage clickFilterButton(){
        filterButton.click();
        return new FilterPage(driver);
    }

    public ViewPage clickSortByButton(){
        sortByButton.click();
        return this;
    }

    public ViewPage selectLowToHighSortOption(){
        lowToHighSortOption.click();
        return this;
    }

}
