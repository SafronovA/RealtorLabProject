package com.epam.tat.realtor.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    protected AppiumDriver driver;
    private WebDriverWait webDriverWait;

    public BasePage(AppiumDriver driver) {
        this.driver = driver;
        webDriverWait = new WebDriverWait(driver, 20);
    }

    public void waitUntilElementIsVisible(AndroidElement webElement) {
        webDriverWait.until(ExpectedConditions.visibilityOf(webElement));
    }

    public void waitUntilElementToBeClickable(AndroidElement webElement){
    webDriverWait.until(ExpectedConditions.elementToBeClickable(webElement));
    }
    public void waitUntilAllElementsAreVisible(By by){
        webDriverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
    }
    public void swipeUp(int xOffsetStart, int yOffsetStart, int xOffsetFinish, int yOffsetFinish) {
        new TouchAction(driver)
                .press(new PointOption().withCoordinates(xOffsetStart, yOffsetStart))
                .waitAction(new WaitOptions().withDuration(Duration.ofSeconds(1)))
                .moveTo(new PointOption().withCoordinates(xOffsetFinish, yOffsetFinish))
                .release()
                .perform();
    }
    public void tapByCoordinates(int xOffset, int yOffset) {
        new TouchAction(driver)
                .press(new PointOption().withCoordinates(xOffset, yOffset))
                .waitAction(new WaitOptions().withDuration(Duration.ofMillis(200)))
                .release()
                .perform();
    }

}
