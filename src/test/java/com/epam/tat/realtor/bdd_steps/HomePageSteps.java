package com.epam.tat.realtor.bdd_steps;

import com.epam.tat.realtor.drivers.DriverFactory;
import com.epam.tat.realtor.steps.HomePageStep;
import com.epam.tat.realtor.steps.SearchPageStep;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.assertTrue;

public class HomePageSteps  {
    WebDriver driver = DriverFactory.CHROMEDRIVER;
    @Given("^user perform search by \"([^\"]*)\"$")
    public void userPerformSearchBy(String city_Name)  {
        new HomePageStep(driver).enterCityName(city_Name)
                .clickSearchButton();
    }

    @When("^user create search request by \"([^\"]*)\", \"([^\"]*)\",\"([^\"]*)\", \"([^\"]*)\",\"([^\"]*)\", \"([^\"]*)\"$")
    public void userCreateSearchRequestBy(String MIN_PRICE_VALUE, String MAX_PRICE_VALUE, String BED_NUMBER, String BATH_NUMBER, String MIN_SQFT_VALUE, String MAX_SQFT_VALUE)  {
         new SearchPageStep(driver).createSearchRequest(MIN_PRICE_VALUE, MAX_PRICE_VALUE,
                BED_NUMBER, BATH_NUMBER,
                MIN_SQFT_VALUE, MAX_SQFT_VALUE);
    }

    @Then("^prices on map marks on the iframe map should be between \"([^\"]*)\" and \"([^\"]*)\"$")
    public void pricesOnMapMarksOnTheIframeMapShouldBeBetweenAnd(String MIN_PRICE_VALUE, String MAX_PRICE_VALUE) {
        assertTrue(new SearchPageStep(driver).checkPriceMapMarks(MIN_PRICE_VALUE, MAX_PRICE_VALUE),
                "price value on the map mark mismatch search criteria");
    }

    @Then("^map marks on the iframe map should have beds more than \"([^\"]*)\"$")
    public void mapMarksOnTheIframeMapShouldHaveBedsMoreThan(String BED_NUMBER)  {
        assertTrue(new SearchPageStep(driver).checkBedMapMarks(BED_NUMBER),
                "bed quantity on the map mark mismatch search criteria");
    }

    @Then("^map marks on the iframe map should have baths more than \"([^\"]*)\"$")
    public void mapMarksOnTheIframeMapShouldHaveBathsMoreThan(String BATH_NUMBER) {
        assertTrue(new SearchPageStep(driver).checkBathMapMarks(BATH_NUMBER),
                "bath quantity on the map mark mismatch search criteria");
    }

    @Then("^house sqft on map marks on the iframe map should be between \"([^\"]*)\" and \"([^\"]*)\"$")
    public void houseSqftOnMapMarksOnTheIframeMapShouldBeBetweenAnd(String MIN_SQFT_VALUE, String MAX_SQFT_VALUE) {
        assertTrue(new SearchPageStep(driver).checkSqftMapMarks(MIN_SQFT_VALUE, MAX_SQFT_VALUE),
                "square feet house size on the map mark mismatch search criteria");
    }
}
