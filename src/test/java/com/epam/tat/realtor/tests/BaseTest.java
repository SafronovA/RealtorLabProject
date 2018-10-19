package com.epam.tat.realtor.tests;

import com.epam.tat.realtor.ConfigProperties;
import com.epam.tat.realtor.drivers.DriverFactory;
import com.epam.tat.realtor.steps.HomePageStep;
import org.openqa.selenium.By;
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
    @BeforeSuite(alwaysRun = true)
    void initPage() {
        driver = DriverFactory.CHROMEDRIVER.getDriver();
        driver.manage().deleteAllCookies();
        homePageStep = new HomePageStep(driver);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        while (driver.findElements(By.xpath("//input[contains(@id,'downshift')]")).size()==0){
            System.out.println("New version of the home page. Page has to be  reloaded...");
            driver.manage().deleteAllCookies();
            driver.navigate().to(ConfigProperties.getTestProperty("url"));
        }
        driver.manage().timeouts()
                .implicitlyWait(Integer.valueOf(ConfigProperties.getTestProperty("implicitlyWaitTime")), TimeUnit.SECONDS);
    }

    @BeforeClass
    public void initDriver(){
        while (driver.findElements(By.xpath("//input[contains(@id,'downshift')]")).size()==0){
            System.out.println("New version of the home page. Page has to be  reloaded...");
            driver.manage().deleteAllCookies();
            driver.navigate().to(ConfigProperties.getTestProperty("url"));
        }
    }

    /**
     * close browser
     */
    @AfterSuite
    void closeResources() {
        if (driver != null) {
            driver.quit();
        }
    }
}