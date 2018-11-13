package com.epam.tat.realtor.tests;

import com.epam.tat.realtor.util.ConfigProperties;
import com.epam.tat.realtor.drivers.DriverMobile;
import com.epam.tat.realtor.steps.MainPageStep;
import io.appium.java_client.AppiumDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected AppiumDriver driver;
    protected MainPageStep mainPageStep;

    /**
     * init specified WebDriver
     * configure driver implicitlyWaite timeouts
     * maximize browser window
     * open the homepage URL in browser
     */
    @BeforeClass(alwaysRun = true)
    void initPage() {
        driver = DriverMobile.getDriver();
        mainPageStep = new MainPageStep(driver);
        driver.manage().timeouts().implicitlyWait(Integer.valueOf(ConfigProperties.getTestProperty("driverWaitTime")), TimeUnit.SECONDS);
    }

    /**
     * close browser
     */
    @AfterClass
    void closeResources() {
        if (driver != null) {
            driver.resetApp();
        }
    }
}