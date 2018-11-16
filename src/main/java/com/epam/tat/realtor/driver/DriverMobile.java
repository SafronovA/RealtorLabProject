package com.epam.tat.realtor.driver;

import com.epam.tat.realtor.util.ConfigProperties;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

import static java.lang.String.format;

public class DriverMobile {
    private DriverMobile() {
    }

    private static AppiumDriver driver;

    /**
     * return the single instance of ChromeDriver
     *
     * @return ChromeDriver
     */
    public static AppiumDriver getDriver() {
        if (driver == null) {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            ConfigProperties.setAndroidDeviceCapabilities(capabilities, "farm");
            try {
                driver = new AndroidDriver(
                        new URL(format("http://%s:%s@%s/wd/hub",
                                ConfigProperties.getTestProperty("project_name"),
                                ConfigProperties.getTestProperty("api_key"),
                                ConfigProperties.getTestProperty("appium_hub"))),
                        capabilities);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
        return driver;
    }

}
