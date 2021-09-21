package PMSAPITEST.PMSAPITEST;
import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class TS007_DeleteAllRecords {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		RestAssured.baseURI = "http://localhost:8080/";
		given().header("Content-Type","application/json").when().delete("deleteAll").then().log().all()
		.assertThat().statusCode(201);
	
	}

}
