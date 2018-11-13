package com.epam.tat.realtor.drivers;

import com.epam.tat.realtor.util.ConfigProperties;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static java.lang.String.format;

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
            capabilities.setCapability("platform_name", ConfigProperties.getTestProperty("platform_name"));
            capabilities.setCapability("platform_version", ConfigProperties.getTestProperty("platform_version"));
            capabilities.setCapability("device_name", ConfigProperties.getTestProperty("device_name"));
            capabilities.setCapability("appPackage", ConfigProperties.getTestProperty("appPackage"));
            capabilities.setCapability("appActivity", ConfigProperties.getTestProperty("appActivity"));
            capabilities.setCapability("udid", ConfigProperties.getTestProperty("udid"));
            capabilities.setCapability("unicodeKeyboard", ConfigProperties.getTestProperty("unicodeKeyboard"));
            capabilities.setCapability("resetKeyboard", ConfigProperties.getTestProperty("resetKeyboard"));

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

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
        driver = null;
    }
}

//public class DriverMobile {
//    private DriverMobile(){}
//
//    private static AppiumDriver driver;
//
//    /**
//     * return the single instance of ChromeDriver
//     *
//     * @return ChromeDriver
//     */
//    public static AppiumDriver getDriver() {
//        if (driver == null) {
//            DesiredCapabilities capabilities = new DesiredCapabilities();
//            ConfigProperties.setAndroidDeviceCapabilities(capabilities, "HuaweiP9");
//            try {
//                driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
//            } catch (MalformedURLException e) {
//                e.printStackTrace();
//            }
//            driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
//        }
//        return driver;
//    }
//}