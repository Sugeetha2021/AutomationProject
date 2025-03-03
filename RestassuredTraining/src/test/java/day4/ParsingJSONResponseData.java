package day4;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;

public class ParsingJSONResponseData {
	@Test (priority=1)
	void testResponse()
	
	{
		//Approach1
		given()
		     .header("ContentType","application/json; charset=utf-8")
		     .contentType("ContentTye.JSON")
		
		.when()
		      .get("http://localhost:3000/store")
		
		.then()
		.statusCode(200)
		.body("book[1].price", equalTo("300"))
		.body("book[1].categoery", equalTo("AI"))
		.body("book[1].title",equalTo("AI book"));
		//.log().body();
		
		//Approach2
		
		Response res=
				given()
	     .contentType("ContentType.JSON")
	
	.when()
	      .get("http://localhost:3000/store");
	    Assert.assertEquals(res.getStatusCode(),200);//validation 1
	    //Assert.assertEquals(res.header("Content-Type"),"application/json; application/json");
	    
	   //String bookname= res.jsonPath().get("book[1].title").toString();
	  // Assert.assertEquals(bookname,"AI book");
		
	   JSONObject jo=new JSONObject(res.asString());//converting response into JSONObject type
	    for(int i=0;i<jo.getJSONArray("book").length();i++)
	    {
	    	String booktitle=jo.getJSONArray("book").getJSONObject(i).get("author").toString();
	    	System.out.println(booktitle);
	    	
	    }
	}
	    @Test(priority=2)
		
		void testJSONResponseBodyData()
		{
		Response res=given()
		.contentType(ContentType.JSON)
		
		.when()
		.get("http://localhost:3000/store");
		
		//JSONObject class
		
		JSONObject jo=new JSONObject(res.asString());
		
		/*for(int i=0;i<jo.getJSONArray("book").length();i++)
			
		{
			String bookTitle=jo.getJSONArray("book").getJSONObject(i).get("title").toString();
			System.out.println(bookTitle);
		}*/
		//search for title of the book
		boolean status=false;
		
		for(int i=0;i<jo.getJSONArray("book").length();i++)
			
		{
			String bookTitle=jo.getJSONArray("book").getJSONObject(i).get("title").toString();
			
			if(bookTitle.equals("Biology book"))
				
			{
				status =true;
				break;
			}
			
		}
		
		Assert.assertEquals(status,true);
		// validate total price of all the books
		double totalprice=0;
		
		for(int i=0;i<jo.getJSONArray("book").length();i++)
			
		{
			String price=jo.getJSONArray("book").getJSONObject(i).get("price").toString();
			totalprice=totalprice+Double.parseDouble(price);
		}	
		
		System.out.println("total price of books is:"+ totalprice);
		Assert.assertEquals(totalprice, 1000.00);
		
		}
	    }
	    
	    
	    
	


