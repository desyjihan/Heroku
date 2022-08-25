package com.juaracoding.restassured;

import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class TestHeroku {
	
	@Test(priority = 1)
	public void testPost() {
		JSONObject requestnew = new JSONObject();
		requestnew.put("name", "Post");
		requestnew.put("category", "Test");
		requestnew.put("price", 7000);
		System.out.println(requestnew.toJSONString());
		
		given()
		.header("Content-Type", "application/json")
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(requestnew.toJSONString())
		.when()
		.post("https://mern-backend-8881.herokuapp.com/products")
		.then()
		.assertThat()
		.statusCode(200) //harusnya 201
		.log().all();
	}
	
	@Test(priority = 2)
	public void testGet() {
		JSONObject requestnew = new JSONObject();
		requestnew.put("name", "Post");
		requestnew.put("category", "Test");
		requestnew.put("price", 7000);
		
		given()
		.header("Content-Type", "application/json")
		.contentType(ContentType.JSON)
		.body(requestnew.toJSONString())
		.when()
		.get("https://mern-backend-8881.herokuapp.com/products")
		.then()
		.statusCode(200)
		.log().all();	
	}
	
	@Test(priority = 3)
	public void testPut() {
		JSONObject requestnew = new JSONObject();
		requestnew.put("name", "Post");
		requestnew.put("category", "Music");
		requestnew.put("price", 7000);
		System.out.println(requestnew.toJSONString());
		
		given()
		.header("Content-Type", "application/json")
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(requestnew.toJSONString())
		.when()
		.put("https://mern-backend-8881.herokuapp.com/products/63061633cd2ff4d2fcd68b0e")
		.then()
		.statusCode(404) // harusnya 200
		.log().all();
	}
	
	@Test(priority = 4)
	public void testPatch() {
		JSONObject requestnew = new JSONObject();
		requestnew.put("name", "Sing");
		requestnew.put("category", "Song");
		requestnew.put("price", 9000);
		System.out.println(requestnew.toJSONString());
		
		given()
		.header("Content-Type", "application/json")
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(requestnew.toJSONString())
		.when()
		.patch("https://mern-backend-8881.herokuapp.com/products/63079833c79932551ce1267e")
		.then()
		.statusCode(200)
		.log().all();
	}
	
	@Test(priority = 5)
	public void testDelete() {
		
		when()
		.delete("https://mern-backend-8881.herokuapp.com/products/63061633cd2ff4d2fcd68b0e")
		.then()
		.statusCode(200) // harusnya 204
		.log().all();
	}
	
	
}
