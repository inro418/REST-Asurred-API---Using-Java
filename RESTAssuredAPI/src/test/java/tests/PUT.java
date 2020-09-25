package tests;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class PUT {

	@Test
	public void TestCase_01()
	{
		 Map<String, Object> map =  new HashMap<String, Object>();
		 
		 map.put("name", "morpheus");
		 map.put("job", "leader");  
		 
		 System.out.println(map);
		 
		 JSONObject request = new JSONObject(map);
		 
		 System.out.println(request);
		 
		 given().
		     header("content-Type", "application/json").
		     
		     contentType(ContentType.JSON).
		     
		     accept(ContentType.JSON).
		     
		     body(request.toJSONString()).
		     
		 when().
		     put("https://reqres.in/api/users/2").
		     
		 then().statusCode(200).
		 log().all();
	}
}
