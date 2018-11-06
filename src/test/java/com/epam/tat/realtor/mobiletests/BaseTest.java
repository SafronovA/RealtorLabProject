package com.epam.tat.realtor.mobiletests;

import com.epam.tat.realtor.mobile.steps.HomePageStep;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    protected AppiumDriver driver;
    protected HomePageStep homePageStep;

    /**
     * init specified WebDriver
     * configure driver implicitlyWaite timeouts
     * desired capabilities
     * open the homepage URL in browser
     */
    @BeforeClass(alwaysRun = true)
    void initPage() throws MalformedURLException {
        File app = new File("C:/Users/Aliaksei_Safronau", "Realtor.apk");
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "Mate");
        caps.setCapability("udid", "FFY5T18119005277"); //DeviceId from "adb devices" command
        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", "8.0.0");
        caps.setCapability("skipUnlock", "true");
        caps.setCapability("app", app.getAbsolutePath());
        caps.setCapability("appPackage", "com.move.realtor");
        caps.setCapability("appActivity", "com.move.realtor.search.results.activity.SearchResultsActivity");
        caps.setCapability("noReset", "false");
        driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        homePageStep = new HomePageStep(driver);
    }

//    /**
//     * close browser
//     */
//    @AfterSuite
//    void closeResources() {
//        if (driver != null) {
//            driver.quit();
//        }
//    }
}
