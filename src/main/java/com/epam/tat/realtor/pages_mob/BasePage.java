package com.epam.tat.realtor.pages_mob;

import com.epam.tat.realtor.ConfigProperties;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected AppiumDriver driver;
    protected WebDriverWait driverWait;
    private static final String INNER_HTML = "innerHTML";

    public BasePage(AppiumDriver driver) {
        this.driver = driver;
        driverWait = new WebDriverWait(driver, Integer.valueOf(ConfigProperties.getTestProperty("webDriverWaitTime")));
    }

    public static void swipeUp(AppiumDriver driver) {
        new TouchAction(driver)
                .press(new PointOption().withCoordinates(500, 1800))
                .waitAction(new WaitOptions().withDuration(Duration.ofSeconds(1)))
                .moveTo(new PointOption().withCoordinates(500, 500))
                .release()
                .perform();
    }

    public void swipeFromTo(PointOption from, PointOption to) {
        new TouchAction(driver)
                .press(from)
                .waitAction(new WaitOptions().withDuration(Duration.ofSeconds(1)))
                .moveTo(to)
                .release()
                .perform();
    }

    /**
     * wait until webElement is visible
     *
     * @param androidElement webElement to be visible
     */
    public void waitUntilElementIsVisible(AndroidElement androidElement) {
        driverWait.until(ExpectedConditions.visibilityOf(androidElement));
    }

    /**
     * wait until webElement is visible
     *
     * @param locator webElement to be visible
     */
    public void waitUntilElementIsVisible(By locator) {
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    /**
     * wait until webElement is clickable
     *
     * @param androidElement webElement to be clickable
     */
    public void waitUntilElementIsClickable(AndroidElement androidElement) {
        driverWait.until(ExpectedConditions.elementToBeClickable(androidElement));
    }

    /**
     * click element by Java Executor
     *
     * @param androidElement web element to be clicked
     * @param webDriver     used webdriver
     */
    public static void clickByJEx(AndroidElement androidElement, WebDriver webDriver) {
        JavascriptExecutor executor = (JavascriptExecutor) webDriver;
        executor.executeScript("arguments[0].click();", androidElement);
    }

    /**
     * wait for the presence of the elements by locator
     *
     * @param by locator of the elements
     */
    public void waitForPresenceOfAllElementsLocatedBy(By by) {
        driverWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
    }

    /**
     * waiting for a specific attribute value in the Web element
     *
     * @param androidElement checked webElement
     * @param value         expected value
     */
    public void waitUntilAttributeInnerHTMLToBe(AndroidElement androidElement, String value) {
        driverWait.until(ExpectedConditions.attributeToBe(androidElement, INNER_HTML, value));
    }

    /**
     * wait for presence of all elements by locator
     *
     * @param by locator of the elements
     */
    public void waitForElements(By by) {
        driverWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
    }

    /**
     * wait until element is invisible
     *
     * @param androidElement element to be invisible
     */
    public void waitUntilElementIsInvisible(AndroidElement androidElement) {
        driverWait.until(ExpectedConditions.invisibilityOf(androidElement));
    }

    /**
     * wait until element become invisible
     *
     * @param location WebElement with such location should become invisible
     */
    public void waitInvisibilityOfElementLocated(By location) {
        driverWait.until(ExpectedConditions.invisibilityOfElementLocated(location));
    }

    public void waitInvisibilityOfElement(AndroidElement androidElement) {
        driverWait.until(ExpectedConditions.invisibilityOf(androidElement));
    }

    /**
     * wait until JQuery finish loading page
     */
    public void waitForJQueryIsLoad() {
        driverWait.until((ExpectedCondition<Boolean>) driver -> {
            try {
                return ((Long) ((JavascriptExecutor) driver).executeScript("return jQuery.active") == 0);
            } catch (Exception e) {
                return true;
            }
        });
    }
}
