package day3;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class Pathandqueryparameters {
	
	//@Test
	void testPathandQueryparameters1()
	{
		//https://reqres.in/api/users?page=2&id=5
		given()
		 
		 .pathParam("mypath", "users")
		 .queryParam("page", 1)
		 .queryParam("id", 1)
		
		.when()
		  .get("https://reqres.in/api/{mypath}")
		
		.then()
		  .statusCode(200)
          .log().all();		
		
}
	
	@Test
	void testPathandQueryparameters()
	{
		//http://localhost:3000/students
		given()
		 
		 .pathParam("mypath", "students")
		 .queryParam("page", 1)
		 .queryParam("id", 2)
		
		.when()
		  .get("http://localhost:3000/{mypath}")
		
		
		.then()
		  .statusCode(200)
          .log().all();		
		
}
}