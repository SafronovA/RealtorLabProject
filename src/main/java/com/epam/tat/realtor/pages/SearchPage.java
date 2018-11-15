package com.epam.tat.realtor.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class SearchPage extends BasePage {

    public SearchPage(AppiumDriver<WebElement> driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(5)), this);
    }

    @AndroidFindBy(xpath = "//android.view.View[@resource-id='com.move.realtor:id/toolbar_placeholder']")
    private AndroidElement searchInput;
    @AndroidFindBy(xpath = "(//android.widget.RelativeLayout[@resource-id='com.move.realtor:id/content'])[1]")
    private AndroidElement firstResult;

    public SearchPage searchInputSendKeys(String str) {
        waitUntilElementIsVisible(searchInput);
        searchInput.click();
        searchInput.sendKeys(str);
        return this;
    }

    public MainPage firstResultClick() {
        waitUntilElementIsVisible(firstResult);
        firstResult.click();
        return new MainPage(driver);
    }
}
