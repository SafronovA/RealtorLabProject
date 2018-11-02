package com.epam.tat.realtor.mobilepages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class FilterPage extends BasePage {
    public FilterPage(AppiumDriver<WebElement> driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='com.move.realtor:id/search_editor_tab_min_price']")
    WebElement minPriceInput;
    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='com.move.realtor:id/search_editor_tab_max_price']")
    WebElement maxPriceInput;
    @AndroidFindBy(xpath = "//android.view.View[@resource-id='com.move.realtor:id/search_editor_tab_bed_options']")
    WebElement bedNumber;
    @AndroidFindBy(xpath = "//android.view.View[@resource-id='com.move.realtor:id/search_editor_tab_bath_options']")
    WebElement bathNumber;
    @AndroidFindBy(id = "com.move.realtor:id/search_editor_view_results_btn")
    WebElement viewButton;

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
        driverWait.until(ExpectedConditions.elementToBeClickable(viewButton));
        viewButton.click();
        return new HomePage(driver);
    }
    public FilterPage getTextViewButton(){
        driverWait.until(ExpectedConditions.visibilityOf(viewButton));
        System.out.println(viewButton.getText());
        return this;
    }
}

