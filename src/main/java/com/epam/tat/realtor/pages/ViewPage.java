package com.epam.tat.realtor.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ViewPage extends BasePage {
    public ViewPage(AppiumDriver<WebElement> driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    @AndroidFindBy(xpath = "//android.widget.ListView/android.widget.FrameLayout")
    private List<WebElement> viewList;
    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.move.realtor:id/priceTextView']")
    private List<WebElement> homePrice;
    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.move.realtor:id/bedroomCountTextView']")
    private List<WebElement> homeBedCount;
    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.move.realtor:id/bathroomCountTextView']")
    private List<WebElement> homeBathCount;
    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.move.realtor:id/address_text_view']")
    private  List<WebElement> homeAddress;
    @AndroidFindBy(xpath = "//android.widget.Button")
    private List<WebElement> expandButton;


    public List<WebElement> getHomePrice(){
        return homePrice;
    }
    public List<WebElement> getHomeBedCount(){
       return homeBedCount;
    }
    public List<WebElement> getHomeBathCount(){
        return homeBathCount;
    }
    public List<WebElement> getHomeAddress(){
        return homeAddress;
    }

    public ViewPage swipeView(){
        WebElement view = viewList.get(0);
        int viewStartX = view.getLocation().x+60;
        int viewStartY = view.getLocation().y;
        int viewHeight = view.getSize().height;
        swipeUp(viewStartX, viewStartY+viewHeight, viewStartX,15);
        return new ViewPage(driver);
    }
    public int getExpandButton(){
        return expandButton.size();
    }

    public ViewPage waitForViewList(){
        waitUntilAllElementsAreVisible(By.xpath("//android.widget.ListView/android.widget.FrameLayout"));
        return this;
    }

}
