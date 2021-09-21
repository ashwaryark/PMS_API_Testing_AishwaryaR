package PMSAPITEST.PMSAPITEST;
import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import junit.framework.Assert;

public class TS008_EndToEndTesting {

	private static String response;
	private static String vID;
	private static String vMSG;

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		
		CREATE_CRUD();
		Thread.sleep(5000);
		GET_CRUD();
		Thread.sleep(5000);
		UPDATE_CRUD();
		Thread.sleep(15000);
		DELETE_CRUD();	

	}
	
	public static void CREATE_CRUD() throws IOException
	{
		RestAssured.baseURI = "http://localhost:8080/";
		response = given().header("Content-Type","application/json").header("Connection","keep-alive").body(PMSPayload())
		.when().post("/addPizza")
		.then().assertThat().statusCode(201).header("unique",containsString("VegFarmhouse")).extract().response().asString();
		
		System.out.println(response);
		System.out.println("-------------------------------");
		
		JsonPath jpath = new JsonPath(response);
		vID = jpath.getString("id");
		vMSG = jpath.getString("msg");
		System.out.println(vID);
		System.out.println(vMSG);
	}
	
	public static void GET_CRUD()
	{
		System.out.println("-------------------------------");
		response = given().when().get("getPizza/" + vID).then().extract().response().asString();
		JsonPath jpath = new JsonPath(response);
		Assert.assertEquals(vID, jpath.getString("pid"));
		System.out.println("-------------------------------");
	}
	
	public static void UPDATE_CRUD()
	{
		System.out.println("-------------------------------");
		given().header("Content-Type","application/json").body(updatePizza())
		.when().put("updatePizza/"+vID)
		.then().log().all();
		System.out.println("-------------------------------");
	}
	
	public static void DELETE_CRUD()
	{
		System.out.println("-------------------------------");
		given().header("Content-Type","application/json").body(deletePizza())
		.when().delete("deletePizza/")
		.then().log().all();
		System.out.println("-------------------------------");
	}
	
	public static String PMSPayload()
	{
		return "{\r\n"
				+ "\"productname\":\"VegFarmhouse\",\r\n"
				+ "\"price\":\"450\"\r\n"
				+ "}";
	}
	
	public static String updatePizza()
	{
		return "{\r\n"
				+ "\"productname\":\"VeggieSupreme\",\r\n"
				+ "\"price\":\"350\"\r\n"
				+ "}";
		
	}
	
	public static String deletePizza()
	{
		return "{\r\n"
				+ "\"pid\":\""+vID+"\"\r\n"
				+ "}";
	}

}
