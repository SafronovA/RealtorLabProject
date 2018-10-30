package com.epam.tat.realtor.apitests;

import com.epam.tat.realtor.bo.User;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HTTPStatusCodeTest {

    @BeforeTest
    public void initPage() {
        RestAssured.baseURI = "https://www.realtor.com/";
        //RestAssured.basePath = "/sell";
    }

    @Test
    public void checkStatusCode() {
        Response response = RestAssured.given().get().andReturn();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(response.getStatusCode(), 200);
        softAssert.assertEquals(response.getStatusLine(), "HTTP/1.1 200 OK");
        softAssert.assertAll();
    }

    @Test
    public void checkHeader(){
        Response response = RestAssured.given().get("/myaccount/my_profile").andReturn();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(response.getHeader("content-type"), "application/json");
        softAssert.assertEquals(response.getHeader("charset"), "utf8");
        softAssert.assertAll();
    }

    @Test
    public void lastTaskFromHW(){
        RestTemplate restTeampl = new RestTemplate();
        ResponseEntity<User[]> response = restTeampl.getForEntity("http://jsonplaceholder.typicode.com/users", User[].class);
        Assert.assertEquals(response.getBody().length, 10);
    }

}
