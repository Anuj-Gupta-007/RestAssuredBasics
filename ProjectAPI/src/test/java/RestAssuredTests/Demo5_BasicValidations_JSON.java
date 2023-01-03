package RestAssuredTests;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;

/*
1) Test Status Code
2) Logging Response
3) Verifying Single content in Response body
4) Verifying Multiple contents in Response body
5) Setting Parameters & Headers
*/

public class Demo5_BasicValidations_JSON 
{
	@Test(priority = 1)
	public void testStatusCode()
	{
		given()
		.when()
				.get("https://reqres.in/api/unknown/4")
		.then()
				.statusCode(200)
				.log().all();
	}
	
	@Test(priority = 2)
	public void testLogging()
	{
		given()
		.when()
				.get("https://reqres.in/api/users/2")
		.then()
				.statusCode(200)
				.log().all();
	}
	
	@Test(priority = 3)
	public void testSingleContent()
	{
		given()
		.when()
				.get("https://jsonplaceholder.typicode.com/todos/1")
		.then()
				.statusCode(200)
				.assertThat().body("title", equalTo("delectus aut autem"))
				.header("Content-Type", "application/json; charset=utf-8")
				.log().all();
		//Need To ASK
		//Script is failing for validating the data of "https://reqres.in/api/users/2"
		
	}
	
	@Test (priority = 4)
	public void testMultipleContent()
	{
		 given()
		.when()
				.get("https://reqres.in/api/unknown")
		.then()
				.statusCode(200)
				//.body("$.data.[year]", hasItems("2000","2001","2002","2003","2004","2005"))
				.body("$.data[1].year",equalTo("2001"))
				.log().all();
		//Need To ASK
		//Script is failing for validating the data of "https://reqres.in/api/users/2"
		
	}
	
	@Test (priority = 5)
	public void testParamsAndHeaders()
	{
		given()
				.param("MyName","Anuj")
				.header("MyHeader", "India")
		.when()
				.get("https://reqres.in/api/unknown")
		.then()
				.statusCode(200)
				.log().all();
		//Need To ASK
		//Script is failing for validating the data of "https://reqres.in/api/users/2"
		
	}
}