package com.epam.tat.realtor.bddrun;

import com.epam.tat.realtor.ConfigProperties;
import com.epam.tat.realtor.bddsteps.ProfileBDDSteps;
import com.epam.tat.realtor.drivers.DriverFactory;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class Hook {
    protected WebDriver driver;

    /**
     * init specified WebDriver
     * configure driver implicitlyWaite timeouts
     * maximize browser window
     * open the homepage URL in browser
     */
    @Before
    public void initDriver() {
        driver = DriverFactory.CHROMEDRIVER.getDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.navigate().to(ConfigProperties.getTestProperty("url"));
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        while (driver.findElements(By.xpath("//input[contains(@id,'downshift')]")).size()==0){
            System.out.println("New version of the home page. Page has to be  reloaded...");
            driver.manage().deleteAllCookies();
            driver.navigate().to(ConfigProperties.getTestProperty("url"));
        }
        driver.manage().timeouts()
                .implicitlyWait(Integer.valueOf(ConfigProperties.getTestProperty("implicitlyWaitTime")), TimeUnit.SECONDS);
        new ProfileBDDSteps().init(driver);

    }

    @After
    public void closeDriver(){
        DriverFactory.CHROMEDRIVER.quitDriver();
    }

}
