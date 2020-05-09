package com.demo;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class OAuth2_Test {
 
	static String accessToken;
	@Test(priority=1)
		public void getAccessTokenViaPreemptiveAuthentication() {
			RestAssured.baseURI = "https://api.sandbox.paypal.com";
			RestAssured.basePath = "v1";
			Response res = RestAssured.given().log().all().param("grant_type", "client_credentials").auth().preemptive()
					.basic("AcLJYXbewnk-8kbIQXIOPIe3AXXXB4WbxWC6x7hPK06jlxpFeIitmBtpT0MR-UWATGyVo44HIM5kw3Ow",
							"EGhmuQyuFzUozIsWCaEUkERrmKBMucrOz4dAONqOXwPtmc6ZIB87_As-CN7326-vg--0H44S9Gc3jV0J")
					.post("/oauth2/token");
			
			accessToken = res.jsonPath().getString("access_token");
			res.prettyPrint();
		}

		@Test(priority=2)
		public void doingPaymentWithOauth2Autentication()
		{
			String rootPath = System.getProperty("user.dir");
			String filePath = rootPath+ "\\src\\test\\resources\\testdata\\payment.json";
			File file = new File(filePath);
			RestAssured.baseURI = "https://api.sandbox.paypal.com";
			RestAssured.basePath = "v1";
			
			Response res = RestAssured.given().contentType(ContentType.JSON).log().all().auth().oauth2("A21AAEJztbOp0jBAQ0BY3WcsLjDxeS3o-BI4Kb3SslooY3QP7pVTQYEUls_KVC79Yq7Ho7Bib64iETbmlMHR0PZSWyqo7r9uA").body(file).post("/payments/payment");
			
			res.prettyPrint();
			
		}
	
}
