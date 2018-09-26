package com.epam.tat.realtor.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchPage extends BasePage {

    public SearchPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy (id = "desktop-price-div")
    WebElement priceButton;
    @FindBy (id = "price-input-1-desktop")
    WebElement minPriceInput;
    @FindBy (id = "price-input-2-desktop")
    WebElement maxPriceInput;
    @FindBy (xpath = "(//*[@id='price-input-1-list'])[1]/li")
    List<WebElement> minPriceRange;
    @FindBy (xpath = "(//*[@id='price-input-2-list'])[1]/li")
    List<WebElement> maxPriceRange;
    @FindBy (id = "desktop-bedroom-div")
    WebElement bedButton;
    @FindBy (xpath = "//*[@id='filter-section-bedroom-desktop']//label")
    List<WebElement> bedQuantityChoice;
    @FindBy (id = "desktop-bathroom-div")
    WebElement bathButton;
    @FindBy (xpath = "//*[@id='filter-section-bathroom-desktop']//label")
    List<WebElement> bathQuantityChoice;
    @FindBy (xpath = "//span[contains(text(),'Filters')]")
    WebElement moreFiltersButton;
    @FindBy (xpath = "//div[@class='filter-section filter-section-home-size']/a")
    WebElement homeSizeButton;
    




}
