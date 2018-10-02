package com.epam.tat.realtor.steps;

import com.epam.tat.realtor.pages.BasePage;
import org.openqa.selenium.WebDriver;

public class BasePageStep {
    protected WebDriver driver;
    private BasePage basePage;

    public BasePageStep(WebDriver driver) {
        this.driver = driver;
        basePage = new BasePage(driver);
    }

}
