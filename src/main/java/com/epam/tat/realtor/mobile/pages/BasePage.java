package com.epam.tat.realtor.mobile.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    protected AppiumDriver driver;
    private WebDriverWait webDriverWait;

    public BasePage(AppiumDriver driver){
        this.driver = driver;
        webDriverWait = new WebDriverWait(driver, 20);
    }

    public void waitUntilElementIsVisible(AndroidElement webElement) {
        webDriverWait.until(ExpectedConditions.visibilityOf(webElement));
    }

}
