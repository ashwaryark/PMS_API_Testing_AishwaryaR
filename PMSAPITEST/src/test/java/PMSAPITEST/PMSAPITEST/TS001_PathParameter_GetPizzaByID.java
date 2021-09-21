package PMSAPITEST.PMSAPITEST;
import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;

public class TS001_PathParameter_GetPizzaByID {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		RestAssured.baseURI = "http://localhost:8080/";
		given().when().get("getPizza/VegSupreme1").then().log().all();
		

	}

}
