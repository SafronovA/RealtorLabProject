package com.epam.tat.realtor.pages;

import com.epam.tat.realtor.ConfigProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait driverWait;
    private static final String INNER_HTML = "innerHTML";

    public BasePage(WebDriver driver) {
        this.driver = driver;
        driverWait = new WebDriverWait(driver, Integer.valueOf(ConfigProperties.getTestProperty("webDriverWaitTime")));
    }

    /**
     * wait until webElement is visible
     *
     * @param webElement webElement to be visible
     */
    public void waitUntilElementIsVisible(WebElement webElement) {
        driverWait.until(ExpectedConditions.visibilityOf(webElement));
    }

    /**
     * wait until webElement is clickable
     *
     * @param webElement webElement to be clickable
     */
    public void waitUntilElementIsClickable(WebElement webElement) {
        driverWait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    /**
     * waiting for a specific attribute value in the Web element
     * @param webElement checked webElement
     * @param value      expected value
     */
    public void waitUntilAttributeInnerHTMLToBe(WebElement webElement, String value ){
        driverWait.until(ExpectedConditions.attributeToBe(webElement, INNER_HTML, value));
    }

    /**
     * click element by Java Executor
     * @param webElement web element to be clicked
     * @param webDriver used webdriver
     */
    public static void clickByJEx (WebElement webElement, WebDriver webDriver){
        JavascriptExecutor executor = (JavascriptExecutor) webDriver;
        executor.executeScript("arguments[0].click();", webElement);
    }

    /**
     * wait for presence of all elements by locator
     * @param by locator of the elements
     */
    public void waitForElements(By by){
        driverWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
    }

    /**
     * wait until JQuery finish loading page
     */
    public void waitForJQueryIsLoad(){
        driverWait.until((ExpectedCondition<Boolean>) driver -> {
            try {
                return ((Long)((JavascriptExecutor)driver).executeScript("return jQuery.active") == 0);
            }
            catch (Exception e) {
                return true;
            }
        });
    }

}
