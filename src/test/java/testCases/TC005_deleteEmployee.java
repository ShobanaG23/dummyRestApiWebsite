package testCases;
//--bug--- 405 error

import static io.restassured.RestAssured.*;
import  static org.hamcrest.Matchers.*;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class TC005_deleteEmployee {

	@BeforeClass
	public void setup() {
		
		//https://dummy.restapiexample.com/api/v1/employees
		
		RestAssured.baseURI = "https://dummy.restapiexample.com";
		RestAssured.basePath = "api/v1/employees/delete/7";
	}
	
	@Test
	public void test_DeleteEmployee() {
		
		given()
		.when()
			.delete()
		.then()
		.log().all();
		
		
	}
}
