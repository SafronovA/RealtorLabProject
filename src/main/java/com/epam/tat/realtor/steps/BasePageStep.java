package com.epam.tat.realtor.steps;

import com.epam.tat.realtor.ConfigProperties;
import org.openqa.selenium.WebDriver;

public class BasePageStep {
    protected WebDriver driver;

    public BasePageStep(WebDriver driver){
        this.driver=driver;
    }

    /**
     * go to start page
     * @return HomePageStep
     */
    public HomePageStep moveToHomePage(){
        driver.navigate().to(ConfigProperties.getTestProperty("url"));
        return new HomePageStep(driver);
    }

}
