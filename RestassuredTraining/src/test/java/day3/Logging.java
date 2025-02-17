package day3;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class Logging {

@Test(priority=1)	
	void logs()
	{
		
		given()
		
		
		.when()
		  .get("https://reqres.in/api/users?page=2")
		
		.then()
		  //.log().all(); //it will print all responses
		    //.log().body();//it will print response body
		
		      // .log().cookies();//it will print cookies
		         .log().headers();//it will print headers
}
	}
