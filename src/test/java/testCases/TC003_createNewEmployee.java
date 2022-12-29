package testCases;

import static io.restassured.RestAssured.*;
import  static org.hamcrest.Matchers.*;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;

public class TC003_createNewEmployee {

	@BeforeClass
	public void setup() {
		
		//https://dummy.restapiexample.com/api/v1/employees
		
		RestAssured.baseURI = "https://dummy.restapiexample.com";
		RestAssured.basePath = "api/v1/create";
	}
	
	@Test
	public void test_createNewEmployee() {
		createEmpployee();
		//createEmployeeValidation();
	}
	
	public void createEmpployee() {
		
		HashMap map = new HashMap();
		
		map.put("id", "26");
		map.put("employee_name", "lionel Messi");
		map.put("employee_salary", "5000005");
		map.put("employee_age", "39");
		map.put("profile_image", "");
		
		Response resp = 
		given()
			.body(map)
			//.header(header)
			.contentType("application/json")
		.when()
			.post()
		.then()
		.statusCode(200)
		.contentType("application/json")
		.log().all()
		.extract().response();
		
		String jsonString  = resp.asString();
		Assert.assertEquals(jsonString.contains("Successfully! Record has been added."), true);
		Assert.assertEquals(jsonString.contains("lionel Messi"), true);
	}
	
	public void createEmployeeValidation() {
	given()
	.when()
		.post()
	.then()
		.statusCode(200)
		.contentType("application/json")
	.log().all();
}
		
	}

