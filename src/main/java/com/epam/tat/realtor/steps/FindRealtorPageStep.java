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

    /**
     * get realtor sold houses number
     * @return realtor sold houses number
     */
    public int getRealtorSoldHoses(){
        return Parser.parse(findRealtorPage.getRealtorSoldHouses());
    }

    /**
     * click realtor icon
     * @return new RealtorPageStep
     */
    public RealtorPageStep clickRealtorIcon(){
        findRealtorPage.clickRealtorIcon();
        return new RealtorPageStep(driver);
    }
}
