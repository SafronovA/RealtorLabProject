package com.epam.tat.realtor.mobile.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

    @AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc='Drawer Open']")
    private AndroidElement menuButton;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.move.realtor:id/search_edit_text\")")
    private AndroidElement searchInput;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.move.realtor:id/save_search\")")
    private AndroidElement saveSearchButton;
    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.move.realtor:id/view_list_label']")
    private AndroidElement viewListButton;

    public HomePage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public MenuPage clickMenuButton() {
        menuButton.click();
        return new MenuPage(driver);
    }

    public HomePage enterCity(String city) {
        searchInput.sendKeys(city + "\n");
        return this;
    }

    public HomePage clickSaveSearchButton(){
        waitUntilElementIsVisible(saveSearchButton);
        while (!saveSearchButton.getText().equals("UNSAVE SEARCH")) {
            saveSearchButton.click();
        }
        return this;
    }

    public ViewPage clickViewListButton(){
        viewListButton.click();
        return new ViewPage(driver);
    }

}