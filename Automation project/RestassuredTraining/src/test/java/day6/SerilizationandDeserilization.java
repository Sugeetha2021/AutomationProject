package day6;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;




public class SerilizationandDeserilization {
	
	@Test(priority=1)
	
	void convertPojo2Json() throws JsonProcessingException
	{	
		//converting java obj using pojo class
		
		Student stupojo=new Student();
		
		stupojo.setName("sivaji");
		stupojo.setLocation("Tirupati");
		
		String courseArr[]= {"C++","RestAPI"};
		stupojo.setCourses(courseArr);
	
	//convert java obj to json obj(serialization)
		
		ObjectMapper objMapper=new ObjectMapper();
		String jsondata=objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(stupojo);	
		
		System.out.println(jsondata);
	}

	
	@Test(priority=2)
	void convertjson2pojo() throws JsonProcessingException
	{	
		
		
		String jsondata= "{\r\n"
				+ "  \"name\" : \"sivaji\",\r\n"
				+ "  \"location\" : \"Tirupati\",\r\n"
				+ "  \"courses\" : [ \"C++\", \"RestAPI\" ]\r\n"
				+ "}";
		
	ObjectMapper objMapper=new ObjectMapper();
	Student stupojo=objMapper.readValue(jsondata,Student.class);//convert json to pojo
	
	System.out.println("Name:"+stupojo.getName());
	System.out.println("Location:"+stupojo.getLocation());	
	System.out.println("Course 1:"+stupojo.getCourses()[0]);
	System.out.println("course 2:"+stupojo.getCourses()[1]);
}
	}
