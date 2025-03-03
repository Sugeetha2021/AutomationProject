package day5;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.List;
 

class ParsingXMLResponse {

	//@Test (priority=1)
	
	void testXMLresponses()
	 {
		
	/*given()
	
	
	.when()
	 .get("https://mocktarget.apigee.net/xml")
     .then()
     
	  .statusCode(200)
	  .header("Content-Type","application/xml; charset=utf-8")
	  .body("root.city", equalTo("San Jose"));
	  
	
	
	 }*/
		
	
	
		/* given()
			
			.when()
			 .get("https://www.quickpickdeal.com/files/xml/product_sample_file.xml")
			 
			 .then()
			 .statusCode(200)
			 .header("Content-Type","text/xml")
			 .body("root.row[1].producttype", equalTo("HardGood"))
			 .body("root.row[0].category[1].name", equalTo("Cell Phone Accessories"));
	
	 }*/
	//Approach 2
		
		Response res=
				given()
				
				.when()
				.get("https://www.quickpickdeal.com/files/xml/product_sample_file.xml");
		       Assert.assertEquals(res.getStatusCode(), 200);
		       Assert.assertEquals(res.header("Content-Type"), "text/xml");
		      String pageNo=res.xmlPath().get("root.row[0].producttype").toString();
		      Assert.assertEquals(pageNo, "HardGood");
		       
	 }
	
	@Test (priority=2)
	void testresponse()
	{
	 
 Response res=
		 given()
		 
		 .when()
		 .get("https://www.quickpickdeal.com/files/xml/product_sample_file.xml");
 
         XmlPath XmlObj=new XmlPath(res.asString());
         
         List<String>products=XmlObj.getList("root.row.category.name");
         Assert.assertEquals(products.size(), 360);
         
         List<String>productnames=XmlObj.getList("root.row.category.name");
         boolean status=false;
         for(String name:productnames)
         {
        	//System.out.println(name);
        	 if(name.equals("Cell Phones"))
        		 
        	 {
        		 status=true;
        		 break;
        	 }
         }
         Assert.assertEquals(status,true);
         
}
	

	

	
	
}
	
