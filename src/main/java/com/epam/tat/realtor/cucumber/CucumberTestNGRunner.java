package com.epam.tat.realtor.cucumber;

import cucumber.api.CucumberOptions;

@CucumberOptions(
    features = "src/test/resources/realtor_features",
        glue = {"src.main.java.com.epam.tat.realtor.steps"})

public class CucumberTestNGRunner {


}
