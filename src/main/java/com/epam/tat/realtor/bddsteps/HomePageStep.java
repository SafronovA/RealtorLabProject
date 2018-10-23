package com.epam.tat.realtor.bddsteps;

import com.epam.tat.realtor.pages.HomePage;
import com.epam.tat.realtor.steps.*;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePageStep extends BasePageStep {
    private HomePage homePage;

    public HomePageStep(WebDriver driver) {
        super(driver);
        homePage = new HomePage(driver);
    }

    /**
     * click Realtor button
     *
     * @return new FindRealtorPageStep
     */
    @When("click find realtor button")
    public void clickFindRealtorButton() {
        homePage.clickRealtorButton();
    }

}
