package testCases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

//-----BUG FOUND----instead of fetching the single employee detail, it shows as not found(404) error.
// critical defect

public class TC002_getSingleEmployee {

	@BeforeClass
	public void setup() {
		
		//https://dummy.restapiexample.com/api/v1/employees
		
		RestAssured.baseURI = "https://dummy.restapiexample.com";
		RestAssured.basePath = "api/v1/employees/23";
	}
	
	@Test
	public void test_getSingleEmployee() {
		getSingleEmployeeDetail();
		getSingleeEmployeeDetailValidation();
	}
	
	public void getSingleEmployeeDetail() {
		given()
		.when()
			.get()
		.then()
		.log().all();
		
	}
	
	public void getSingleeEmployeeDetailValidation() {
		
		Response resp = 
				given()
				.when()
					.get()
				.then()
					.statusCode(404)
					.contentType("application/json")
					.log().body()
					.extract().response();
		
		String jsonString  = resp.asString();
		Assert.assertEquals(jsonString.contains("Error Occured! Page Not found, contact rstapi2example@gmail.com"), true);
		
	}
}
