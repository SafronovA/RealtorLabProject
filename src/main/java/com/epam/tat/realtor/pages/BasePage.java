package com.epam.tat.realtor.pages;

import com.epam.tat.realtor.util.ConfigProperties;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected AppiumDriver driver;
    private WebDriverWait driverWait;
    private PointOption topCenterWorkScreenCoordinates;
    private PointOption bottomCenterWorkScreenCoordinates;

    public BasePage(AppiumDriver driver) {
        this.driver = driver;
        driverWait = new WebDriverWait(driver, Integer.valueOf(ConfigProperties.getTestProperty("driverWaitTime")));
        generateCoordinates(driver);
    }

    public PointOption getTopCenterWorkScreenCoordinates() {
        return topCenterWorkScreenCoordinates;
    }

    public PointOption getBottomCenterWorkScreenCoordinates() {
        return bottomCenterWorkScreenCoordinates;
    }

    private void generateCoordinates(AppiumDriver driver) {
        Dimension dimension = driver.manage().window().getSize();
        final double DELTA = 0.10;
        int commonX = (int) (dimension.width * DELTA);
        int topY = (int) (dimension.height * DELTA);
        int bottomY = (int) (dimension.height * (1 - DELTA));

        topCenterWorkScreenCoordinates = new PointOption().withCoordinates(commonX, topY);
        bottomCenterWorkScreenCoordinates = new PointOption().withCoordinates(commonX, bottomY);
    }

    public void waitUntilElementIsVisible(AndroidElement androidElement) {
        driverWait.until(ExpectedConditions.visibilityOf(androidElement));
    }

    public void waitUntilElementToBeClickable(AndroidElement androidElement) {
        driverWait.until(ExpectedConditions.elementToBeClickable(androidElement));
    }

    public void waitUntilAllElementsAreVisible(By by) {
        driverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
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
