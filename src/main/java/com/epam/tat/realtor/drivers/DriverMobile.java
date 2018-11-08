package com.epam.tat.realtor.drivers;

import com.epam.tat.realtor.ConfigProperties;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public enum  DriverMobile {
    ANDROIDDRIVER {
        private AppiumDriver driver;

        /**
         * return the single instance of ChromeDriver
         * @return ChromeDriver
         */
        public AppiumDriver getDriver() {
            if (driver == null) {
                DesiredCapabilities caps = new DesiredCapabilities();
                caps.setCapability("deviceName", ConfigProperties.getTestProperty("deviceName"));
                caps.setCapability("udid", ConfigProperties.getTestProperty("udid"));
                caps.setCapability("platformName", ConfigProperties.getTestProperty("platformName"));
                caps.setCapability("platformVersion", ConfigProperties.getTestProperty("platformVersion"));
                caps.setCapability("skipUnlock", ConfigProperties.getTestProperty("skipUnlock"));
                caps.setCapability("app", ConfigProperties.getTestProperty("app"));
                caps.setCapability("appPackage", ConfigProperties.getTestProperty("appPackage"));
                caps.setCapability("appActivity", ConfigProperties.getTestProperty("appActivity"));
                caps.setCapability("noReset", ConfigProperties.getTestProperty("noReset"));
                try {
                    driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), caps);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }
            return driver;
        }

        public void quitDriver() {
            if (driver != null){
                driver.quit();
            }
            driver = null;
        }
    };

    public abstract AppiumDriver getDriver();
    public abstract void quitDriver();

}
