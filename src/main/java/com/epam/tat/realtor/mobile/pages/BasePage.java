package com.epam.tat.realtor.mobile.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    protected AppiumDriver appiumDriver;
    private WebDriverWait webDriverWait;

    public BasePage(AppiumDriver appiumDriver){
        this.appiumDriver = appiumDriver;
        webDriverWait = new WebDriverWait(appiumDriver, 20);
    }

    /**
     * wait until webElement is visible
     *
     * @param webElement webElement to be visible
     */
    public void waitUntilElementIsVisible(AndroidElement webElement) {
        webDriverWait.until(ExpectedConditions.visibilityOf(webElement));
    }

    /**
     * wait until webElement is invisible
     *
     * @param webElement webElement to be visible
     */
    public void waitUntilElementIsInvisible(AndroidElement webElement) {
        webDriverWait.until(ExpectedConditions.invisibilityOf(webElement));
    }

}
