package com.epam.tat.realtor.mobiletests;

import com.epam.tat.realtor.mobilesteps.HomePageStep;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;
import static java.lang.String.format;

public class MobileFarm {

    protected HomePageStep homePageStep;

    private static final String PROJECT_NAME = "EPM-TSTF";

    private static final String API_KEY = "815503fd-0af4-420a-ae71-b6a112d82682";
    private static final String APPIUM_HUB = "mobilecloud.epam.com:8080";
    private static final String PLATFORM_NAME = "Android";
    private static final String PLATFORM_VERSION = "7.0";
    private static final String DEVICE_NAME = "SAMSUNG SM-T813";

    private final DesiredCapabilities capabilities;

    private AppiumDriver driver = null;

    public MobileFarm() {
        capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", PLATFORM_NAME);
        capabilities.setCapability("platformVersion", PLATFORM_VERSION);
        capabilities.setCapability("deviceName", DEVICE_NAME);
        capabilities.setCapability("udid","68d46040051cd756");
        capabilities.setCapability("appPackage","com.move.realtor");
        capabilities.setCapability("appActivity","com.move.realtor.search.results.activity.SearchResultsActivity");
    }

    @BeforeClass
    public void before() throws MalformedURLException {
        driver = new AndroidDriver(
                new URL(format("http://%s:%s@%s/wd/hub", PROJECT_NAME, API_KEY, APPIUM_HUB)), capabilities);
        driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
        homePageStep = new HomePageStep(driver);

//        // For devices with low performance
//        driver.manage().timeouts()
//                .pageLoadTimeout(5, TimeUnit.MINUTES)
//                .implicitlyWait(90, TimeUnit.SECONDS);
    }
}
