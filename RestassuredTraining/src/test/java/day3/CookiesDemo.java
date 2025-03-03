package day3;

import org.testng.annotations.Test;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;


public class CookiesDemo {
	//@Test(priority=1)
void testCookiesDemo()

{
	
	given()
	
	.when()
       .get("https://www.google.com/")
       
	.then()
	 .cookie("AEC","AVcja2cTNy7mZ85kSO5hm6_6G7UKMyuBURD23cVQYMjVnIF1IB9D9oa1DgY")
	 .log().all();

}
	@Test(priority=2)
	void getCookiesInfo()

	{
		
		Response res= given()
		
		.when()
	       .get("https://www.google.com/");
		//TO GET SINGLE COOKIE
		
		// String cookie_value=res.getCookie("AEC");
		// System.out.println("Value of cookie is====>"+cookie_value);
		
		//TO get multiple cookies
		
		    Map<String,String>Cookies_Values=res.getCookies();
	        System.out.println(Cookies_Values.keySet());
	       for(String k:Cookies_Values.keySet())
	     {

	      String cookie_value=res.getCookie(k);
	      System.out.println(k+"==>  "+cookie_value);
	    	  
	}	
	}
}