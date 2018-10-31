package com.epam.tat.realtor.mobiletests;

import com.epam.tat.realtor.ConfigProperties;
import com.epam.tat.realtor.drivers.DriverFactory;
import com.epam.tat.realtor.steps.HomePageStep;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected WebDriver driver;
    protected HomePageStep homePageStep;

    /**
     * init specified WebDriver
     * configure driver implicitlyWaite timeouts
     * desired capabilities
     * open the homepage URL in browser
     */
    @BeforeClass(alwaysRun = true)
    void initPage() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("deviceName", "emulator-5554");
        capabilities.setCapability("platformVersion", "9");
        capabilities.setCapability("appPackage", "com.move.realtor");
        capabilities.setCapability("appActivity","com.move.realtor.search.results.activity.SearchResultsActivity");
//        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
//        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"emulator-5554");
//        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9");
//        capabilities.setCapability(MobileCapabilityType.APP, "C:/Users/Siarhei_Volchak/desktop/mobile/realtor.apk");
//        // capabilities.setCapability(MobileCapabilityType.P);
//        // capabilities.setCapability("app", app.getAbsolutePath());
//        capabilities.setCapability("appPackage", "com.move.realtor");
//        capabilities.setCapability("appActivity","com.move.realtor.search.results.activity.SearchResultsActivity");
        WebDriver driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
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
