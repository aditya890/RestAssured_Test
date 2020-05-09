package com.demo;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;


public class UploadFileRest {

	@Test(priority=1)
	public void doingPaymentWithOauth2Autentication()
	{
		String rootPath = System.getProperty("user.dir");
		String filePath = rootPath+ "\\src\\test\\resources\\testdata\\data.json";
		File file = new File(filePath);
		RestAssured.baseURI="https://petstore.swagger.io/";
		RestAssured.basePath="/v2";
		String endpoint="​/pet​/52​/uploadFile";
		
		//upload file
		RestAssured.given().log().all().formParam("additionalMetadata","test the file").multiPart(file);
		
		//download file
//		Response res = RestAssured.given().log().all().auth().oauth("consumerSecret", "accessToken", "secretToken", "endpoint").get("endpoint");
//		
//		res.getBody().asByteArray();
	}
}
