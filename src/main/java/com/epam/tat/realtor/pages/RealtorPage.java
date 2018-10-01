package com.epam.tat.realtor.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class RealtorPage extends BasePage{
    public RealtorPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }
    By soldHouses = By.xpath("//div[@class='leaflet-marker-pane']/div");
    @FindBy(xpath = "//ul[@class='nav nav-tabs nav-pills']//a[contains(text(),'Recently Sold')]")
    private WebElement soldHousesSection;
    @FindBy(xpath = "//div[@class='leaflet-marker-pane']/div")
    private List<WebElement> soldHousesMapMarkList;
    @FindBy(xpath = "//div[@class='leaflet-popup-content']//strong")
    private WebElement saleHouseStatus;
    @FindBy(xpath = "//a[@class='leaflet-control-zoom-out']")
    private WebElement zoomOutButton;


    public RealtorPage clickSoldHousesSection(){
        waitUntilElementIsClickable(soldHousesSection);
        soldHousesSection.click();
        return this;
    }
    public List<WebElement> getSoldHousesMapMarkList(){
        return soldHousesMapMarkList;
    }
    public String getSaleHouseStatus(){
        waitUntilElementIsVisible(saleHouseStatus);
        return saleHouseStatus.getText();
    }
    public RealtorPage scrollToIFrame(){
        waitForPresenceOfAllElementsLocatedBy(soldHouses);
        BasePage.scrollToElement(soldHousesSection,driver);
        return this;
    }
    public RealtorPage doubleZoomOut(){
        waitUntilElementIsVisible(zoomOutButton);
        zoomOutButton.click();
        zoomOutButton.click();
        return this;
    }
    public RealtorPage waitForMapMarks(){
        waitForPresenceOfAllElementsLocatedBy(soldHouses);
        return this;
    }
}
