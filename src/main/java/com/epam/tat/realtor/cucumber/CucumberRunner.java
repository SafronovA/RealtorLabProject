package com.epam.tat.realtor.cucumber;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = {"src/test/resources/realtor_features/realtor_page.feature",
                "src/test/resources/realtor_features/search_page.feature",
                "src/test/resources/realtor_features/user_profile.feature"},
        glue = {"com.epam.tat.realtor.bddsteps",
                "com.epam.tat.realtor.cucumber"}
)

public class CucumberRunner extends AbstractTestNGCucumberTests {
}
