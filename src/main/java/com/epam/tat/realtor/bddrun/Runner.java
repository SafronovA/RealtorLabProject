package com.epam.tat.realtor.bddrun;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions( features = {"src/test/resources/features/SearchPageActions.feature",
        "src/test/resources/features/MyProfile.feature",
        "src/test/resources/features/realtor_page.feature"},
        glue = {"com.epam.tat.realtor.bddsteps"
                ,"com.epam.tat.realtor.bddrun"}

//        tags = {"@MortgageCalculator" +
//                        "@SchoolRating, " +
//                        "@RestaurantsFilter, " +
//                        "@SortByRecommendations"}

)

public class Runner extends AbstractTestNGCucumberTests {

}
