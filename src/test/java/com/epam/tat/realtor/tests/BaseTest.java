package com.epam.tat.realtor.tests;

import com.epam.tat.realtor.ConfigProperties;
import com.epam.tat.realtor.drivers.DriverFactory;
import com.epam.tat.realtor.steps.HomePageStep;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import org.openqa.selenium.NoSuchElementException;

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
    void initPage() {
        driver = DriverFactory.CHROMEDRIVER.getDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.navigate().to(ConfigProperties.getTestProperty("url"));
        homePageStep = new HomePageStep(driver);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        boolean isOldPage = true;
        while (isOldPage) {
            try {
                isOldPage = false;
                driver.findElement(By.xpath("//*[@id='downshift-0-input']"));
            } catch (NoSuchElementException e) {
                System.out.println("New version of the home page. Page has to be  reloaded...");
                isOldPage = true;
                driver.manage().deleteAllCookies();
                driver.navigate().to(ConfigProperties.getTestProperty("url"));
            } finally {
                driver.manage()
                        .timeouts()
                        .implicitlyWait(Integer.valueOf(ConfigProperties.getTestProperty("implicitlyWaitTime")), TimeUnit.SECONDS);
            }
        }
    }

    /**
     * close browser
     */

    @AfterSuite
    void closeResources() {
        driver.quit();
    }

}