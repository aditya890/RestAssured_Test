package com.demo;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestAssured_Log {
	@Test(priority=1)
	public void create() {
		RestAssured.baseURI="https://petstore.swagger.io/";
		RestAssured.basePath="/v2";
		
		String petinfo="{\r\n" + 
				"  \"id\": 23,\r\n" + 
				"  \"category\": {\r\n" + 
				"    \"id\": 0,\r\n" + 
				"    \"name\": \"string\"\r\n" + 
				"  },\r\n" + 
				"  \"name\": \"doggie\",\r\n" + 
				"  \"www.google.com\": [\r\n" + 
				"    \"string\"\r\n" + 
				"  ],\r\n" + 
				"  \"tags\": [\r\n" + 
				"    {\r\n" + 
				"      \"id\": 15,\r\n" + 
				"      \"name\": \"string\"\r\n" + 
				"    }\r\n" + 
				"  ],\r\n" + 
				"  \"status\": \"available\"\r\n" + 
				"}";
		RequestSpecification req =RestAssured.given().contentType("application/json").body(petinfo);

		Response res=req.post("/pet");

		res.prettyPrint();
		Assert.assertEquals(res.getStatusCode(), 200);	
		
	}
	
	
	@Test(priority=2)
	public void get() {
		RestAssured.baseURI="https://petstore.swagger.io/";
		RestAssured.basePath="/v2";
	    Response res=	RestAssured.given().get("/pet/230");
	    
	    res.then().log().ifError();
	    res.then().log().ifStatusCodeIsEqualTo(404);
	   // res.prettyPrint();
	
		}
}
