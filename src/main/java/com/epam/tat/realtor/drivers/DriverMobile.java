package com.epam.tat.realtor.drivers;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
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
