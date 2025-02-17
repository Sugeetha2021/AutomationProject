package day3;
import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;

public class HeaderDemo {
//@Test (priority=1)
	void testHeaders()

	{
		
		given()
		
		.when()
	       .get("https://www.google.com/")
	       
		.then()
		 .header("Content-Type","text/html; charset=ISO-8859-1")
		 .header("Content-Encoding","gzip")
		 .header("Server","gws");
		// .log().all();

	}
@Test (priority=1)
public void testGetHeaders() {
    Response res = given()
            .when()
            .get("https://www.google.com/");

    // Get a single header
    String headerValue = res.getHeader("Content-Type");
    System.out.println("The value of Content-Type header is: " + headerValue);

    // Get all headers
    extractHeaders(res);
}

// Method to extract and print all headers
public void extractHeaders(Response res) {
    Headers headers = res.getHeaders();

    // Print all headers
    for (Header header : headers) {
        System.out.println(header.getName() + " ==> " + header.getValue());
    }
}

// Main method to execute the test
public static void main(String[] args) {
	HeaderDemo apiTest = new HeaderDemo();
    apiTest.testGetHeaders();
}
}
