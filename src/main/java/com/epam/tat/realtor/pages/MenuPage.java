package com.epam.tat.realtor.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MenuPage extends BasePage{

    public MenuPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(className = "android.widget.LinearLayout")
    private AndroidElement menuSideBar;
    @AndroidFindBy(id = "com.move.realtor:id/menu_sign_in")
    private AndroidElement signInButton;
    @AndroidFindBy(id = "com.move.realtor:id/menu_item_settings")
    private List<AndroidElement> settingsButton;

    /**
     * click  button
     *
     * @return this page
     */
    public SignInPage clickSignInButton() {
        signInButton.click();
        return new SignInPage(driver);
    }

    public SettingsPage clickSettingsButton() {
        waitUntilElementIsVisible(menuSideBar);
        settingsButton.get(0).click();
        return new SettingsPage(driver);
    }

    public List<AndroidElement> getSettingsButton() {
        return settingsButton;
    }

}
