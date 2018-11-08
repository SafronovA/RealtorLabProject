package com.epam.tat.realtor.pages;

import com.epam.tat.realtor.ConfigProperties;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    protected AppiumDriver driver;
    private WebDriverWait driverWait;
    private PointOption topCenterWorkScreenCoordinates;
    private PointOption bottomCenterWorkScreenCoordinates;

    public BasePage(AppiumDriver driver) {
        this.driver = driver;
        driverWait = new WebDriverWait(driver, Integer.valueOf(ConfigProperties.getTestProperty("driverWaitTime")));
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
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
        final double DELTA = 0.05;
        int commonX = (int) (dimension.width * DELTA);
        int topY = (int) (dimension.height * DELTA);
        int bottomY = (int) (dimension.height * (1 - DELTA));

        topCenterWorkScreenCoordinates = new PointOption().withCoordinates(commonX, topY);
        bottomCenterWorkScreenCoordinates = new PointOption().withCoordinates(commonX, bottomY);
    }

    /**
     * wait until webElement is visible
     *
     * @param androidElement webElement to be visible
     */
    public void waitUntilElementIsVisible(AndroidElement androidElement) {
        driverWait.until(ExpectedConditions.visibilityOf(androidElement));
    }

}
