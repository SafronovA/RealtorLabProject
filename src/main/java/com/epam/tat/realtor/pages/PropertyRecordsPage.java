package com.epam.tat.realtor.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
//
//public class PropertyRecordsPage extends BasePage {
//
//    public PropertyRecordsPage(WebDriver driver) {
//        super(driver);
//        PageFactory.initElements(driver, this);
//    }
//
//    @FindBy(xpath = "//ul[@class='list-horizontal street-pagination']/li/a")
//    private List<WebElement> charList;
//    @FindBy(xpath = "//ul[@class='list-unstyled']/li/a")
//    private List<WebElement> propertyRecordsList;
//
//    /**
//     * get list of char elements
//     *
//     * @return list of char elements
//     */
//    public List<WebElement> getCharList() {
//        return charList;
//    }
//
//    /**
//     * get list of property records on the page
//     *
//     * @return list of property records
//     */
//    public List<WebElement> getPropertyRecordsList() {
//        waitForPresenceOfAllElementsLocatedBy(By.xpath("//ul[@class='list-unstyled']/li/a"));
//        return propertyRecordsList;
//    }
//
//    /**
//     * find element property record link by text
//     *
//     * @param text text of property record link
//     * @return lement property record link
//     */
//    public WebElement findElementByText(String text) {
//        return driver.findElement(By.xpath("//ul[@class='list-horizontal street-pagination']/li/a[text()='" + text + "']"));
//    }
//}
