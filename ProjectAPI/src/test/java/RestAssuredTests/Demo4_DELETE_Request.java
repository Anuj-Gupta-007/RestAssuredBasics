package RestAssuredTests;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Demo4_DELETE_Request {

	@Test
	public void deleteResource() {
		RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
		RestAssured.basePath = "/posts/1";
		Response response =

				given()
				.when()
						.delete()
				.then()
						.statusCode(200).statusLine("HTTP/1.1 200 OK")
						.assertThat()
						.header("Content-Type", "application/json; charset=utf-8")
						.log().all()
						.extract().response();

		String jsonAsString = response.asString();
		Assert.assertEquals(jsonAsString, "{}");

	}
}
