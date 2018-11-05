package com.epam.tat.realtor.pages_mob;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class MortgageCalculatorPage extends BasePage {

    public MortgageCalculatorPage(AppiumDriver driver){
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }


}
