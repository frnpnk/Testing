package com.Tests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.testng.Assert;

import static io.restassured.RestAssured.given;

public class APITest {


    @Before
    // public static void preTest(){
    //     RestAssured.baseURI = "https://restool-sample-app.herokuapp.com/api/character/";
    // }
    public static void preTestTw() {
        RestAssured.baseURI = "https://api.twitter.com/2/tweets/1537190984097878016";
    }


    @Test
    @Tag("APITest")
    public void getAllCharacters() {

        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.request(Method.GET);
        String responseBody = response.getBody().asString();
        System.out.println("body feo" + responseBody);
        int statusCode = response.getStatusCode();
        System.out.println(statusCode);
        Assert.assertEquals(statusCode, 200);
        String statusLine = response.getStatusLine();
        System.out.println(statusLine);
    }

    @Test
    @Tag("APITest")
    public void putUpdate() {

        RequestSpecification httpRequest = RestAssured.given().contentType(ContentType.JSON
        ).body("{\n" +
                "    \"location\": \"Kings Lanfdfsfsding\"\n" +
                "}");
        Response response = httpRequest.request(Method.PUT, "A1Ok6HpQptsl");
        int statusCode = response.getStatusCode();
        System.out.println(statusCode);
        System.out.println(response);
    }

    @Test
    @Tag("APITest")
    public void sampleLogin(){
        given().contentType(ContentType.JSON).body("{\n" +
                        "    \"email\": \"eve.holt@reqres.in\",\n" +
                        "    \"password\": \"cityslicka\"\n" +
                        "}")
                .when().post("https://reqres.in/api/login")
                .then().statusCode(200).log().all();
    }
}
