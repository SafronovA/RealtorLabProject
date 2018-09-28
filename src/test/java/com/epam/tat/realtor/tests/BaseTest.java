package com.epam.tat.realtor.tests;

import com.epam.tat.realtor.ConfigProperties;
import com.epam.tat.realtor.drivers.DriverFactory;
import com.epam.tat.realtor.steps.HomePageStep;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected WebDriver driver;
    protected HomePageStep homePageStep;

    /**
     * init specified WebDriver
     * configure driver implicitlyWaite timeouts
     * maximize browser window
     * open the homepage URL in browser
     */

    @BeforeClass(alwaysRun = true)
    void initPage(){
        driver = DriverFactory.CHROMEDRIVER.getDriver();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Integer.valueOf(ConfigProperties.getTestProperty("implicitlyWaitTime")), TimeUnit.SECONDS);
        driver.navigate().to(ConfigProperties.getTestProperty("url"));
        driver.manage().window().maximize();
        homePageStep = new HomePageStep(driver);
    }

    /**
     * close browser
     */
    @AfterSuite
    void closeResources(){
        driver.close();
    }
}