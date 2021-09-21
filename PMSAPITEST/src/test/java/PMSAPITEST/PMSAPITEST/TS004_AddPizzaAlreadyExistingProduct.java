package PMSAPITEST.PMSAPITEST;
import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class TS004_AddPizzaAlreadyExistingProduct {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		RestAssured.baseURI = "http://localhost:8080/";
		given().header("Content-Type","application/json").body(PMSPAyload()).when().post("addPizza/").then().log().all()
		.assertThat().statusCode(202).header("unique",containsString("VegFarmhouse")).body("msg",equalTo("FAILED : Product Already Exists"))
		.and().body("id", equalTo("VegFarmhouse1"));
	
	}
	
	public static String PMSPAyload()
	{
		return "{\r\n"
				+ "\"productname\":\"VegFarmhouse\",\r\n"
				+ "\"price\":\"450\"\r\n"
				+ "}";
	}
}
