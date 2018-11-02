package com.epam.tat.realtor.mobilesteps;

import com.epam.tat.realtor.mobilepages.BasePage;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

public class BasePageStep {
    protected AppiumDriver<WebElement> driver;
    protected BasePage basePage;

    public BasePageStep(AppiumDriver<WebElement> driver) {
        this.driver = driver;
        basePage = new BasePage(driver);
    }
}
