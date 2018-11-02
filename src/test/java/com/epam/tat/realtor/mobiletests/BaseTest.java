package com.epam.tat.realtor.mobiletests;

import com.epam.tat.realtor.web.steps.HomePageStep;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected AppiumDriver driver;

    /**
     * init specified WebDriver
     * configure driver implicitlyWaite timeouts
     * desired capabilities
     * open the homepage URL in browser
     */
    @BeforeClass(alwaysRun = true)
    void initPage() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("device","Android");
        capabilities.setCapability("deviceName", "Nexus5");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("app", "C://realtor.apk");
        capabilities.setCapability("appPackage", "com.move.realtor");
        capabilities.setCapability("appActivity", "com.move.realtor.search.results.activity.SearchResultsActivity");
        driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
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
