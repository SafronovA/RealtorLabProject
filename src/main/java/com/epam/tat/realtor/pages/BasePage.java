package com.epam.tat.realtor.pages;

import com.epam.tat.realtor.ConfigProperties;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait driverWait;

    public BasePage(WebDriver driver){
        this.driver = driver;
        driverWait = new WebDriverWait(driver,Integer.valueOf(ConfigProperties.getTestProperty("webDriverWaitTime")));
    }

    /**
     * wait until webElement is visible
     * @param webElement webElement to be visible
     */
    public void waitUntilElementIsVisible(WebElement webElement){
        driverWait.until(ExpectedConditions.visibilityOf(webElement));
    }
    /**
     * wait until webElement is clickable
     * @param webElement webElement to be clickable
     */
    public void waitUntilElementIsClickable(WebElement webElement){
        driverWait.until(ExpectedConditions.elementToBeClickable(webElement));
    }
    public void waitJSExecuteScriptDocumentReady(){
        new WebDriverWait(driver, Integer.valueOf(ConfigProperties.getTestProperty("webDriverWaitTime"))).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }



}
