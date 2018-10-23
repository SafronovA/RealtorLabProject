package com.epam.tat.realtor.bddtests;

import com.epam.tat.realtor.ConfigProperties;
import com.epam.tat.realtor.drivers.DriverFactory;
import com.epam.tat.realtor.steps.HomePageStep;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

@CucumberOptions(strict = true, features = "src/test/resources/features/SearchPageActions.feature", glue = {"com.epam.tat.realtor.bddsteps"})
public class MapMarks extends AbstractTestNGCucumberTests {
    protected WebDriver driver;
    protected HomePageStep homePageStep;
    @BeforeClass
    public void initResources(){
        driver = DriverFactory.CHROMEDRIVER.getDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.navigate().to(ConfigProperties.getTestProperty("url"));
        homePageStep = new HomePageStep(driver);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
    @AfterClass
    void closeResources(){
        driver.quit();
    }


}
