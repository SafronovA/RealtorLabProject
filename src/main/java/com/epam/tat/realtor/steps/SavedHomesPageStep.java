package com.epam.tat.realtor.steps;

import com.epam.tat.realtor.pages.SavedHomesPage;
import org.openqa.selenium.WebDriver;

public class SavedHomesPageStep extends BasePageStep {
    private SavedHomesPage savedHomesPage;

    public SavedHomesPageStep(WebDriver driver) {
        super(driver);
        savedHomesPage = new SavedHomesPage(driver);
    }

    /**
     * performing the operation of the transition to the 'My Profile' page
     * @return new MyProfilePageStep
     */
    public MyProfilePageStep goToMyProfileSection(){
        savedHomesPage.clickMyProfileLink();
        return new MyProfilePageStep(driver);
    }
    /**
     * click on Saved Searches link to open saved searches page
     * @return new SavedSearchesPageStep
     */
    public SavedSearchesPageStep clickSavedSearchesLink(){
        savedHomesPage.clickSavedSearches();
        return new SavedSearchesPageStep(driver);
    }

    public HomePageStep clearSavedHomes() {
        if (savedHomesPage.getSaveHomesButtonList().size()>0) {
            savedHomesPage.getSaveHomesButtonList().forEach(x -> {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                x.click();
                savedHomesPage.clickDeleteButton();
//            try {
//                while (savedHomesPage.getStrangeWindowLayer().isDisplayed()){}
//            }
//            catch (StaleElementReferenceException | NoSuchElementException e ){}
            });
        }
        savedHomesPage.clickRealtorIcon();
        return new HomePageStep(driver);
    }

    public int checkSavedHomes() {
        return savedHomesPage.getSaveHomesButtonList().size();
    }
}
