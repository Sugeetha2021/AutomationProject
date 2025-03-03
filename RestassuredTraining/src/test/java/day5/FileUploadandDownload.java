package day5;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;

import org.testng.annotations.Test;

public class FileUploadandDownload {

  @Test	(priority=1)
	void SingleFileUpload()
	{
		
	
		File myfile=new File("C:\\FSS_Document\\FSS_Projects\\Automation\\Selenium_syntax.txt");
		given()
		.multiPart("file",myfile)
		.contentType("multipart/form-data")
		.when()
		 .post("http://localhost:8080/uploadFile")
		
		.then()
		.statusCode(200)
		.body("fileName", equalTo("Selenium_syntax.txt"))
		.log().all();
	
	}
	
	
	@Test(priority=2)
void MultipleFileUpload()
{
	

	File myfile1=new File("C:\\FSS_Document\\FSS_Projects\\Automation\\Selenium_syntax.txt");
	File myfile2=new File("C:\\FSS_Document\\FSS_Projects\\Automation\\selenium interview questions.txt");
	
	//File filearr[]= {myfile1,myfile2};
	
	given()
	.multiPart("files",myfile1)
	.multiPart("files",myfile2)
	//.multiPart("files",filearr)
	.contentType("multipart/form-data")
	
	.when()
	 .post("http://localhost:8080/uploadMultipleFiles")
	
	.then()
	.statusCode(200)
	.body("[0].fileName", equalTo("Selenium_syntax.txt"))
	.body("[1].fileName", equalTo("selenium interview questions.txt"))
	.log().all();
}
	
	@Test
	
	void testDownloadfie()
	{
	
	given()
	
	.when()
	.get("http://localhost:8080/downloadFile/Selenium_syntax.txt")
	
	.then()
	.statusCode(200)
	.log().all();
}

}