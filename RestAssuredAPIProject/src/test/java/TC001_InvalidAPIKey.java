import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC001_InvalidAPIKey {
	
	@Test
	void postmethodtest()
	{
		RestAssured.baseURI ="http://api.intigral-ott.net/popcorn-api-rs-7.9.17";
		
		// Request object
		RequestSpecification httpRequest=RestAssured.given();
		
		//Response object
		Response response = httpRequest.request(Method.GET,"/v1/promotions?apikey=GDMSTGExy0sVDlZMzNDdUyF");
		
		// pront response in console window
		
		String responseBody = response.getBody().asString();
		System.out.print("Response Body is:" +responseBody);
		
		//status code validation
		int statusCode = response.getStatusCode();
		System.out.print("status code is :" + statusCode);
		Assert.assertEquals(statusCode, 403);
		
		// status line verification
		String statusLine =response.getStatusLine();
		System.out.print("status line is :" + statusLine);
		Assert.assertEquals(statusLine, "HTTP/1.1 403 Forbidden");
		
		String geterrorcode=response.jsonPath().getString("error.code");
		System.out.println(geterrorcode);
		Assert.assertEquals(geterrorcode, "8001");
		
				
	}
	
}
