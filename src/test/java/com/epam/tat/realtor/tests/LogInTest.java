package com.epam.tat.realtor.tests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LogInTest extends BaseTest {
    @BeforeTest
    public void logIn(){
        homePageStep.userLogIn();
    }
    @Test
    public void sampleSearch(){


    }
    @AfterTest
    public void logOut(){
        homePageStep.logOut();
    }
}
