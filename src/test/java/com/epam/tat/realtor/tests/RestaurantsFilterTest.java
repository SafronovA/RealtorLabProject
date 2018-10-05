package com.epam.tat.realtor.tests;

import com.epam.tat.realtor.pages.BasePage;
import com.epam.tat.realtor.steps.SearchPageStep;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class RestaurantsFilterTest extends BaseTest {

    private static final String CITY_NAME = "San Francisco, CA";

    /**
     * check that dots are shown on map are restaurants
     */
    @Test
    public void restaurantsFilter() {
        SearchPageStep searchPageStep = homePageStep.enterCityName(CITY_NAME)
                .clickSearchButton()
                .clickViewMapButton()
                .clickLifestyleButton()
                .selectRestaurants();
//        List<WebElement> element = driver.findElements(By.xpath("//div[contains(@class,'pin-restaurants')]"));
//        for (int i = 1; i <element.size()+1 ; i++) {
//            BasePage.clickByJEx(driver.findElement(By.xpath("//div[contains(@class,'pin-restaurants')]["+i+"]")), driver);
//
//        }

        Assert.assertTrue(searchPageStep.areAllFoundLifestyleRestaurants(),
                "One of found lifestyle is not a restaurant");
    }
}
