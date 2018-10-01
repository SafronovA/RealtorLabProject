package com.epam.tat.realtor.steps;

import com.epam.tat.realtor.pages.BasePage;
import com.epam.tat.realtor.pages.RealtorPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class RealtorPageStep extends BasePageStep{
    private RealtorPage realtorPage;

    public RealtorPageStep(WebDriver driver) {
        super(driver);
        realtorPage = new RealtorPage(driver);
    }
    public boolean checkSoldHousesMapMarks(){
        realtorPage.waitForMapMarks();
        return realtorPage.getSoldHousesMapMarkList().stream().allMatch(x->{BasePage.clickByJEx(x,driver);
                                                                    return isSold(realtorPage.getSaleHouseStatus());});
    }

    public int getSoldHousesQuantity(){
        return realtorPage.getSoldHousesMapMarkList().size();
    }
    private boolean isSold(String houseStatus){
        return houseStatus.trim().equalsIgnoreCase("sold");
    }
    public RealtorPageStep goToIFrameMap(){
        realtorPage.scrollToIFrame().clickSoldHousesSection().doubleZoomOut();
        dragDownIFrame();
        return this;
    }
    public RealtorPageStep dragDownIFrame(){
        new Actions(driver).dragAndDropBy(realtorPage.getSoldHousesMapMarkList().get(0),0,100).click().perform();
        return this;
    }

}
