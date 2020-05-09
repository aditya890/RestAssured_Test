package com.demo;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BasicAuthentication {

	@Test
	public void basicAuthenticaion()
	{
		RequestSpecification request = 	RestAssured.given().baseUri("http://restapi.demoqa.com/authentication").auth().basic("ToolsQA", "TestPassword");
	
	request.log().all();
	Response res = request.get("/CheckForAuthentication");
	res.prettyPrint();
	}
}
