package com.epam.tat.realtor.mobilesteps;

import com.epam.tat.realtor.mobilepages.MenuPage;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class MenuPageStep extends BasePageStep {
    private MenuPage menuPage;
    public MenuPageStep(AppiumDriver<WebElement> driver){
        super(driver);
        menuPage= new MenuPage(driver);
    }
    public SearchPageStep  startNewSearch() {
        menuPage.clickNewSearchButton();
        return new SearchPageStep(driver);
    }
    public HomePageStep  selectSoldStatus() throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);
        menuPage.clickRecentlySoldButton();
        return new HomePageStep(driver);
    }

}
