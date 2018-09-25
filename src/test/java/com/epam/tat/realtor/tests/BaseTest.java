package com.epam.tat.realtor.tests;

import com.epam.tat.realtor.ConfigProperties;
import com.epam.tat.realtor.drivers.DriverFactory;
import com.epam.tat.realtor.steps.HomePageStep;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected WebDriver driver;
    protected HomePageStep homePageStep;

    /**
     * init specified WebDriver
     * configure driver implicitlyWaite timeouts
     */
    @BeforeSuite
    void initResources(){
        driver = DriverFactory.FIREFOXDRIVER.getDriver();
        driver.manage().timeouts().implicitlyWait(Integer.valueOf(ConfigProperties.getTestProperty("implicitlyWaitTime")), TimeUnit.SECONDS);
        homePageStep = new HomePageStep(driver);
    }

    /**
     * maximize browser window
     * open the homepage URL in browser
     */

    @BeforeTest
    void initPage(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.navigate().to(ConfigProperties.getTestProperty("url"));
    }

    /**
     * maximize browser window
     * open the homepage URL in browser
     */
    @AfterSuite
    void closeResources(){
        driver.quit();
    }
}