package com.demo;


import static org.hamcrest.Matchers.*;

import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;


public class Hamcrest_Test {
	

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
		Response res=RestAssured.given().contentType("application/json").body(petinfo).post("/pet");
		res.prettyPrint();
		Assert.assertEquals(res.getStatusCode(), 200);	
		Assert.assertTrue(res.getBody().asString().contains("doggie"));
	}
	
	@Test(priority=2)
	public void get() {
		RestAssured.baseURI="https://petstore.swagger.io/";
		RestAssured.basePath="/v2";
	    Response res=	RestAssured.given().get("/pet/23");
	    res.then().body("id", Matchers.is(23));
	    res.then().body("id", equalTo(23));
	    
	    res.then().body("id", greaterThan(14));
	    
	  //  res.then().body("tags", hasItems("string"));
	    
	    res.then().body("tags.findAll{it.id>0}.name", hasItems("string"));
	    res.prettyPrint();
	
		}
}
