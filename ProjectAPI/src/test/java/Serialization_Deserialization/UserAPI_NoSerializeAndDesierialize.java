package Serialization_Deserialization;

import java.util.HashMap;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class UserAPI_NoSerializeAndDesierialize {
	
	public HashMap map = new HashMap();
	
	//Create New User
	@Test(priority=1)
	public void newUser() {
		
		map.put("name", "Test");
		map.put("job", "QQA");
		
		given()
				.contentType(ContentType.JSON)
				.body(map)
		.when()
			.post("https://reqres.in/api/users")
		.then()
				.statusCode(201)
				.assertThat().body("name", equalTo("Test"))
				.body("job", equalTo("QQA"))
				.log().all();	       
	}
	
	//Retrieve User details
	@Test(priority=2)
	public void getUserDetails() {
		
		given()
		.when()
			.get("https://reqres.in/api/users/1")
		.then()
				.statusCode(200)
				.assertThat().body("first_name", equalTo("George"))
				.body(".data.last_name", equalTo("Bluth"))
				.log().all();	
		//Not working because of incorrect JSON path expression
	}
	
}
