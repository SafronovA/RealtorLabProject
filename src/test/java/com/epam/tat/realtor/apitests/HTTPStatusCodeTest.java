package com.epam.tat.realtor.apitests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;

public class HTTPStatusCodeTest {

    @BeforeTest
    public void initPage() {
        RestAssured.baseURI = "https://www.realtor.com/";
    }

    @Test
    public void checkStatusCode() {
        Response response = given().get("/sell").andReturn();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(response.getStatusCode(), 200);
        softAssert.assertEquals(response.getStatusLine(), "HTTP/1.1 200 OK");
        softAssert.assertAll();
    }

    @Test
    public void checkHeader(){
        Response response = given().get("/sell").andReturn();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(response.getHeader("content-type"), "application/json");
        softAssert.assertEquals(response.getHeader("charset"), "utf8");
    }

    @Test
    public void checkResponseBody(){

    }

}
