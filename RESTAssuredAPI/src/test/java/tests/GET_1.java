package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;

public class GET_1 {

	@Test
	public void TestCase_01() {
		// URL
		Response response = RestAssured.get("https://reqres.in/api/users?page=2");

		System.out.println(response.asString());
		System.out.println(response.getBody());
		System.out.println(response.getStatusCode());
		System.out.println(response.getStatusLine());
		System.out.println(response.getHeader("content-type"));
		System.out.println(response.getTime());

		// Correct HTTP Request
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);

		// if you want it to fail
		// Assert.assertEquals(statusCode, 201);
	}

	@Test
	public void TestCase_02() {
		given()

				.get("https://reqres.in/api/users?page=2")

				.then()
                 
				// Find the data, that is the id ( it always start with 0 )
				.statusCode(200).body("data.id[0]", equalTo(7));
	}
}
