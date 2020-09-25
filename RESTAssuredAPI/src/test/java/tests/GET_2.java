package tests;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import static org.hamcrest.Matchers.*;

public class GET_2 {

	
	@Test
	public void TestCase_1()
	{
		given()
		.get("https://reqres.in/api/users?page=2")
		
		// Find the data, that is the id ( 0 then next 1 )  
		.then().statusCode(200).body("data.id[1]", equalTo(8)).   
		
		// Get the first name
		body("data.first_name", hasItems("Michael","Lindsay", "Tobias", "Byron", "George", "Rachel"));     
		
	}
}
