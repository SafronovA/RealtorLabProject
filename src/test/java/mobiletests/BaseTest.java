package mobiletests;

import com.epam.tat.realtor.steps.HomePageStep;
import com.epam.tat.realtor.util.ConfigProperties;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    protected AppiumDriver driver;
    protected HomePageStep homePageStep;

    @BeforeClass(alwaysRun = true)
    void initPage() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        ConfigProperties.setAndroidDeviceCapabilities(capabilities,"Nexus5");
        driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        homePageStep = new HomePageStep(driver);
    }

    @AfterSuite
    void closeResources() {
        if (driver != null) {
            driver.quit();
        }
    }
}
