package com.epam.tat.realtor.bddsteps;

import com.epam.tat.realtor.ConfigProperties;
import com.epam.tat.realtor.bo.House;
import com.epam.tat.realtor.drivers.DriverFactory;
import com.epam.tat.realtor.steps.HomePageStep;
import com.epam.tat.realtor.steps.SearchPageStep;
import cucumber.api.PendingException;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;

import java.util.List;

import static org.testng.Assert.assertTrue;

public class SearchPageBDDSteps {
    private WebDriver driver = DriverFactory.CHROMEDRIVER.getDriver();
    private List<House> searchResult;
    private SearchPageStep searchPageStep;
    @Before
    public void initResources(){
        driver.manage().deleteAllCookies();
        driver.navigate().to(ConfigProperties.getTestProperty("url"));
    }
    @After
    public void getScenarioInfo(Scenario scenario) {
        System.out.println(scenario.getId());
        System.out.println(scenario.getName());
        System.out.println(scenario.getStatus());
        System.out.println(scenario.isFailed());
        System.out.println(scenario.getSourceTagNames());
    }


    @Given("^user perform search by \"([^\"]*)\"$")
    public void userPerformSearchBy(String city_Name)  {
        searchPageStep=new HomePageStep(driver).enterCityName(city_Name)
                .clickSearchButton();
    }

    @When("^user create search request by \"([^\"]*)\", \"([^\"]*)\",\"([^\"]*)\", \"([^\"]*)\",\"([^\"]*)\", \"([^\"]*)\"$")
    public void userCreateSearchRequestBy(String MIN_PRICE_VALUE, String MAX_PRICE_VALUE, String BED_NUMBER, String BATH_NUMBER, String MIN_SQFT_VALUE, String MAX_SQFT_VALUE)  {
        searchPageStep.createSearchRequest(MIN_PRICE_VALUE, MAX_PRICE_VALUE,
                BED_NUMBER, BATH_NUMBER,
                MIN_SQFT_VALUE, MAX_SQFT_VALUE);
    }

    @Then("^prices on map marks on the iframe map should be between \"([^\"]*)\" and \"([^\"]*)\"$")
    public void pricesOnMapMarksOnTheIframeMapShouldBeBetweenAnd(String MIN_PRICE_VALUE, String MAX_PRICE_VALUE) {
        assertTrue(searchPageStep.checkPriceMapMarks(MIN_PRICE_VALUE, MAX_PRICE_VALUE),
                "price value on the map mark mismatch search criteria");
    }

    @Then("^map marks on the iframe map should have beds more than \"([^\"]*)\"$")
    public void mapMarksOnTheIframeMapShouldHaveBedsMoreThan(String BED_NUMBER)  {
        assertTrue(searchPageStep.checkBedMapMarks(BED_NUMBER),
                "bed quantity on the map mark mismatch search criteria");
    }

    @Then("^map marks on the iframe map should have baths more than \"([^\"]*)\"$")
    public void mapMarksOnTheIframeMapShouldHaveBathsMoreThan(String BATH_NUMBER) {
        assertTrue(searchPageStep.checkBathMapMarks(BATH_NUMBER),
                "bath quantity on the map mark mismatch search criteria");
    }

    @Then("^house sqft on map marks on the iframe map should be between \"([^\"]*)\" and \"([^\"]*)\"$")
    public void houseSqftOnMapMarksOnTheIframeMapShouldBeBetweenAnd(String MIN_SQFT_VALUE, String MAX_SQFT_VALUE) {
        assertTrue(searchPageStep.checkSqftMapMarks(MIN_SQFT_VALUE, MAX_SQFT_VALUE),
                "square feet house size on the map mark mismatch search criteria");
    }

    @Then("^prices in search result should be between \"([^\"]*)\" and \"([^\"]*)\"$")
    public void pricesInSearchResultShouldBeBetweenAnd(String MIN_PRICE_VALUE, String MAX_PRICE_VALUE) throws Throwable {
        searchResult = searchPageStep.createHomesList();
        assertTrue(searchPageStep.checkSearchResultPrice(searchResult, MIN_PRICE_VALUE, MAX_PRICE_VALUE),
                "price value mismatch search criteria");
    }

    @And("^map marks in search results hould have beds more than \"([^\"]*)\"$")
    public void mapMarksInSearchResultsHouldHaveBedsMoreThan(String BED_NUMBER) throws Throwable {
        assertTrue(searchPageStep.checkSearchResultBed(searchResult, BED_NUMBER),
                "bed quantity mismatch search criteria");
    }

    @And("^map marks in search result should have baths more than \"([^\"]*)\"$")
    public void mapMarksInSearchResultShouldHaveBathsMoreThan(String BATH_NUMBER) throws Throwable {
        assertTrue(searchPageStep.checkSearchResultBath(searchResult, BATH_NUMBER),
                "bath quantity mismatch search criteria");
    }

    @And("^house sqft in search result should be between \"([^\"]*)\" and \"([^\"]*)\"$")
    public void houseSqftInSearchResultShouldBeBetweenAnd(String MIN_SQFT_VALUE, String MAX_SQFT_VALUE) throws Throwable {
        assertTrue(searchPageStep.checkSearchResultSqft(searchResult, MIN_SQFT_VALUE, MAX_SQFT_VALUE),
                "square feet house size mismatch search criteria");
    }

    @Then("^number of found houses match result information$")
    public void numberOfFoundHousesMatchResultInformation() throws Throwable {
        assertTrue(searchPageStep.checkFindHomesCount(),
                "The number of homes found and displayed is not equal");
    }

    @And("^user choose to sort houses by \"([^\"]*)\"$")
    public void userChooseToSortHousesBy(String SORT_OPTION) throws Throwable {
        searchPageStep.selectSortOption(SORT_OPTION);
    }

    @Then("^elements on the page displayed sorted by price$")
    public void elementsOnThePageDisplayedSortedByPrice() throws Throwable {
        assertTrue(searchPageStep.isHomesDisplayedSortedByPrice(),
                "Homes are not displayed on the page sorted by price");
    }

    @When("^user create search request by price \"([^\"]*)\", \"([^\"]*)\"$")
    public void userCreateSearchRequestByPrice(String MIN_PRICE, String MAX_PRICE) throws Throwable {
        searchPageStep.selectMinMaxPrices(MIN_PRICE, MAX_PRICE);
    }

    @And("^user choose high school and select school \"([^\"]*)\"$")
    public void userChooseHighSchoolAndSelectSchool(String RATING) throws Throwable {
        searchPageStep.clickSchoolButton()
                .selectHighSchool()
                .selectSchoolRating(RATING);
    }

    @Then("^schools that are displayed on map have rating more than selected \"([^\"]*)\"$")
    public void schoolsThatAreDisplayedOnMapHaveRatingMoreThanSelected(String RATING) throws Throwable {
        assertTrue(searchPageStep.doesAllSchoolHaveSelectedRating(RATING),
                "One of the schools shown on the map does not have a rating more that " + RATING);
    }

    @When("^user click on View Map button$")
    public void userClickOnViewMapButton() throws Throwable {
        searchPageStep.clickViewMapButton();
    }

    @And("^click on \"([^\"]*)\" button and select restaurants$")
    public void clickOnButtonAndSelectRestaurants(String arg0) throws Throwable {
        searchPageStep.clickLifestyleButton()
                .selectRestaurants();
    }

    @Then("^all marks on the map are restaurants$")
    public void allMarksOnTheMapAreRestaurants() throws Throwable {
        assertTrue(searchPageStep.areAllFoundLifestyleRestaurants(),
                "One of found lifestyle is not a restaurant");
    }
}
