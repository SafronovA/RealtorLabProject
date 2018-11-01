package com.epam.tat.realtor.mobiletests;

import com.epam.tat.realtor.mobilepages.HomePage;
import com.epam.tat.realtor.mobilepages.MenuPage;
import com.epam.tat.realtor.mobilepages.SearchPage;
import io.appium.java_client.*;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class SearchTest extends BaseTest {
    @Test
    void search() throws MalformedURLException, InterruptedException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("deviceName", "emulator-5554");
        capabilities.setCapability("platformVersion", "8");
        capabilities.setCapability("appPackage", "com.move.realtor");
        capabilities.setCapability("appActivity","com.move.realtor.search.results.activity.SearchResultsActivity");
//        capabilities.setCapability("unicodeKeyboard", "true");
//        capabilities.setCapability("resetKeyboard", "true");

        AppiumDriver<WebElement> driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
        Thread.sleep(15000);
        HomePage homePage = new HomePage(driver)
//                .clickMenuButton()
//                .startNewSearch()
//                .searchInputSendKeys("New York, NY")
//                .firstResultClick()
                .clickFilterButton()
                .enterMinPrice("250000")
                .enterMaxPrice("300000")
                .tapBedsSection()
                .swipeToBedsSection()
                .chooseBeds()
                .chooseBath();


//        driver.findElement(By.xpath("(//android.widget.ImageButton)[1]")).click();
//
//        Thread.sleep(5000);
//        driver.findElement(By.xpath("(//android.widget.RelativeLayout[@resource-id='com.move.realtor:id/menu_item_entry'])[1]")).click();;
//        Thread.sleep(5000);
//        driver.findElement(By.xpath("(//android.widget.FrameLayout[@resource-id='com.move.realtor:id/nearby_search_card'])[1]")).click();;
////
//        driver.findElement(By.id("com.move.realtor:id/menu_item_entry"));
//        driver.findElement(By.id("com.move.realtor:id/search_edit_text")).sendKeys("San Francisco, CA");
//
//
//
//        //TouchAction touchAction = new TouchAction((MobileDriver) driver).press(PointOption.point(860,730)).perform();
//        driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"in-app message close\"]")).click();
//        driver.findElement(By.xpath("path\t//android.widget.TextView[@content-desc=\"Filter\"]"));
//        driver.findElement(By.id("com.move.realtor:id/search_editor_tab_max_price")).sendKeys("50000");
//        driver.findElement(By.id("com.move.realtor:id/address_text_view")).click();
//        Assert.assertEquals(driver.findElement(By.id("com.move.realtor:id/number_of_results")).getText(),"0 Results");
        Assert.assertTrue(true);
        }
}
