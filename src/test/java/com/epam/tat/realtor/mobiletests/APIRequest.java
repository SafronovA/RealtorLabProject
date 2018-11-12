package com.epam.tat.realtor.mobiletests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class APIRequest {

    @BeforeTest
    public void initPage() {
        RestAssured.baseURI = "http://mobilecloud.epam.com/automation/api/";
        //RestAssured.basePath = "/
    }

    @Test
    public void checkStatusCode() {
        Response response = RestAssured.given().header("Authorization","Bearer 815503fd-0af4-420a-ae71-b6a112d82682").get("device/android").andReturn();
        response.prettyPrint();
        List<String> deviceList = response.jsonPath().getList("desiredCapabilities.deviceName");
       // response.prettyPrint();
        deviceList.stream().forEach(x->System.out.print(x+'\n'));
    }

    @Test
    public void checkHeader(){
        Response response = RestAssured.given().get("/myaccount/my_profile").andReturn();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(response.getHeader("content-type"), "application/json");
        softAssert.assertEquals(response.getHeader("charset"), "utf8");
        softAssert.assertAll();
    }



}
