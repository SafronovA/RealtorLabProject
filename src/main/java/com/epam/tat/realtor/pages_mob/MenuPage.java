package com.epam.tat.realtor.pages_mob;

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

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.ScrollView/android.widget.LinearLayout")
    private AndroidElement menuSideBar;
    @AndroidFindBy(id = "com.move.realtor:id/menu_sign_in")
    private AndroidElement signInButton;
    @AndroidFindBy(id = "com.move.realtor:id/menu_item_settings")
    private AndroidElement settingsButton;

    /**
     * click  button
     *
     * @return this page
     */
    public MenuPage clickSignInButton() {
        signInButton.click();
        return this;
    }

    public MenuPage clickSettingsButton() {
        waitUntilElementIsVisible(menuSideBar);
        settingsButton.click();
        return this;
    }

}
