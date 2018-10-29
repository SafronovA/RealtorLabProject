package com.epam.tat.realtor.drivers;

import com.epam.tat.realtor.ConfigProperties;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public enum DriverFactory {
    CHROMEDRIVER {
        private WebDriver driver;

        /**
         * return the single instance of ChromeDriver
         * @return ChromeDriver
         */
        public WebDriver getDriver() {
            if (driver == null) {
                System.setProperty("webdriver.chrome.driver", ConfigProperties.getTestProperty("chromedriver"));
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.setCapability("applicationName", "safronau_node");
                try {
                    driver = new RemoteWebDriver(new URL(ConfigProperties.getTestProperty("remoteURL")), chromeOptions);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }
            return driver;
        }
    },
    FIREFOXDRIVER {
        private WebDriver driver;

        /**
         * return the single instance of FirefoxDriver
         * @return FirefoxDriver
         */
        public WebDriver getDriver() {
            if (driver == null) {
                System.setProperty("webdriver.gecko.driver", ConfigProperties.getTestProperty("geckodriver"));
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                try {
                    driver = new RemoteWebDriver(new URL(ConfigProperties.getTestProperty("remoteURL")), firefoxOptions);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }
            return driver;
        }
    };

    public abstract WebDriver getDriver();
}
