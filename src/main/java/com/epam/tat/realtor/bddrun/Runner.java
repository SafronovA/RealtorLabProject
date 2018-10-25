package com.epam.tat.realtor.bddrun;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions( features = "src/test/resources/features/MyProfile.feature",
        glue = {"com.epam.tat.realtor.bddsteps"
                ,"com.epam.tat.realtor.bddrun"}, tags = "@SavedSearch"
)

public class Runner extends AbstractTestNGCucumberTests {
}
