package PMSAPITEST.PMSAPITEST;
import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;

import io.restassured.RestAssured;

public class TS003_AddPizzaNewProduct {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		RestAssured.baseURI = "http://localhost:8080/";
		given().header("Content-Type","application/json").body(PMSPAyload()).when().post("addPizza/").then().log().all()
		.assertThat().statusCode(201)
		.header("unique",containsString("VegFarmhouse")).body("msg",equalTo("Success : Product is Added"));
		

	}
	
	public static String PMSPAyload()
	{
		return "{\r\n"
				+ "\"productname\":\"VegFarmhouse\",\r\n"
				+ "\"price\":\"450\"\r\n"
				+ "}";
	}
}
