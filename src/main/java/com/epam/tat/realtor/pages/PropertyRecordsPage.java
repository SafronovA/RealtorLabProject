package com.epam.tat.realtor.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PropertyRecordsPage extends BasePage{

    public PropertyRecordsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//ul[@class='list-horizontal street-pagination']/li/a")
    private List<WebElement> charList;
    @FindBy(xpath = "//ul[@class='list-unstyled']/li/a")
    private List<WebElement> propertyRecordsList;

    public List<WebElement> getCharList(){
        return charList;
    }
    public List<WebElement> getPropertyRecordsList(){
        waitForPresenceOfAllElementsLocatedBy(By.xpath("//ul[@class='list-unstyled']/li/a"));
        return propertyRecordsList;
    }
}
