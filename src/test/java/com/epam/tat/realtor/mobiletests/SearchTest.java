package com.epam.tat.realtor.mobiletests;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SearchTest extends BaseTest {
    @Test
    void search(){

        

        TouchAction touchAction = new TouchAction((MobileDriver) driver).press(PointOption.point(860,730)).perform();
        driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"in-app message close\"]")).click();
        driver.findElement(By.xpath("path\t//android.widget.TextView[@content-desc=\"Filter\"]"));
        driver.findElement(By.id("com.move.realtor:id/search_editor_tab_max_price")).sendKeys("50000");
        driver.findElement(By.id("com.move.realtor:id/address_text_view")).click();
        Assert.assertEquals(driver.findElement(By.id("com.move.realtor:id/number_of_results")).getText(),"0 Results");
        }
}
