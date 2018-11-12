package com.epam.tat.realtor.steps;

import com.epam.tat.realtor.pages.ViewPage;
import com.epam.tat.realtor.util.Parser;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class ViewPageStep extends BasePageStep {
    private ViewPage viewPage;
    private Set<Integer> propertyPrice = new HashSet<>();
    private Set<Integer> propertyBed = new HashSet<>();
    private Set<Integer> propertyBath = new HashSet<>();
    public ViewPageStep(AppiumDriver<WebElement> driver){
        super(driver);
        viewPage= new ViewPage(driver);
    }
    public ViewPageStep createPropertyList(){
       viewPage.waitForViewList();

        do{
            propertyPrice.addAll(viewPage.getHomePrice().stream().map(x->Parser.parse(x.getText())).collect(Collectors.toList()));
            propertyBed.addAll(viewPage.getHomeBedCount().stream().map(x->Parser.parse(x.getText())).collect(Collectors.toList()));
            propertyBath.addAll(viewPage.getHomeBathCount().stream().map(x->Parser.parse(x.getText())).collect(Collectors.toList()));
            viewPage.swipeView();
        }
        while(viewPage.getExpandButton()<1);
        return this;
    }

    public boolean checkSearchResults(String MIN_PRICE_VALUE, String MAX_PRICE_VALUE, int BATH_QUANTITY, int BED_QUANTITY) {
        return propertyPrice.stream().peek(x->System.out.print(x+" ")).allMatch(x->(x<=Integer.valueOf(MAX_PRICE_VALUE))&&(x>=Integer.valueOf(MIN_PRICE_VALUE)))
                && propertyBed.stream().peek(x->System.out.print(x+" ")).allMatch(x->x>= BED_QUANTITY)
                && propertyBath.stream().peek(x->System.out.print(x+" ")).allMatch(x->x>=BATH_QUANTITY);
    }
    public boolean checkSoldStatus() {
        viewPage.waitForViewList();
        boolean soldStatus = true;
        do{
            soldStatus&=viewPage.getHomeStatus().stream().allMatch(x->x.getText().trim().equals("Sold"));
            viewPage.swipeView();
        }
        while(viewPage.getExpandButton()<1);
        return soldStatus;
    }

}
