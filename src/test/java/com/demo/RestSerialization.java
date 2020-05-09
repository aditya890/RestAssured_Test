package com.demo;

import org.junit.Assert;
import org.junit.Test;


import com.user.User;
import com.user.UserResponse;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestSerialization {

	
	@Test()
	public void create() {
		
		RestAssured.baseURI="https://petstore.swagger.io/";
		RestAssured.basePath="/v2";
		
		//serialization
		User user= new User(45, "sam", "sam", "gedi", "sam@test.com", "123453", "87654", 1);

		RequestSpecification req =RestAssured.given().contentType("application/json").body(user);
		Response res=req.post("/user");
		res.then().log().all();
		res.prettyPrint();
		
		
		//deserialization
		UserResponse re=res.getBody().as(UserResponse.class);
		
		Assert.assertEquals(re.getCode(), 200);
		Assert.assertEquals(re.getMessage(), "45");
		Assert.assertEquals(re.getType(), "adsf");
	}
	
	
}


