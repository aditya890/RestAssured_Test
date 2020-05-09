package com.demo;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Oauth2_Test2 {
	static String accessToken;
	
	
			//Change your client id and client secret in basic method for paypal account
			//use this url to sign up on paypal 
			//https://developer.paypal.com/classic-home/
			//sign up and provide your info and don't link card  and hit the url again on providing details.
			//create an app and take ur client id and secret
	@Test(priority=1)
		public void getAccessTokenViaPreemptiveAuthentication() {
			RestAssured.baseURI = "https://api.sandbox.paypal.com";
			RestAssured.basePath = "v1";
			Response res = RestAssured.given().log().all().param("grant_type", "client_credentials").auth().preemptive()
					.basic("AcKfIwM6FB_cw3mvoPfljmy1OJnFLGaRZrbX53mmJCt_rv-cShfIXy9GLEYzc-zrXgLCkIcwhMDY9K8N",
							"EFwwhpaYLakYSCD1MTnJwDvaLVW72NBuUV9EMpnsnbWnr_epndf5fE4igqZaXHKXyvcMw_rRkJqaIrEO")
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
			
			Response res = RestAssured.given().contentType(ContentType.JSON).log().all().auth().oauth2(accessToken).body(file).post("/payments/payment");
			
			res.prettyPrint();
			
		}
}
