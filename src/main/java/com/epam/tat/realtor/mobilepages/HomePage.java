package com.epam.tat.realtor.mobilepages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

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
    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.move.realtor:id/view_list_label']")
    WebElement viewListButton;


    public MenuPage clickMenuButton() {
        menuButton.click();
        return new MenuPage(driver);
    }
    public FilterPage clickFilterButton() {
        filterButton.click();
        return new FilterPage(driver);
    }
    public ViewPage clickViewListButton(){
        driverWait.until(ExpectedConditions.visibilityOf(viewListButton));
        viewListButton.click();
        return new ViewPage(driver);
    }



}
