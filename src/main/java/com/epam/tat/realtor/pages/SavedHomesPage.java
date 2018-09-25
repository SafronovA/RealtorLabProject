package com.epam.tat.realtor.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class SavedHomesPage extends BasePage {

    public SavedHomesPage (WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }
}
