package PMSAPITEST.PMSAPITEST;
import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class TS006_DeletePizzaByID {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		RestAssured.baseURI = "http://localhost:8080/";
		given().header("Content-Type","application/json").body(PMSPAyload()).when().delete("deletePizza").then().log().all()
		.assertThat().statusCode(201);
	
	}
	
	public static String PMSPAyload()
	{
		return "{\r\n"
				+ "\"pid\":\"VegFarmhouse2\"\r\n"
				+ "}";
	}
}
