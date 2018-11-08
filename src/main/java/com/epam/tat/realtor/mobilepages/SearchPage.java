package com.epam.tat.realtor.mobilepages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SearchPage extends BasePage {
    public SearchPage(AppiumDriver<WebElement> driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "//android.view.View[@resource-id='com.move.realtor:id/toolbar_placeholder']")
    private WebElement searchInput;
    @AndroidFindBy(xpath = "(//android.widget.RelativeLayout[@resource-id='com.move.realtor:id/content'])[1]")
    private WebElement firstResult;

    public SearchPage searchInputSendKeys(String str) {
        driverWait.until(ExpectedConditions.visibilityOf(searchInput));
        searchInput.click();
        searchInput.clear();
        searchInput.sendKeys(str);
        return this;
    }

    public HomePage firstResultClick() {
        driverWait.until(ExpectedConditions.visibilityOf(firstResult));
        firstResult.click();
        return new HomePage(driver);
    }
}
