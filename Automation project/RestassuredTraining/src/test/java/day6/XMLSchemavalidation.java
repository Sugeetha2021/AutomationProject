package day6;

import org.testng.annotations.Test;

import io.restassured.matcher.RestAssuredMatchers;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class XMLSchemavalidation {

	@Test
	void testxmlschemavalidation()
	{
	
		given()
		
		.when()
			.get("https://www.quickpickdeal.com/files/xml/product_sample_file.xml")
			
		.then()
			.assertThat().body(RestAssuredMatchers.matchesXsdInClasspath("XMLSchema.xsd"));
		
		
	
}
}
