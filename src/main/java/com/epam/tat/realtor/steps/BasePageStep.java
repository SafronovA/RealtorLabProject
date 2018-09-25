package com.epam.tat.realtor.steps;

import org.openqa.selenium.WebDriver;

public class BasePageStep {
    protected WebDriver driver;

    public BasePageStep(WebDriver driver){
        this.driver=driver;
    }
}
