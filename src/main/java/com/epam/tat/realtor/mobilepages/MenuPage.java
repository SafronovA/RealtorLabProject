package com.epam.tat.realtor.mobilepages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;

public class MenuPage extends BasePage {
    public MenuPage(AppiumDriver<WebElement> driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    @AndroidFindBy(xpath = "(//android.widget.RelativeLayout[@resource-id='com.move.realtor:id/menu_item_entry'])[1]")
    WebElement startNewSearch;

    public SearchPage startNewSearch() {
        startNewSearch.click();
        return new SearchPage(driver);
    }
}
