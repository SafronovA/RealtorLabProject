package com.epam.tat.realtor.listeners;

import com.epam.tat.realtor.drivers.DriverFactory;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.events.WebDriverEventListener;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;


public class WebDriverListener implements WebDriverEventListener {
    private final Logger logger = LogManager.getRootLogger();
    private String stepTestScreenshot = "0";
    private String title = "";
    private String currentData;
    SimpleDateFormat format = new SimpleDateFormat("dd.M.yyyy hh-mm-ss");


    /**
     * This action will be performed each time before Alert.accept()
     *
     * @param driver
     */
    public void beforeAlertAccept(WebDriver driver) {

    }

    /**
     * This action will be performed each time after Alert.accept()
     *
     * @param driver
     */
    public void afterAlertAccept(WebDriver driver) {

    }

    /**
     * This action will be performed each time before Alert.dismiss()
     *
     * @param driver
     */
    public void afterAlertDismiss(WebDriver driver) {

    }

    /**
     * This action will be performed each time after Alert.dismiss()
     *
     * @param driver
     */
    public void beforeAlertDismiss(WebDriver driver) {

    }

    /**
     * Called before get(String url) respectively navigate().to(String url).
     *
     * @param url
     * @param driver
     */
    public void beforeNavigateTo(String url, WebDriver driver) {

    }

    /**
     * Called after get(String url) respectively navigate().to(String url).
     *
     * @param url
     * @param driver
     */
    public void afterNavigateTo(String url, WebDriver driver) {
    }

    /**
     * Called before navigate().back().
     *
     * @param driver
     */
    public void beforeNavigateBack(WebDriver driver) {

    }

    /**
     * Called after navigate().back().
     *
     * @param driver
     */
    public void afterNavigateBack(WebDriver driver) {

    }

    /**
     * Called before navigate().forward().
     *
     * @param driver
     */
    public void beforeNavigateForward(WebDriver driver) {

    }

    /**
     * Called after navigate().forward().
     *
     * @param driver
     */
    public void afterNavigateForward(WebDriver driver) {

    }

    /**
     * Called before navigate().refresh().
     *
     * @param driver
     */
    public void beforeNavigateRefresh(WebDriver driver) {

    }

    /**
     * Called after navigate().refresh().
     *
     * @param driver
     */
    public void afterNavigateRefresh(WebDriver driver) {

    }

    /**
     * Called before WebDriver.findElement(...), or WebDriver.findElements(...),
     * or WebElement.findElement(...), or WebElement.findElements(...).
     *
     * @param by
     * @param element
     * @param driver
     */
    public void beforeFindBy(By by, WebElement element, WebDriver driver) {
    }

    /**
     * Called after WebDriver.findElement(...), or WebDriver.findElements(...),
     * or WebElement.findElement(...), or WebElement.findElements(...).
     *
     * @param by
     * @param element
     * @param driver
     */
    public void afterFindBy(By by, WebElement element, WebDriver driver) {
    }

    /**
     * Called before WebElement.click().
     *
     * @param element
     * @param driver
     */
    public void beforeClickOn(WebElement element, WebDriver driver) {

    }

    /**
     * Called after WebElement.click(), take screenshot and write to logger current title, if title was change.
     *
     * @param element
     * @param driver
     */
    public void afterClickOn(WebElement element, WebDriver driver) {
        if (!driver.getTitle().equals(title)) {
            title = driver.getTitle();
            logger.info("Page " + title + " opened");
        }
        screenshot();
    }

    /**
     * Called before WebElement.clear(), WebElement.sendKeys(...).
     *
     * @param element
     * @param driver
     * @param keysToSend
     */
    public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {

    }

    /**
     * Called after WebElement.clear(), WebElement.sendKeys(...)}.
     *
     * @param element
     * @param driver
     * @param keysToSend
     */
    public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {

    }

    /**
     * Called before RemoteWebDriver.executeScript(java.lang.String, java.lang.Object[])
     *
     * @param script
     * @param driver
     */
    public void beforeScript(String script, WebDriver driver) {

    }

    /**
     * Called after RemoteWebDriver.executeScript(java.lang.String, java.lang.Object[]).
     *
     * @param script
     * @param driver
     */
    public void afterScript(String script, WebDriver driver) {

    }

    @Override
    public void beforeSwitchToWindow(String s, WebDriver webDriver) {

    }

    @Override
    public void afterSwitchToWindow(String s, WebDriver webDriver) {

    }

    /**
     * Called whenever an exception would be thrown.
     *
     * @param throwable
     * @param driver
     */
    public void onException(Throwable throwable, WebDriver driver) {

    }

    @Override
    public <X> void beforeGetScreenshotAs(OutputType<X> outputType) {

    }

    @Override
    public <X> void afterGetScreenshotAs(OutputType<X> outputType, X x) {

    }

    @Override
    public void beforeGetText(WebElement webElement, WebDriver webDriver) {

    }

    @Override
    public void afterGetText(WebElement webElement, WebDriver webDriver, String s) {

    }

    /**
     * Take screenshot and put it to TestListener.testName - folder / currentData(when test was started) / stepTestScreenshot .png
     */
    public void screenshot() {
        File screenCapture = ((TakesScreenshot) DriverFactory.CHROMEDRIVER
                .getDriver())
                .getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenCapture, new File(".//target/screenshots/"  + "/"
                    + currentData + "/" + stepTestScreenshot + ".png"));
            if (!stepTestScreenshot.equals("FAIL"))
                stepTestScreenshot = String.valueOf(Integer.valueOf(stepTestScreenshot) + 1);
        } catch (IOException e) {
            System.out.println("Failed to save screenshot: " + e.getLocalizedMessage());
        }
    }

    /**
     * Set stepTestScreenshot new name
     *
     * @param stepTestScreenshot
     */
    public void setStepTestScreenshot(String stepTestScreenshot) {
        this.stepTestScreenshot = stepTestScreenshot;
    }
}
