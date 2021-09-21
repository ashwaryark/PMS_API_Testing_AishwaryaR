package PMSAPITEST.PMSAPITEST;
import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;

public class TS002_QueryParameter_GetPizzaByName {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		RestAssured.baseURI = "http://localhost:8080/";
		given().param("ProductName", "VegMargherita").when().get("getPizza/").then().log().all();
		

	}
	
	
}
