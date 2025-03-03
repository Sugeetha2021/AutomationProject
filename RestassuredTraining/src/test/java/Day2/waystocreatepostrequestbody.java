package Day2;
 
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
 
import java.io.File;
import java.io.FileReader;
import java.nio.file.Paths;
import java.io.FileNotFoundException;
import java.util.HashMap;
 
//1) POST request body using HashMap
public class waystocreatepostrequestbody {
//@Test(priority=1)
	void testPostusingHashmap()
	{
		HashMap data=new HashMap();
		data.put("name","sivaji");
		data.put("location","Tirupati");
		String courseArr[]= {"C++","RestAPI"};
		data.put("courses", courseArr);
		given()
		 .header("Content-Type","application/json; charset=utf-8")
		.contentType("application/json")
		.body(data)
		.when()
		  .post("http://localhost:3000/students")
		.then()
		  .statusCode(201)
		  .body("name",equalTo("sivaji"))
		  .body("location",equalTo("Tirupati"))
		  .body("courses[0]",equalTo("C++"))
		  .body("courses[1]",equalTo("RestAPI"))
		  .log().all();
		}
 
//2)Post request body using org.json
//@Test(priority=3)
	void testPostusingJsonLibrary()
	{
		JSONObject data = new JSONObject();
		data.put("name","sivaji");
		data.put("location","Tirupati");
		String courseArr[]= {"C++","RestAPI"};
		data.put("courses", courseArr);
		given()
		.header("Content-Type","application/json; charset=utf-8")
		.contentType("application/json")
		.body(data.toString())
		.when()
		  .post("http://localhost:3000/students")
		.then()
		  .statusCode(201)
		  .body("name",equalTo("sivaji"))
		  .body("location",equalTo("Tirupati"))
		  .body("courses[0]",equalTo("C++"))
		  .body("courses[1]",equalTo("RestAPI"))
		  .log().all();
		}
//3)Using POJO
	//@Test(priority=4)
	void testPostusingPOJO()
	{
		Pojo_PostRequest data=new Pojo_PostRequest();
		data.setName("sivaji");
		data.setLocation("Tirupati");
		String courseArr[]= {"C++","RestAPI"};
		data.setCourses(courseArr);
		given()
		.header("Content-Type","application/json; charset=utf-8")
		.contentType("application/json")
		.body(data)
		.when()
		  .post("http://localhost:3000/students")
		.then()
		  .statusCode(201)
		  .body("name",equalTo("sivaji"))
		  .body("location",equalTo("Tirupati"))
		  .body("courses[0]",equalTo("C++"))
		  .body("courses[1]",equalTo("RestAPI"))
		  .log().all();
		}

	//4)external json file data single data
	//@Test(priority=5)
	void testPostusingExternalJsonFile() throws FileNotFoundException
	{
        // Corrected file path
        File file = new File("./body.json");

        // Read JSON file
        FileReader fr = new FileReader(file);
        JSONTokener jt = new JSONTokener(fr);
        JSONObject data = new JSONObject(jt);
            

        // API request
        given()
            // .header("Content-Type","application/json; charset=utf-8")
            .contentType("application/json")
            .body(data.toString())
        .when()
            .post("http://localhost:3000/students")
        .then()
            .statusCode(201)
            .body("name", equalTo(data.getString("name")))  // Match with actual data
            .body("location", equalTo(data.getString("location")))
            .body("courses[0]", equalTo(data.getJSONArray("courses").getString(0)))
            .body("courses[1]", equalTo(data.getJSONArray("courses").getString(1)))
            .log().all();
    }
	//5)external json file data multiple data
	@Test(priority=6)
	void testPostUsingmultipledataExternalJsonFile() throws FileNotFoundException {
        // Corrected file path
        File file = new File("./body.json");

        // Read JSON file
        FileReader fr = new FileReader(file);
        JSONTokener jt = new JSONTokener(fr);
        JSONArray jsonArray = new JSONArray(jt); // Read as JSON array

        // Iterate through JSON array
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject data = jsonArray.getJSONObject(i);

            // API request for each student object
            given()
                .contentType("application/json")
                .body(data.toString())
            .when()
                .post("http://localhost:3000/students")
            .then()
                .statusCode(201)
                .body("name", equalTo(data.getString("name")))
                .body("location", equalTo(data.getString("location")))
                .body("courses[0]", equalTo(data.getJSONArray("courses").getString(0)))
                .body("courses[1]", equalTo(data.getJSONArray("courses").getString(1)))
                .log().all();
        }
    }
	//@Test(priority=2)
	void testDelete()
	{
		given()
		.when()
		.delete("http://localhost:3000/students/36c2")
		.then()
		.statusCode(200);
	}

}
	
	
	