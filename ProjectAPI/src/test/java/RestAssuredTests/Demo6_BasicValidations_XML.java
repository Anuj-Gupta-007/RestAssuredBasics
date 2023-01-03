package RestAssuredTests;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

/*
1) Verifying Single content in XML Response
2) Verifying Multiple contents in XML Response
3) Verifying all the content in XML response in one go using XPath with text() function
4) Find values using XML Path in XML response 
*/

public class Demo6_BasicValidations_XML 
{
	@Test(priority = 1)
	public void testSingleContent()
	{
		given()
		.when()
				.get("http://thomas-bayer.com/sqlrest/CUSTOMER/15/")
		.then()
				.body("CUSTOMER.ID", equalTo("15"))
				.log().all();
	}
	
	@Test(priority = 2)
	public void testMultipleContent()
	{
		given()
		.when()
				.get("http://thomas-bayer.com/sqlrest/CUSTOMER/15/")
		.then()
				.body("CUSTOMER.ID", equalTo("15"))
				.body("CUSTOMER.FIRSTNAME", equalTo("Bill"))
				.body("CUSTOMER.LASTNAME", equalTo("Clancy"))
				.body("CUSTOMER.STREET", equalTo("319 Upland Pl."))
				.body("CUSTOMER.CITY", equalTo("Seattle"));
	}
	
	@Test(priority = 3)
	public void testMultipleContentInOneGo()
	{
		given()
		.when()
				.get("http://thomas-bayer.com/sqlrest/CUSTOMER/15/")
		.then()
				.body("CUSTOMER.text()", equalTo("15BillClancy319 Upland Pl.Seattle"));
	}
	
	@Test(priority = 4)
	public void testUsingXMLXpath1()
	{
		given()
		.when()
				.get("http://thomas-bayer.com/sqlrest/CUSTOMER/15/")
		.then()
				.body(hasXPath("/CUSTOMER/FIRSTNAME", containsString("Bill")));
	}
	
	@Test(priority = 5)
	public void testUsingXMLXpath2()
	{
		given()
		.when()
				.get("http://thomas-bayer.com/sqlrest/INVOICE/")
		.then()
				.body(hasXPath("/INVOICEList/INVOICE[text()='12']"));
	}
}
