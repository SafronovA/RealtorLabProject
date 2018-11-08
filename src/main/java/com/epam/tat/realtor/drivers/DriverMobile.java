package com.epam.tat.realtor.drivers;

import com.epam.tat.realtor.ConfigProperties;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

import static java.lang.String.format;

public enum DriverMobile {
    ANDROIDDRIVER {
        private AppiumDriver driver;

        /**
         * return the single instance of ChromeDriver
         * @return ChromeDriver
         */
        public AppiumDriver getDriver() {
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

        public void quitDriver() {
            if (driver != null) {
                driver.quit();
            }
            driver = null;
        }
    };

    public abstract AppiumDriver getDriver();

    public abstract void quitDriver();

}
