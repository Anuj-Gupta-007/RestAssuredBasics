package RestAssuredTests;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.ArrayList;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class JSONExtractor {
	
	@Test
	public void JsonExtractor() 
	{
	   RestAssured.baseURI = "https://reqres.in/api";
	   RestAssured.basePath = "/users";
	   
	   Response res = given().contentType(ContentType.JSON).log().all().get("?page=2");
	   res.prettyPrint();
	   
	   JsonPath extract = res.jsonPath();
	   ArrayList<String> al = extract.get("data");
	   
	   for(String data : al) 
	   {
		   System.out.println(data);
	   }
	}

}
