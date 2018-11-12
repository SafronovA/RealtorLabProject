package com.epam.tat.realtor.mobiletests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class APIRealtorRequest {

    @BeforeTest
    public void initPage() {
        RestAssured.baseURI = "https://www.realtor.com/api/v1/";
    }

    @Test
    public void checkStatusCode() {
        Response response = RestAssured.given()
                .header("content-type", "application/json")
               // .get("browse_modules?types=new_homes_for_sale,new_listings_for_sale,open_houses_for_sale,affordable_homes_for_sale,around_median_homes_for_sale,luxury_homes_for_sale&location=all")
                .get("browse_modules?types=open_houses_for_sale,new_listings_for_sale&location=all&view=all")
                .andReturn();
        response.prettyPrint();
        List<String> deviceList = response.jsonPath().getList("results.deviceName");

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
