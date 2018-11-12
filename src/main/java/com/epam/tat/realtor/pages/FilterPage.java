package com.epam.tat.realtor.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class FilterPage extends BasePage {
    public FilterPage(AppiumDriver<WebElement> driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='com.move.realtor:id/search_editor_tab_min_price']")
    private AndroidElement minPriceInput;
    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='com.move.realtor:id/search_editor_tab_max_price']")
    private AndroidElement maxPriceInput;
    @AndroidFindBy(xpath = "//android.view.View[@resource-id='com.move.realtor:id/search_editor_tab_bed_options']")
    private AndroidElement bedNumber;
    @AndroidFindBy(xpath = "//android.view.View[@resource-id='com.move.realtor:id/search_editor_tab_bath_options']")
    private AndroidElement bathNumber;
    @AndroidFindBy(id = "com.move.realtor:id/search_editor_view_results_btn")
    private AndroidElement viewButton;

    public FilterPage enterMinPrice(String minPriceValue){
        minPriceInput.click();
        minPriceInput.sendKeys(minPriceValue);
        return this;
    }
    public FilterPage enterMaxPrice(String maxPriceValue){
        maxPriceInput.click();
        maxPriceInput.sendKeys(maxPriceValue);
        return this;
    }
    public FilterPage swipeToBedsSection(){
        swipeUp(100,860,100,400);
        return this;
    }
    public FilterPage tapBedsSection(){
        tapByCoordinates(100,860);
        return this;
    }
    public FilterPage chooseBeds(){
        tapByCoordinates(bedNumber.getLocation().x+430,bedNumber.getLocation().y+63);
        return this;
    }
    public FilterPage chooseBath(){
        tapByCoordinates(bathNumber.getLocation().x+390,bathNumber.getLocation().y+63);
        swipeToBedsSection();
        return new FilterPage(driver);
    }
    public HomePage clickViewButton(){
        waitUntilElementToBeClickable(viewButton);
        viewButton.click();
        return new HomePage(driver);
    }
}

