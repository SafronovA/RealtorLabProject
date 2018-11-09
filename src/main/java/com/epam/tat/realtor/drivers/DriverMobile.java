package com.epam.tat.realtor.drivers;

import com.epam.tat.realtor.util.ConfigProperties;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class DriverMobile {
    private DriverMobile(){}

    private static AppiumDriver driver;

    /**
     * return the single instance of ChromeDriver
     *
     * @return ChromeDriver
     */
    public static AppiumDriver getDriver() {
        if (driver == null) {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            ConfigProperties.setAndroidDeviceCapabilities(capabilities, "Nexus5");
            try {
                driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }
        return driver;
    }
}
