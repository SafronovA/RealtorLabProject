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

    @FindBy(id = "desktop-price-div")
    WebElement priceButton;
    @FindBy (xpath = "(//*[@id='price-input-1-list'])[1]/li")
    List<WebElement> minPriceRange;
    @FindBy (xpath = "(//*[@id='price-input-2-list'])[1]/li")
    List<WebElement> maxPriceRange;

    public SearchPage clickPriceButton(){
        priceButton.click();
        return this;
    }

    public List<WebElement> getMinPriceRange() {
        return minPriceRange;
    }

    public List<WebElement> getMaxPriceRange() {
        return maxPriceRange;
    }
}
