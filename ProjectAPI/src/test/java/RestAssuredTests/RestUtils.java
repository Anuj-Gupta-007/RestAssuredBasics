package RestAssuredTests;

import org.apache.commons.lang3.RandomStringUtils;

public class RestUtils 
{
	public static String title() 
	{
		String generatedString = RandomStringUtils.randomAlphabetic(1);
		return("Rest_Title"+generatedString);
	}
	
	public static String body() 
	{
		String generatedString = RandomStringUtils.randomAlphabetic(2);
		return("Rest_Body"+ generatedString);
	}
	
	public static String userId() 
	{
		String generatedString = RandomStringUtils.randomNumeric(2);
		return(generatedString);
	}
}
