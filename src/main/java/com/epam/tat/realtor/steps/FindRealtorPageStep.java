package com.epam.tat.realtor.steps;

import com.epam.tat.realtor.pages.FindRealtorPage;
import com.epam.tat.realtor.util.Parser;
import org.openqa.selenium.WebDriver;

public class FindRealtorPageStep extends BasePageStep {
    private FindRealtorPage findRealtorPage;

    public FindRealtorPageStep(WebDriver driver) {
        super(driver);
        findRealtorPage = new FindRealtorPage(driver);
    }
    public int getRealtorSoldHoses(){
        return Parser.parse(findRealtorPage.getRealtorSoldHouses());
    }
    public RealtorPageStep clickRealtorIcon(){
        findRealtorPage.clickRealtorIcon();
        return new RealtorPageStep(driver);
    }
}
