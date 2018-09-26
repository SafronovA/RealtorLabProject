package com.epam.tat.realtor.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SavedSearchesPage extends BasePage {

    public SavedSearchesPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//a[contains(@title,'delete this saved card')]")
    private WebElement deleteButton;
    @FindBy(xpath = "//div[contains(@class,'card-padding')]")
    private List<WebElement> savedSearchesList;
    @FindBy(xpath = "//a[@id='header-rdc-logo']")
    private WebElement logo;

    public List<WebElement> getSavedSearchesList() {
        return savedSearchesList;
    }

    public SavedSearchesPage clickDeleteButton(){
        deleteButton.click();
        return this;
    }

    public HomePage moveToHomePage(){
        logo.click();
        return new HomePage(driver);
    }

}
