package com.epam.tat.realtor.pages_mob;

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
    @AndroidFindBy(id = "com.move.realtor:id/sign_in_button")
    private AndroidElement logInButton;

    public String getName(){
        return userName.getText();
    }

    public void clickLogOut(){
        logInButton.click();
    }

}
