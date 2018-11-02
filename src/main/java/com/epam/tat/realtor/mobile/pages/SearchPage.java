package com.epam.tat.realtor.mobile.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class SearchPage extends BasePage {

    @AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc='Drawer Open']")
    private AndroidElement menuButton;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.move.realtor:id/search_edit_text\")")
    private AndroidElement searchInput;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.move.realtor:id/save_search\")")
    private AndroidElement saveSearchButton;

    public SearchPage(AppiumDriver appiumDriver) {
        super(appiumDriver);
        PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
    }

    public MenuPage clickMenuButton() {
        menuButton.click();
        return new MenuPage(appiumDriver);
    }

    public SearchPage enterCity(String city) {
        //searchInput.click();
        searchInput.sendKeys(city + "\n");
        //appiumDriver.getKeyboard().pressKey(AndroidKey.ENTER);
        return this;
    }

    public SearchPage clickSaveSearchButton(){
        waitUntilElementIsVisible(saveSearchButton);
        while (!saveSearchButton.getText().equals("UNSAVE SEARCH")) {
            saveSearchButton.click();
        }
        return this;
    }

}