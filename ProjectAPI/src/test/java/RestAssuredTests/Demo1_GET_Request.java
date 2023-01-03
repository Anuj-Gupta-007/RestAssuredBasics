package RestAssuredTests;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Demo1_GET_Request 
{
	
	@Test
	public void getWeatherDetails() 
	{
		
		RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
		RestAssured.basePath = "/todos";
		given()
		.when()
				.get("/1")
		.then()
				.statusCode(200)
				.statusLine("HTTP/1.1 200 OK")
				.assertThat().body("title", equalTo("delectus aut autem"))
				.header("Content-Type", "application/json; charset=utf-8")
				.log().all();
		
		//To print the response in pretty format
		  Response response =
		  given().contentType(ContentType.JSON).log().all().get("/1");
		  response.prettyPrint();
		  
		  //Get Specific data
		  String title = given().contentType(ContentType.JSON).get("/1").then().extract().path("title");
		  System.out.println("Title is: " +title);
		 
		  //OR use JSONPath class to extract the data instead of writing the above LoC
		  JsonPath extractor = response.jsonPath();
		  String title1 = extractor.get("title");
		  System.out.println("Title is: " +title1);

	}
}
