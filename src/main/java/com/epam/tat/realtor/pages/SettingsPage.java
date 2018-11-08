package com.epam.tat.realtor.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class SettingsPage extends BasePage {

    public SettingsPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "com.move.realtor:id/user_name")
    private AndroidElement userName;
    @AndroidFindBy(id = "com.move.realtor:id/sign_out")
    private AndroidElement logOutButton;

    public void clickLogOut(){
        logOutButton.click();
    }

    public String getName(){
        return userName.getText();
    }

}
