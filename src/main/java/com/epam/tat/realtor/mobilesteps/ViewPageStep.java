package com.epam.tat.realtor.mobilesteps;

import com.epam.tat.realtor.bo.House;
import com.epam.tat.realtor.mobilepages.ViewPage;
import com.epam.tat.realtor.util.Parser;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ViewPageStep extends BasePageStep {
    private ViewPage viewPage;
    public ViewPageStep(AppiumDriver<WebElement> driver){
        super(driver);
        viewPage= new ViewPage(driver);
    }
    public List<House> createPropertyList(){
        List<House> propertyList = new ArrayList<>();
        String propertyAddress;
        propertyList.add(new House(Parser.parse(viewPage.getHomePrice().get(0).getText()),
                Parser.parse(viewPage.getHomeBedCount().get(0).getText()),
                Parser.parse(viewPage.getHomeBathCount().get(0).getText())));
        viewPage.swipeView();
        do{
            propertyList.add(new House(Parser.parse(viewPage.getHomePrice().get(0).getText()),
                    Parser.parse(viewPage.getHomeBedCount().get(0).getText()),
                    Parser.parse(viewPage.getHomeBathCount().get(0).getText())));
            propertyAddress = viewPage.getHomeAddress().get(0).getText();
            viewPage.swipeView();
        }
        while(!propertyAddress.equals(viewPage.getHomeAddress().get(0).getText()));
        for (int i = 1; i < viewPage.getHomePrice().size(); i++) {
            propertyList.add(new House(Parser.parse(viewPage.getHomePrice().get(i).getText()),
                    Parser.parse(viewPage.getHomeBedCount().get(i).getText()),
                    Parser.parse(viewPage.getHomeBathCount().get(i).getText())));
        }
        return propertyList;
    }
}
