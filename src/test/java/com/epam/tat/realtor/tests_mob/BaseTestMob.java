package com.epam.tat.realtor.tests_mob;

import com.epam.tat.realtor.ConfigProperties;
import com.epam.tat.realtor.drivers.DriverMobile;
import com.epam.tat.realtor.steps_mob.HomePageStep;
import io.appium.java_client.AppiumDriver;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class BaseTestMob {
    protected AppiumDriver driver;
    protected HomePageStep homePageStepMob;

    /**
     * init specified WebDriver
     * configure driver implicitlyWaite timeouts
     * maximize browser window
     * open the homepage URL in browser
     */
    @BeforeClass(alwaysRun = true)
    void initPage() {
        driver = DriverMobile.ANDROIDDRIVER.getDriver();
        homePageStepMob = new HomePageStep(driver);
        driver.manage().timeouts().implicitlyWait(Integer.valueOf(ConfigProperties.getTestProperty("implicitlyWaitTime")), TimeUnit.SECONDS);
    }

//    /**
//     * close browser
//     */
//    @AfterSuite
//    void closeResources() {
//        if (driver != null) {
//            driver.quit();
//        }
//    }
}