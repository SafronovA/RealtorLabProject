package com.epam.tat.realtor.steps_mob;

import com.epam.tat.realtor.pages_mob.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;

import java.time.Duration;

public class BasePageStep {
    protected AppiumDriver driver;
    protected BasePage basePage;

    public BasePageStep(AppiumDriver driver) {
        this.driver = driver;
        basePage = new BasePage(driver);
    }

    public void swipe(AppiumDriver driver) {
        new TouchAction(driver)
                .press(basePage.getBottomLeftWorkScreenCoordinates())
                .waitAction(new WaitOptions().withDuration(Duration.ofSeconds(3)))
                .moveTo(basePage.getTopLeftWorkScreenCoordinates())
                .release()
                .perform();
    }

}
