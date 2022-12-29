package testCases;

//---bug--- 405 error found--something is broken-------------

import static io.restassured.RestAssured.*;
import  static org.hamcrest.Matchers.*;

import java.util.HashMap;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class TC004_updateEmployeeDetails {
	
	@BeforeClass
	public void setup() {
		
		//https://dummy.restapiexample.com/api/v1/employees
		
		RestAssured.baseURI = "https://dummy.restapiexample.com";
		RestAssured.basePath = "api/v1/employees/update/23";
	}

	@Test
	public void test_updtaeEmplyeeDetails() {
		
		/* "id": 23,
         "employee_name": "Caesar Vance",
         "employee_salary": 106450,
         "employee_age": 21,
         "profile_image": ""*/
        	 
		HashMap map = new HashMap();
		map.put("employee_name", "Messi");
		
		given()
			.body(map)
			.contentType("application/json")
		.when()
			.put()
		.then()
		.log().all();
		
	}

}
