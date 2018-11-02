package com.epam.tat.realtor.mobilesteps;

import com.epam.tat.realtor.mobilepages.BasePage;
import com.epam.tat.realtor.mobilepages.HomePage;
import com.epam.tat.realtor.mobilepages.MenuPage;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

public class HomePageStep extends BasePageStep {
    private HomePage homePage;
    public HomePageStep(AppiumDriver<WebElement> driver){
        super(driver);
        homePage= new HomePage(driver);
    }

    public MenuPageStep enterMenuSection() {
         homePage.clickMenuButton();
         return new MenuPageStep(driver);
    }
    public FilterPageStep enterFilterSection(){
        homePage.clickFilterButton();
        return new FilterPageStep(driver);
    }
    public ViewPageStep showListView(){
        homePage.clickViewListButton();
        return new ViewPageStep(driver);
    }
}
