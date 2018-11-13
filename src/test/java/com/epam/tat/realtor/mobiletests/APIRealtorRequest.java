package com.epam.tat.realtor.mobiletests;

import com.epam.tat.realtor.util.FileCreator;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class APIRealtorRequest {

    @BeforeTest
    public void initPage() {
        RestAssured.baseURI = "https://www.realtor.com/api/v1/";
    }

    @Test
    public void checkStatusCode() {
        List<StringBuilder> resultAPI = new ArrayList<>();
        Response response = RestAssured.given()
                    .header("content-type", "application/json")
                    .get("browse_modules?types=new_listings_for_sale,open_houses_for_sale,around_median_homes_for_sale,luxury_homes_for_sale&location=all")
                    .andReturn();

        appendInformation(resultAPI,response,"price","list_price");
        appendInformation(resultAPI,response,"beds","description.beds");
        appendInformation(resultAPI,response,"baths","description.baths");
        appendInformation(resultAPI,response,"sqft","description.sqft");
        appendInformation(resultAPI,response,"state","location.address.state");
        appendInformation(resultAPI,response,"state_code","location.address.state_code");
        appendInformation(resultAPI,response,"postal_code","location.address.postal_code");
        appendInformation(resultAPI,response,"city","location.address.city");
        appendInformation(resultAPI,response,"street","location.address.line");
        FileCreator.create(resultAPI.stream().collect(Collectors.joining("\n")));
        resultAPI.forEach(s-> System.out.println(s.toString()));

    }
    private List<StringBuilder> appendInformation(List<StringBuilder> builderList, Response response, String infoName, String jsonValue){
        HashMap<String,JsonPath> propertySections = response.jsonPath().get("result.results");
                List<String> infoList =propertySections.keySet()
                .stream()
                .map(x->(List<Object>)response.jsonPath().get("result.results."+x+".properties."+jsonValue))
                .flatMap(Collection::stream)
                .map(Object::toString)
                .collect(Collectors.toList());
        if(builderList.isEmpty()){
            infoList.stream().forEach(x->builderList.add(new StringBuilder(infoName+": "+x)));
        }
        else {
        builderList.forEach(x->x.append(";\t\t "+infoName+": "+infoList.get(builderList.indexOf(x))+" "));

    }
        return builderList;
    }


}
