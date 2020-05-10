package com.demo;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.demo.cmplxpgo.Category;
import com.demo.cmplxpgo.Pet;
import com.demo.cmplxpgo.Tags;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

import java.io.File;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;

public class JsonSchemaValidation {
	@DataProvider
	public Object[][] dpGetWithParam() {
		Object[][] testDatas = new Object[][] { 
			new Object[] { 1, 1,"tom","jerry","www.google.com","www.ust.com","www.pst.com",11,"testing",12,"resting","available" },
			new Object[] {2, 11,"tomy","jerry","www.google.com","www.ust.com","www.pst.com",13,"testing",15,"resting","available" } };
		return testDatas;
	}
	
	@Test(dataProvider = "dpGetWithParam")
	public void createPetWithData(int petId, int cId, String cName, String name, String p1, String p2, String p3, int tId, String tName, int tId_one,String tNameOne, String status )
	{
		RestAssured.baseURI="https://petstore.swagger.io/";
		RestAssured.basePath="/v2";
		
		String rootPath = System.getProperty("user.dir");
		String filePath = rootPath+ "\\src\\test\\resources\\testdata\\schematest.json";
		File file = new File(filePath);
		
		Category c = new Category(cId,cName);
		Tags t = new Tags(tId,tName);
		Tags t1 = new Tags(tId_one,tNameOne);
		String[] ph = new String[] {p1,p2,p3};
		Tags[] ar = new Tags[] {t,t1};
		Pet pt = new Pet(petId,c,name,ph,ar,status);
		RequestSpecification request = RestAssured.given().contentType(ContentType.JSON).body(pt);
				request.log().all();
				Response res = request.post("/pet");
//				res.then().body(matchesJsonSchemaInClasspath("schematest.json")).log().all();
				
				res.then().body(matchesJsonSchema(file));
				//res.then().log().all();
	
}
}
