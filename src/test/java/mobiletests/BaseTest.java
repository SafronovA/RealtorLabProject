package mobiletests;

import com.epam.tat.realtor.drivers.DriverMobile;
import com.epam.tat.realtor.steps.HomePageStep;
import io.appium.java_client.AppiumDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    protected AppiumDriver driver;
    protected HomePageStep homePageStep;

    @BeforeClass(alwaysRun = true)
    void initPage() {
        driver = DriverMobile.getDriver();
        homePageStep = new HomePageStep(driver);
    }

    @AfterSuite
    void closeResources() {
        if (driver != null) {
            driver.quit();
        }
    }
}
