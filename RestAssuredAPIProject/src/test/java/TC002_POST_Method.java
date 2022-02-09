import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC002_POST_Method {

	@Test
	void postmethodtest()
	{
		RestAssured.baseURI ="https://reqres.in";
		
		// Request object
		RequestSpecification httpRequest=RestAssured.given();
		
		// Request Payload
		JSONObject requestparams = new JSONObject();
		
		requestparams.put("name", "tester");
		requestparams.put("job", "leader");
		
		httpRequest.header("Content-Type", "application/json");
		
		httpRequest.body(requestparams.toJSONString());
		//Response object
		Response response = httpRequest.request(Method.POST,"/api/users");
		
		// pront response in console window
		
		String responseBody = response.getBody().asString();
		System.out.print("Response Body is:" +responseBody);
		
		//status code validation
		int statusCode = response.getStatusCode();
		System.out.print("status code is :" + statusCode);
		//Assert.assertEquals(statusCode, 403);
		
		// status line verification
		String statusLine =response.getStatusLine();
		System.out.print("status line is :" + statusLine);
		//Assert.assertEquals(statusLine, "HTTP/1.1 403 Forbidden");
		
		
		String getname =response.jsonPath().get("name");
		System.out.println(getname);
	}
	
}
