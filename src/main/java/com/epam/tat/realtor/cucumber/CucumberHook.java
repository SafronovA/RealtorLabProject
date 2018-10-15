package com.epam.tat.realtor.cucumber;

import com.epam.tat.realtor.ConfigProperties;
import com.epam.tat.realtor.drivers.DriverFactory;
import com.epam.tat.realtor.steps.HomePageStep;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class CucumberHook {

    protected WebDriver driver;
    protected HomePageStep homePageStep;

    @Before
    public void beforeScenario(){
        driver = DriverFactory.CHROMEDRIVER.getDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.navigate().to(ConfigProperties.getTestProperty("url"));
        homePageStep = new HomePageStep(driver);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        boolean isOldPage = true;
        while (isOldPage) {
            try {
                isOldPage = false;
                driver.findElement(By.xpath("//*[@id='downshift-0-input']"));
            } catch (NoSuchElementException e) {
                System.out.println("New version of the home page. Page has to be  reloaded...");
                isOldPage = true;
                driver.manage().deleteAllCookies();
                driver.navigate().to(ConfigProperties.getTestProperty("url"));
            } finally {
                driver.manage()
                        .timeouts()
                        .implicitlyWait(Integer.valueOf(ConfigProperties.getTestProperty("implicitlyWaitTime")), TimeUnit.SECONDS);
            }
        }
    }

    @After
    public void afterScenario(){
        driver.close();
    }

}
