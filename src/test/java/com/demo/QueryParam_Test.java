package com.demo;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class QueryParam_Test {

	
@Test
public void queryTest()
{
	Response res = RestAssured.given().log().all().baseUri("https://reqres.in/api").queryParam("page", 2).queryParam("id", 5).get("/users");

res.then().log().all();
}
}
