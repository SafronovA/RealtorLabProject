package com.epam.tat.realtor.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class HousePage extends BasePage {

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.move.realtor:id/address_text_view']")
    private AndroidElement houseAddress;
    @AndroidFindBy(xpath = "(//android.widget.ImageButton)[3]")
    private AndroidElement goBackButton;

    public HousePage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public String getHouseAddress(){
        return houseAddress.getText();
    }

    public ViewSearchResultsPage clickGoBackButton(){
        goBackButton.click();
        return new ViewSearchResultsPage(driver);
    }

}
