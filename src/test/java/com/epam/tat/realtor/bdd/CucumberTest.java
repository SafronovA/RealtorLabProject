package com.epam.tat.realtor.bdd;

import com.epam.tat.realtor.ConfigProperties;
import com.epam.tat.realtor.drivers.DriverFactory;
import com.epam.tat.realtor.steps.HomePageStep;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

@CucumberOptions(strict = true, features = "src/test/resources/bdd_features/mapMarks.feature", glue = {"com.epam.tat.realtor.bdd_steps"})
public class CucumberTest extends AbstractTestNGCucumberTests {
    protected WebDriver driver;
    protected HomePageStep homePageStep;
    @BeforeClass
    public void initResources(){
        driver = DriverFactory.CHROMEDRIVER;
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
