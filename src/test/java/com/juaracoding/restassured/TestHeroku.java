package com.juaracoding.restassured;

import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class TestHeroku {
	
	@Test
	public void testPost() {
		JSONObject requestnew = new JSONObject();
		requestnew.put("_id", "630615f6cd2ff4d2fcd68b0a");
		requestnew.put("name", "Post");
		requestnew.put("category", "Test");
		requestnew.put("price", "7000");
		System.out.println(requestnew.toJSONString());
		
		given()
		.header("Content-Type", "application/json")
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(requestnew.toJSONString())
		.when()
		.post("https://mern-backend-8881.herokuapp.com/products")
		.then()
		.statusCode(200) //harusnya 201
		.log().all();
	}
	
	@Test
	public void testGet() {
		JSONObject requestnew = new JSONObject();
		
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
}
