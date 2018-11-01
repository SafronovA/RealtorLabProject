package com.epam.tat.realtor.mobilepages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SearchPage extends BasePage {
    public SearchPage(AppiumDriver<WebElement> driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    @AndroidFindBy(xpath = "//android.view.View[@resource-id='com.move.realtor:id/toolbar_placeholder']")
    WebElement searchInput;
    @AndroidFindBy(xpath = "(//android.widget.RelativeLayout[@resource-id='com.move.realtor:id/content'])[1]")
    WebElement firstResult;
    public SearchPage searchInputSendKeys(String str) {
        searchInput.sendKeys(str+'\n');
        return this;
    }
    public HomePage firstResultClick(){
        driverWait.until(ExpectedConditions.visibilityOf(firstResult));
        firstResult.click();
        return new HomePage(driver);
    }
}
