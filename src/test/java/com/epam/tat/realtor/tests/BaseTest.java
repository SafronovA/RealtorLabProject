package com.epam.tat.realtor.tests;

import com.epam.tat.realtor.driver.DriverMobile;
import com.epam.tat.realtor.steps.MainPageStep;
import com.epam.tat.realtor.util.ConfigProperties;
import io.appium.java_client.AppiumDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected AppiumDriver driver;
    protected MainPageStep mainPageStep;

    @BeforeClass(alwaysRun = true)
    void initPage() {
        driver = DriverMobile.getDriver();
        mainPageStep = new MainPageStep(driver);
        driver.manage().timeouts().implicitlyWait(Integer.valueOf(ConfigProperties.getTestProperty("driverWaitTime")), TimeUnit.SECONDS);
    }

    @AfterClass
    void closeResources() {
        if (driver != null) {
            driver.resetApp();
        }
    }
}