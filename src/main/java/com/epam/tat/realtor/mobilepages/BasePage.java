package com.epam.tat.realtor.mobilepages;

import com.epam.tat.realtor.ConfigProperties;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected AppiumDriver<WebElement> driver;
    protected WebDriverWait driverWait;

    public BasePage(AppiumDriver<WebElement> driver) {
        this.driver = driver;
        driverWait = new WebDriverWait(driver, Integer.valueOf(ConfigProperties.getTestProperty("webDriverWaitTime")));

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
