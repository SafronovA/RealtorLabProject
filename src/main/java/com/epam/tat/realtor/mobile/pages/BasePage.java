package com.epam.tat.realtor.mobile.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    protected AppiumDriver driver;
    private WebDriverWait webDriverWait;
    private PointOption topCenterWorkScreenCoordinates;
    private PointOption bottomCenterWorkScreenCoordinates;

    @AndroidFindBy(className = "android.widget.FrameLayout")
    protected static AndroidElement workScreen;

    public BasePage(AppiumDriver driver){
        this.driver = driver;
        webDriverWait = new WebDriverWait(driver, 20);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        generateCoordinates();
    }

    public PointOption getTopCenterWorkScreenCoordinates() {
        return topCenterWorkScreenCoordinates;
    }

    public PointOption getBottomCenterWorkScreenCoordinates() {
        return bottomCenterWorkScreenCoordinates;
    }

    private void generateCoordinates() {
        final double DELTA = 0.1;
        int commonX = workScreen.getRect().width/2;
        int topY = (int)(workScreen.getRect().getHeight() * DELTA);
        int bottomY = (int)(workScreen.getRect().getHeight() * (1 - DELTA));

        topCenterWorkScreenCoordinates = new PointOption().withCoordinates(commonX, topY);
        bottomCenterWorkScreenCoordinates = new PointOption().withCoordinates(commonX, bottomY);
    }


    public void waitUntilElementIsVisible(AndroidElement webElement) {
        webDriverWait.until(ExpectedConditions.visibilityOf(webElement));
    }

    public void waitUntilElementIsClickable(AndroidElement webElement) {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

}
