package com.epam.tat.realtor.mobiletests;

import com.epam.tat.realtor.mobilesteps.HomePageStep;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class BaseTest {
    protected AppiumDriver<WebElement> driver;
    protected HomePageStep homePageStep;

    /**
     * init specified WebDriver
     * configure driver implicitlyWaite timeouts
     * desired capabilities
     * open the homepage URL in browser
     */
    @BeforeClass(alwaysRun = true)
   void initResources() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        BaseTest.setCapabilities(capabilities,"HuaweiP9");
        AppiumDriver<WebElement> driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
        homePageStep = new HomePageStep(driver);
           }
    /**
     * close browser
     */
    @AfterSuite
    void closeResources() {
        if (driver != null) {
            driver.quit();
        }
    }
    private static void setCapabilities(DesiredCapabilities capabilities, String filename) {
        String fileName = "src/main/resources/mobileproperties/"+filename+".properties";
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            stream.forEach(x->{
                String[] parts = x.split("=");
                capabilities.setCapability(parts[0],parts[1]);});
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
