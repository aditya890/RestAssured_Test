package com.demo;

import org.testng.annotations.Test;

import com.demo.cmplxpgo.Pet;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Deserialization_Cmlx_Rspns {
	@Test(priority=1)
	public void create() {
		RestAssured.baseURI="https://petstore.swagger.io/";
		RestAssured.basePath="/v2";
		
		String petinfo="{\r\n" + 
				"	\"id\": 16,\r\n" + 
				"	\"category\": {\r\n" + 
				"		\"id\": 0,\r\n" + 
				"		\"name\": \"sam\"\r\n" + 
				"		\r\n" + 
				"	},\r\n" + 
				"	\"name\": \"doggie\",\r\n" + 
				"	\"photoUrls\": [\r\n" + 
				"		\"www.google.com\",\r\n" + 
				"		\"www.tester.com\",\r\n" + 
				"		\"www.manual.com\"\r\n" + 
				"	],\r\n" + 
				"	\"tags\": [\r\n" + 
				"		{\r\n" + 
				"			\"id\": 0,\r\n" + 
				"			\"name\": \"mypet\"\r\n" + 
				"		},\r\n" + 
				"		{\r\n" + 
				"			\"id\": 2,\r\n" + 
				"			\"name\": \"urpet\"\r\n" + 
				"		},\r\n" + 
				"		{\r\n" + 
				"			\"id\": 3,\r\n" + 
				"			\"name\": \"iskapet\"\r\n" + 
				"		},\r\n" + 
				"		{\r\n" + 
				"			\"id\": 4,\r\n" + 
				"			\"name\": \"uskapet\"\r\n" + 
				"		}\r\n" + 
				"	],\r\n" + 
				"	\"status\": \"available\"\r\n" + 
				"}";
		Response res=RestAssured.given().contentType("application/json").body(petinfo).post("/pet");
		res.prettyPrint();
		
		
		
		
		//deserialization
		Pet re=res.getBody().as(Pet.class);
		
		//Assert.assertEquals(re.getCode(), 200);	
		
	}
	
	
}

