package com.epam.tat.realtor.bddtests;

import com.epam.tat.realtor.drivers.DriverFactory;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

@CucumberOptions(strict = true, features = "src/test/resources/features/SearchPageActions.feature", glue = {"com.epam.tat.realtor.bddsteps"}
        ,tags = {"@FoundHouses"}
)
public class SearchPageActionsTest extends AbstractTestNGCucumberTests {
    private WebDriver driver;

    @BeforeClass
    public void initResources(){
        driver = DriverFactory.CHROMEDRIVER.getDriver();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }
    @AfterClass
    public void closeResources(){
        driver.quit();
    }
}
