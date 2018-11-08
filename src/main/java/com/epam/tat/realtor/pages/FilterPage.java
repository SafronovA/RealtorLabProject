package com.epam.tat.realtor.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class FilterPage extends BasePage {

    public FilterPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "//*[@resource-id='com.move.realtor:id/search_editor_tab_clear_icon']")
    private AndroidElement clearCityIcon;
    @AndroidFindBy(id = "com.move.realtor:id/search_editor_tab_location_frame")
    private AndroidElement cityInput;
    @AndroidFindBy(id = "com.move.realtor:id/search_editor_tab_min_price")
    private AndroidElement minPriceInput;
    @AndroidFindBy(id = "com.move.realtor:id/search_editor_tab_max_price")
    private AndroidElement maxPriceInput;
    @AndroidFindBy(id = "com.move.realtor:id/search_editor_view_results_btn")
    private AndroidElement viewResultsButton;

    public FilterPage clickClearCityIcon(){
        clearCityIcon.click();
        return this;
    }

    public FilterPage enterCity(String city){
        cityInput.sendKeys(city);
        return this;
    }

    public FilterPage enterMinPrice(String minPrice){
        minPriceInput.sendKeys(minPrice);
        return this;
    }
    public FilterPage enterMaxPrice(String maxPrice){
        maxPriceInput.sendKeys(maxPrice);
        return this;
    }

    public MainPage clickViewResultsButton(){
        viewResultsButton.click();
        return new MainPage(driver);
    }
}
