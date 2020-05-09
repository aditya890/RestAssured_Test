package com.demo;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class OAuth1_Test {
	     
	
	    @Test
		public void oAuthOneTest() {
			Response res = RestAssured.given().log().all().baseUri("https://api.twitter.com/1.1/statuses").auth()
					.oauth("tpm97q7gPXm4g3EA0oUmtmBCq", "UyFugasDCBN9HfaT0uDe9Sbtvs5Vdh6LfznQxAqFhwgUTQACaT",
							"945645824456953856-ZIjXUDRrzQ4dGSKkT294tvqcIZy1GKl",
							"RY0CXsAwTWDmsuPJGV6QOJJ1XwjkSYuTL8pYUNVYk8b4v")
					.queryParam("status", "This tweet was created using rest assured 667543217").post("/update.json");
			res.prettyPrint();
			
			Assert.assertEquals(res.getStatusCode(), 200);
			res.prettyPrint();
		}

		
}
