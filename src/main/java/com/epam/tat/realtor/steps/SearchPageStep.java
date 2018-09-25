package com.epam.tat.realtor.steps;

import com.epam.tat.realtor.pages.SearchPage;
import org.openqa.selenium.WebDriver;

public class SearchPageStep extends BasePageStep{
    private SearchPage searchPage;

    public SearchPageStep(WebDriver driver){
        super(driver);
        searchPage = new SearchPage(driver);
    }
}
