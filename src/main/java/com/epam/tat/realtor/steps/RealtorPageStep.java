package com.epam.tat.realtor.steps;

import com.epam.tat.realtor.pages.BasePage;
import com.epam.tat.realtor.pages.RealtorPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class RealtorPageStep extends BasePageStep {
    private RealtorPage realtorPage;

    public RealtorPageStep(WebDriver driver) {
        super(driver);
        realtorPage = new RealtorPage(driver);
    }

    /**
     * get sold houses map marks,
     * click on each mark in the list,
     * check status of every mark
     *
     * @return if every mark contains information that house is sold
     */
    public boolean checkSoldHousesMapMarks() {
        realtorPage.waitForMapMarks();
        return realtorPage.getSoldHousesMapMarkList().stream().allMatch(x -> {
            BasePage.clickByJEx(x, driver);
            return isSold(realtorPage.getSaleHouseStatus());
        });
    }

    /**
     * get number of sold houses
     *
     * @return number of sold houses
     */
    public int getSoldHousesQuantity() {
        return realtorPage.getSoldHousesMapMarkList().size();
    }

    /**
     * check if map mark has "sold" text inside
     *
     * @param houseStatus text of the map mark
     * @return 'sold' status
     */
    private boolean isSold(String houseStatus) {
        return houseStatus.trim().equalsIgnoreCase("sold");
    }

    /**
     * scroll to iframe,
     * click on "Recently Sold" section,
     * double click on zoom out button,
     * drag down iframe to 50 yOffset
     *
     * @return this page
     */
    public RealtorPageStep prepareIFrameMap() {
        realtorPage.scrollToIFrame().clickSoldHousesSection().doubleZoomOut();
        dragDownIFrame();
        return this;
    }

    /**
     * drag down iframe to 50 yOffset
     *
     * @return this page
     */
    private RealtorPageStep dragDownIFrame() {
        new Actions(driver).dragAndDropBy(realtorPage.getSoldHousesMapMarkList().get(0), 0, 100).click().perform();
        return this;
    }

    /**
     * click load all reviews button untill all reviews won't be loaded
     *
     * @return this page
     */
    public RealtorPageStep loadAllReviews() {
        while (realtorPage.isLoadMoreReviewsButtonDisplayed()) {
            realtorPage.clickLoadMoreReviewsButton();
        }
        return this;
    }

    /**
     * get realtor reviews count
     *
     * @return realtor reviews count
     */
    public int getRealtorReviewsCount() {
        return realtorPage.getRealtorReviews().size();
    }


}
