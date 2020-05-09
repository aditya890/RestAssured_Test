package com.demo;


import org.junit.Test;

import com.demo.cmplxpgo.Category;
import com.demo.cmplxpgo.Pet;
import com.demo.cmplxpgo.Tags;


import io.restassured.RestAssured;
import io.restassured.response.Response;


public class Cmplx_Serializ_Deserialize {

	@Test()
	public void create() {
		
		RestAssured.baseURI="https://petstore.swagger.io/";
		RestAssured.basePath="/v2";
		
		//serialization
		Category ct=new Category(10,"ram");
		String[] photoUrls=new String[] {"www.google.com",
				"www.tester.com",
				"www.manual.com"};
		
		Tags t=new Tags(23,"hari");
		Tags t1=new Tags(45,"mark");
		Tags[] tar=new Tags[] {t,t1};
		
		Pet pt=new Pet(100,ct,"Adi",photoUrls,tar,"Available");

		Response res=RestAssured.given().contentType("application/json").body(pt).post("/pet");
		res.prettyPrint();
		
		
	
		//deserialization
				Pet re=res.getBody().as(Pet.class);
		
		
	}
	
	
	
}
