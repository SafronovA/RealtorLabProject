package com.epam.tat.realtor.drivers;

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

//    public static AppiumDriver getDriver() {
//        if (driver == null) {
//            DesiredCapabilities caps = new DesiredCapabilities();
//            caps.setCapability("deviceName", ConfigProperties.getTestProperty("deviceName"));
//            caps.setCapability("udid", ConfigProperties.getTestProperty("udid"));
//            caps.setCapability("platformName", ConfigProperties.getTestProperty("platformName"));
//            caps.setCapability("platformVersion", ConfigProperties.getTestProperty("platformVersion"));
//            caps.setCapability("skipUnlock", ConfigProperties.getTestProperty("skipUnlock"));
//            caps.setCapability("app", ConfigProperties.getTestProperty("app"));
//            caps.setCapability("appPackage", ConfigProperties.getTestProperty("appPackage"));
//            caps.setCapability("appActivity", ConfigProperties.getTestProperty("appActivity"));
//            caps.setCapability("noReset", ConfigProperties.getTestProperty("noReset"));
//            try {
//                driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), caps);
//            } catch (MalformedURLException e) {
//                e.printStackTrace();
//            }
//        }
//        return driver;
//    }


    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
        driver = null;
    }
}

//public class DriverMobile {
//    private DriverMobile() {
//    }
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
//            ConfigProperties.setAndroidDeviceCapabilities(capabilities, "farm");
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
