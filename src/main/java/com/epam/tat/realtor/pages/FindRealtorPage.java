package com.epam.tat.realtor.pages;

import com.epam.tat.realtor.util.Parser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FindRealtorPage extends BasePage {
    public FindRealtorPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "(//div[@class='agent-detail-item ellipsis']/a/strong)[2]")
    private WebElement realtorSoldHouses;
    @FindBy(xpath = "//div[@class='agent-list-card-img']/img")
    private WebElement userIcon;

    public String getRealtorSoldHouses(){
        return realtorSoldHouses.getText();
    }
    public RealtorPage clickRealtorIcon(){
        waitUntilElementIsClickable(userIcon);
        userIcon.click();
        return new RealtorPage(driver);
    }

}
