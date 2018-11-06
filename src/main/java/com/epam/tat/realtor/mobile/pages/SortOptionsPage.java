package com.epam.tat.realtor.mobile.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class SortOptionsPage extends BasePage {

    @AndroidFindBy(xpath = "(//android.widget.CheckedTextView[@resource-id=\"android:id/text1\"])[2]")
    private AndroidElement lowToHighSortOption;

    public SortOptionsPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public ViewSearchResultsPage selectLowToHighSortOption(){
        lowToHighSortOption.click();
        return new ViewSearchResultsPage(driver);
    }

}
