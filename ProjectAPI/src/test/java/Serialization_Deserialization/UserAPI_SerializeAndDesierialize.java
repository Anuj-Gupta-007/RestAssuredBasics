package Serialization_Deserialization;

import java.io.FileInputStream;
import java.util.HashMap;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class UserAPI_SerializeAndDesierialize {
	
	@Test(priority = 1)
	public void createUser()
	{
		User user = new User();
		user.setName("Test");
		user.setjob("QA");
		
		given()
			.contentType(ContentType.JSON)
			.body(user)
		.when()
			.post("https://reqres.in/api/users")
		.then()
			.statusCode(201)
			.log().all();
	}
	
	@Test(priority = 2)
	public void getUser()
	{
		User user = get("https://reqres.in/api/users/1").as(User.class);
		System.out.println(user.userRecord());
		System.out.println("=================");
		System.out.println(user.getName());
		System.out.println(user.getjob());
		//Not working
	}
}
