package com.epam.tat.realtor.mobilepages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ViewPage extends BasePage{
    public ViewPage(AppiumDriver<WebElement> driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    @AndroidFindBy(xpath = "//android.widget.ListView/android.widget.FrameLayout")
    List<WebElement> viewList;
//    @AndroidFindBy(xpath = "(//android.widget.TextView[@resource-id='com.move.realtor:id/priceTextView'])[1]")
//    WebElement homePrice;
//    @AndroidFindBy(xpath = "(//android.widget.TextView[@resource-id='com.move.realtor:id/bedroomCountTextView'])[1]")
//    WebElement homeBedCount;
//    @AndroidFindBy(xpath = "(//android.widget.TextView[@resource-id='com.move.realtor:id/bathroomCountTextView'])[1]")
//    WebElement homeBathCount;
//    @AndroidFindBy(xpath = "(//android.widget.TextView[@resource-id='com.move.realtor:id/address_text_view'])[1]")
//    WebElement homeAddress;
    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.move.realtor:id/priceTextView']")
    List<WebElement> homePrice;
    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.move.realtor:id/bedroomCountTextView']")
    List<WebElement> homeBedCount;
    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.move.realtor:id/bathroomCountTextView']")
    List<WebElement> homeBathCount;
    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.move.realtor:id/address_text_view']")
    List<WebElement> homeAddress;


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
    public List<WebElement> getViewList(){
        return viewList;
    }


}
