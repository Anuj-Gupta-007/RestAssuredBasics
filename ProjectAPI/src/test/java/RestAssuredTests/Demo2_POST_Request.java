package RestAssuredTests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

public class Demo2_POST_Request {
	
	public static HashMap map = new HashMap();
	
	String title = RestUtils.title();
	String body = RestUtils.body();
	String userID = RestUtils.userId();
	
	
	@BeforeMethod
	public void getData() 
	{
		map.put("Title",title);
		map.put("Body",body);
		map.put("UserId",userID);
		
		RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
		RestAssured.basePath = "/posts";
	}
	
	@Test
	public void updateResource() 
	{
		 given()
				.contentType("application/json")
				.body(map)
		.when()
				.post()
		.then()
				.statusCode(201)
				.log().all();
	}
}
