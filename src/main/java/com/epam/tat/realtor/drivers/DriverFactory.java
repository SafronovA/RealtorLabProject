package com.epam.tat.realtor.drivers;

import com.epam.tat.realtor.ConfigProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public enum DriverFactory {
    CHROMEDRIVER
            {
                private WebDriver driver;
                /**
                 * return the single instance of ChromeDriver
                 * @return ChromeDriver
                 */
                public WebDriver getDriver(){
                    if(driver==null){
                        System.setProperty("webdriver.chrome.driver", ConfigProperties.getTestProperty("chromedriver"));
                        driver=new ChromeDriver();}
                        return driver;}
            },
    FIREFOXDRIVER
            {
                WebDriver driver;
                /**
                 * return the single instance of FirefoxDriver
                 * @return FirefoxDriver
                 */
                public WebDriver getDriver(){
                    if(driver==null){
                        System.setProperty("webdriver.gecko.driver", ConfigProperties.getTestProperty("geckodriver"));
                        driver=new FirefoxDriver();}
                    return driver;}
            };
            public abstract  WebDriver getDriver();
}
