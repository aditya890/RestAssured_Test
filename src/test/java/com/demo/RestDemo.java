package com.demo;





import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class RestDemo {

	
	@Test
	public void getResponse() {
		
		RestAssured.baseURI="https://petstore.swagger.io/";
		RestAssured.basePath="/v2";
	Response res=	RestAssured.given().get("/pet/101");
	res.prettyPrint();
	
		
	}
}
