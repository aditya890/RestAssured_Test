package com.demo;

import org.junit.Assert;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class RestCurdTest {
	
	@Test()
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
		Assert.assertTrue(res.getBody().asString().concat("doggie"), false);
	}
	@Test
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
	}
	
	
	public void get() {
		RestAssured.baseURI="https://petstore.swagger.io/";
		RestAssured.basePath="/v2";
	    Response res=	RestAssured.given().get("/pet/23");
	    res.prettyPrint();
	
		}
	
	public void delete() {
		Response res=RestAssured.given().delete("/pet/23");
		res.prettyPrint();
	}
	
}
