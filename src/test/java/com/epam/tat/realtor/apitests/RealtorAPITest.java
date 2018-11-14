package com.epam.tat.realtor.apitests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;

public class RealtorAPITest {

    @BeforeTest
    public void initPage() {
        RestAssured.baseURI = "https://www.realtor.com";
        //RestAssured.basePath = "/sell";
    }

    @Test
    public void checkStatusCode() {
        Response response = RestAssured.given()
                .get("/api/v1/geo-landing/parser/suggest/?input=San%20Jose%2C%20C&area_types=address&area_types=neighborhood&area_types=city&area_types=county&area_types=postal_code&area_types=street&area_types=school&area_types=building&limit=10&latitude=53&longitude=28&includeState=false\n")
                .andReturn();
        ArrayList<String> jsonResponse = response.jsonPath().get("result");
        List<String> areaTypes = getValueListByPath(response, "area_type");
        List<String> cities = getValueListByPath(response, "city");
        List<String> stateCodes = getValueListByPath(response, "state_code");
        List<String> countries = getValueListByPath(response, "country");
        List<String> schools = getValueListByPath(response, "school");
        List<String> lines = getValueListByPath(response, "line");
    }

    public List<String> getValueListByPath(Response response, String path) {
        List<String> values = response.jsonPath().get("result." + path);
        values.stream().forEach(value -> System.out.printf("%-10s : %-10s", path, value));
        System.out.println();
        System.out.println();
        return values;
    }

}
