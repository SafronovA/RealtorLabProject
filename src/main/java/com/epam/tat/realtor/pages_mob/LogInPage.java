package com.epam.tat.realtor.pages_mob;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class LogInPage extends BasePage {

    public LogInPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "com.move.realtor:id/email_edit_text")
    private AndroidElement emailInput;
    @AndroidFindBy(id = "com.move.realtor:id/password_edit_text")
    private AndroidElement passInput;
    @AndroidFindBy(id = "com.move.realtor:id/bottom_signup_login")
    private AndroidElement submitButton;

    public LogInPage enterEmail(String email) {
        emailInput.sendKeys(email);
        return this;
    }

    public LogInPage enterPass(String pass) {
        passInput.sendKeys(pass);
        return this;
    }

    public LogInPage clickSubmitButton() {
        submitButton.click();
        return this;
    }
}
