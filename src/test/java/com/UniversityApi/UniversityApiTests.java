package com.UniversityApi;


import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class UniversityApiTests {
	
	@BeforeClass
	public void setup() {
		// Set the base url
		baseURI = "http://127.0.0.1:4010/";
	}
	
	public void testGetUniversity() {

		given().basePath("university").log().all().when().get().then().log().all().statusCode(200);
	}
	@Test
	public void testurlpatherror() {

		given().baseUri("http://127.0.0.1:40/").basePath("university").log().all().when().get().then().log().all().statusCode(200);
	}
	@Test
	public void testGetUniversityInfo() {

		given().basePath("university").header("Content-Type", "application/json").header("api_key", "f3c84cbb-1f9a-4b87-bb5b-2d1691b24e1e").param("universityName", "University of Toronto ").log().all().when().get()
				.then().log().all().statusCode(200);
	}
	
	
	@Test
	public void test422InvalidRequest() {

		given().basePath("university").header("Content-Type", "application/json").header("api_key", "f3c84cbb-1f9a-4b87-bb5b-2d1691b24e1e").log().all().when().put()
				.then().log().all().statusCode(200);
	}
	@Test
	public void test401Unauthorized() {

		given().basePath("university").header("Content-Type", "application/json").header("apikey", "1234").param("universityName", "University of Toronto ").log().all().when().get()
				.then().log().all().statusCode(200);
	}
	@Test
	public void testCreateUniversity() {

		
		
		given().basePath("university").header("Content-Type", "application/json").header("api_key", "f3c84cbb-1f9a-4b87-bb5b-2d1691b24e1e").log().all().when()
				.post().then().log().all().statusCode(201);
	}
	@Test
	public void testDeleteUniversity() {

		
	
		given().basePath("university").header("Content-Type", "application/json").header("api_key", "f3c84cbb-1f9a-4b87-bb5b-2d1691b24e1e").param("universityName", "University of Toronto ").log().all().when()
				.delete().then().log().all().statusCode(204);
	}
	@Test
	public void test404notfound() {

		given().basePath("university").header("Content-Type", "application/json").header("api_key", "f3c84cbb-1f9a-4b87-bb5b-2d1691b24e1e").pathParam("universityID", 978).log().all().when().get("/{universityID}").then().log().all()
				.statusCode(200);
	}
	
	@Test
	public void testunencodedParameter() {

		
	
		given().basePath("university{universityID}").header("Content-Type", "application/json").header("api_key", "f3c84cbb-1f9a-4b87-bb5b-2d1691b24e1e").pathParam("universityID",978).log().all().when()
				.get("/{universityI}").then().log().all().statusCode(201);
	}
	@Test
	public void testupdateUniversity() {

		
	
		given().basePath("university{universityID}").header("Content-Type", "application/json").header("api_key", "f3c84cbb-1f9a-4b87-bb5b-2d1691b24e1e").pathParam("universityID", 978).log().all().when()
				.put().then().log().all().statusCode(201);
	}
	@Test
	public void testGetUniversityWithPathParams() {

		given().basePath("university").header("Content-Type", "application/json").header("api_key", "f3c84cbb-1f9a-4b87-bb5b-2d1691b24e1e").pathParam("universityID", 978).log().all().when().get("/{universityID}").then().log().all()
				.statusCode(200);
	}
	@Test
	public void testGetAllUniversitiesInfo() {

		given().basePath("universities").header("Content-Type", "application/json").header("api_key", "f3c84cbb-1f9a-4b87-bb5b-2d1691b24e1e").log().all().when().get()
				.then().log().all().statusCode(200);
	}
}
