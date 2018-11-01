package com.epam.tat.realtor.mobilepages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {
    public HomePage(AppiumDriver<WebElement> driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    @AndroidFindBy(accessibility = "Drawer Open")
   // @AndroidFindBy(xpath = "(//android.widget.ImageButton)[1]")
    WebElement menuButton;
    @AndroidFindBy(accessibility = "Filter")
    WebElement filterButton;
    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='com.move.realtor:id/search_editor_tab_min_price']")
    WebElement minPriceInput;
    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='com.move.realtor:id/search_editor_tab_max_price']")
    WebElement maxPriceInput;
    @AndroidFindBy(xpath = "//android.view.View[@resource-id='com.move.realtor:id/search_editor_tab_bed_options']")
    WebElement bedNumber;
    @AndroidFindBy(xpath = "//android.view.View[@resource-id='com.move.realtor:id/search_editor_tab_bath_options']")
    WebElement bathNumber;

    public MenuPage clickMenuButton() {
        menuButton.click();
        return new MenuPage(driver);
    }
    public HomePage clickFilterButton() {
        filterButton.click();
        return this;
    }
    public HomePage enterMinPrice(String minPriceValue){
        minPriceInput.click();
        minPriceInput.sendKeys(minPriceValue);
        return this;
    }
    public HomePage enterMaxPrice(String maxPriceValue){
        maxPriceInput.click();
        maxPriceInput.sendKeys(maxPriceValue);
        return this;
    }
    public HomePage swipeToBedsSection(){
        swipeUp(100,860,100,400);
        return this;
    }
    public HomePage tapBedsSection(){
        tapByCoordinates(100,860);
        return this;
    }
    public HomePage chooseBeds(){
        tapByCoordinates(bedNumber.getLocation().x+430,bedNumber.getLocation().y+63);
        return this;
    }
    public HomePage chooseBath(){
        tapByCoordinates(bathNumber.getLocation().x+390,bathNumber.getLocation().y+63);
        return this;
    }



}
