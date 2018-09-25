package com.epam.tat.realtor.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class SavedSearchesPage extends BasePage {

    public SavedSearchesPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }
}
