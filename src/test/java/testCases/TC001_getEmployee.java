package testCases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import  static org.hamcrest.Matchers.*;

public class TC001_getEmployee {
	
	@BeforeClass
	public void setup() {
		
		//https://dummy.restapiexample.com/api/v1/employees
		
		RestAssured.baseURI = "https://dummy.restapiexample.com";
		RestAssured.basePath = "api/v1/employees";
	}

	@Test
	public void test_getEmployee() {
		getEmployeeDetails();
		getEmployeeDetailsValidation();
		
	}
	
	public void getEmployeeDetails() {
		 
		given()
		.when()
			.get()
		.then()
			.log().all();
			
			 
				
	}
	
	public void getEmployeeDetailsValidation() {
		Response resp  =
		given()
		.when()
			.get()
		.then()
			.statusCode(200)
			.contentType("application/json")
			.log().all()
			.extract().response();
	
		String jsonString = resp.asString();
		Assert.assertEquals(jsonString.contains("Doris Wilder"), true);
		
		Assert.assertEquals(jsonString.contains("Successfully! All records has been fetched."), true);		 
				
	}
}
