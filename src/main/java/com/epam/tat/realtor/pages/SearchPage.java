package com.epam.tat.realtor.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class SearchPage extends BasePage {

    public SearchPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }
}
