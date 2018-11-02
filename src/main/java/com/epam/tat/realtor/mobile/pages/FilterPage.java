package com.epam.tat.realtor.mobile.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class FilterPage extends BasePage {

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.move.realtor:id/search_editor_tab_min_price\")")
    private AndroidElement minPriceInput;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.move.realtor:id/search_editor_tab_max_price\")")
    private AndroidElement maxPriceInput;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.move.realtor:id/search_editor_view_results_btn\")")
    private AndroidElement viewResultsButton;

    public FilterPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public FilterPage enterMinPrice(String minPrice){
        minPriceInput.sendKeys(minPrice);
        return this;
    }

    public FilterPage enterMaxPrice(String maxPrice){
        maxPriceInput.sendKeys(maxPrice);
        return this;
    }

    public ViewPage clickViewResultsButton(){
        viewResultsButton.click();
        return new ViewPage(driver);
    }

}
