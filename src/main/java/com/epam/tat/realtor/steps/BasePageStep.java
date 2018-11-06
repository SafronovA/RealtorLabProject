package com.epam.tat.realtor.steps;

import com.epam.tat.realtor.pages.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.WaitOptions;

import java.time.Duration;
import java.util.List;

public class BasePageStep {

    protected AppiumDriver driver;
    protected BasePage basePage;

    public BasePageStep(AppiumDriver driver){
        this.driver = driver;
        basePage = new BasePage(driver);
    }

    public void swipeUntilElementBecomeVisible(AppiumDriver driver, List<AndroidElement> element) {
        while (element.isEmpty()){
            swipe(driver);
        }
    }

    public void swipe(AppiumDriver driver) {
        new TouchAction(driver)
                .press(basePage.getBottomCenterWorkScreenCoordinates())
                .waitAction(new WaitOptions().withDuration(Duration.ofSeconds(3)))
                .moveTo(basePage.getTopCenterWorkScreenCoordinates())
                .release()
                .perform();
    }


}
