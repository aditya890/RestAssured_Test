package com.demo;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class RestCurdTestNg {

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
	public void update() {
		String petinfo="{\r\n" + 
				"  \"id\": 23,\r\n" + 
				"  \"category\": {\r\n" + 
				"    \"id\": 0,\r\n" + 
				"    \"name\": \"string\"\r\n" + 
				"  },\r\n" + 
				"  \"name\": \"cat\",\r\n" + 
				"  \"www.demo.com\": [\r\n" + 
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
		Assert.assertTrue(res.getBody().asString().contains("cat"));
	}
	
	@Test(priority=3)
	public void get() {
		RestAssured.baseURI="https://petstore.swagger.io/";
		RestAssured.basePath="/v2";
	    Response res=	RestAssured.given().get("/pet/23");
	    res.prettyPrint();
	
		}
	@Test(priority=4)
	public void delete() {
		Response res=RestAssured.given().delete("/pet/23");
		res.prettyPrint();
	}
	
	
}
