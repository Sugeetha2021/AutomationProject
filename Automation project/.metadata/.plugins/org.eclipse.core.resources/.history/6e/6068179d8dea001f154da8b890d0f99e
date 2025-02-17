package Day1;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.response.ValidatableResponseOptions;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

public class HTTPRequests {
	int id;
	
	@Test(priority=1)
	void getUsers()
	{
	
	given()
	
	.when()
	.get("https://reqres.in/api/users?page=2")
	
	.then()
	.statusCode(200)
    .body("page", equalTo(2))
	.log().all();
}
	@Test(priority=2)
	void CreateUser()
	{
	
		HashMap data=new HashMap();
		data.put("name","sugeetha");
		data.put("job", "Lead test");
		
		id=given()
		.contentType("application/json")
		.body(data)
		
		.when()
		.post("https://reqres.in/api/users")
		.jsonPath().getInt("id");
		
		//.then()
		//.statusCode(201)
		//.log().all();
				
}
	
	@Test(priority=3,dependsOnMethods= {"CreateUser"})
	void updateUser()
	{
		HashMap data=new HashMap();
		data.put("name","Sugeetha Thiyagarajan");
		data.put("job", "Lead Test QA");
		
		given()
		 .contentType("application/json")
		.body(data)
		
		.when()
		.put("https://reqres.in/api/users/"+id)
		
		
		.then()
		.statusCode(200)
		.log().all();	
}
	@Test(priority=4,dependsOnMethods= {"CreateUser"})
	void deleteUser()
	{
		given()
		
		.when()
		 .delete("https://reqres.in/api/users/"+id)
		 
		.then()
		.statusCode(204)
		.log().all();
		
		
		
		}
	
	
	
}
