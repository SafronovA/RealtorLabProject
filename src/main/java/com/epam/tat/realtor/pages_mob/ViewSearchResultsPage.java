package com.epam.tat.realtor.pages_mob;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ViewSearchResultsPage extends BasePage {

    public ViewSearchResultsPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.move.realtor:id/address_text_view']")
    private List<AndroidElement> houseAddressesFromScreen;
    @AndroidFindBy(xpath = "//*[@text='Expand Search Area']")
    private List<AndroidElement> expandSearchAreaButton;

    public List<AndroidElement> getHouseAddressesFromScreen(){
        return houseAddressesFromScreen;
    }

    public List<AndroidElement> getExpandSearchAreaButton() {
        return expandSearchAreaButton;
    }
}
