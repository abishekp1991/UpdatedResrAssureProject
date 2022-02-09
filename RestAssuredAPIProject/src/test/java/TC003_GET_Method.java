import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC003_GET_Method {
	@Test
	void getmethodtest() throws ParseException
	{
		RestAssured.baseURI ="http://api.intigral-ott.net/popcorn-api-rs-7.9.17";
		
		// Request object
		RequestSpecification httpRequest=RestAssured.given();
		
		//Response object
		Response response = httpRequest.request(Method.GET,"/v1/promotions?apikey=webB2BGDMSTGExy0sVDlZMzNDdUyZ");
		
		// pront response in console window
		
		String responseBody = response.getBody().asString();
		System.out.print("Response Body is:" +responseBody);
		
		//status code validation
		int statusCode = response.getStatusCode();
		System.out.print("status code is :" + statusCode);
		Assert.assertEquals(statusCode, 200);
		
		// status line verification
		String statusLine =response.getStatusLine();
		System.out.print("status line is :" + statusLine);
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
		
		
		String getname =response.jsonPath().getString("promotions[0].promotionId");
		System.out.println(getname);
		
		Assert.assertEquals(getname, "sabe movie for b2b");
		
		//Converting string response to JSON Object
		JSONObject jsonResponse = (JSONObject) new JSONParser().parse(responseBody);
		System.out.println("jsonResponse : " + jsonResponse);
		
		JSONArray promotions_array = (JSONArray) jsonResponse.get("promotions");
		Object error = null;
		if(promotions_array.size() > 0)
			error = error + "";
		else
			error = error + "/// Promotions array size is zero ///";
		

		
		
		
			
			
		}
		
	}