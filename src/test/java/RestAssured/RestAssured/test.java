package RestAssured.RestAssured;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class test {

	@Test(priority = 0)
	public void TestStatusCode() {
		Response rest = RestAssured.get(
				"https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22");
		int actual = rest.getStatusCode();
		System.out.println(actual);
		Assert.assertEquals(actual, 200);
	}

	@Test(priority = 1)
	public void TestResponseBody() {
		Response rest = RestAssured.get(
				"https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22");
		String ResponseBody = rest.asString();
		System.out.println(ResponseBody);
		Assert.assertEquals(ResponseBody,
				"{\"coord\":{\"lon\":-0.13,\"lat\":51.51},\"weather\":[{\"id\":300,\"main\":\"Drizzle\",\"description\":\"light intensity drizzle\",\"icon\":\"09d\"}],\"base\":\"stations\",\"main\":{\"temp\":280.32,\"pressure\":1012,\"humidity\":81,\"temp_min\":279.15,\"temp_max\":281.15},\"visibility\":10000,\"wind\":{\"speed\":4.1,\"deg\":80},\"clouds\":{\"all\":90},\"dt\":1485789600,\"sys\":{\"type\":1,\"id\":5091,\"message\":0.0103,\"country\":\"GB\",\"sunrise\":1485762037,\"sunset\":1485794875},\"id\":2643743,\"name\":\"London\",\"cod\":200}");
	}

	@Test(priority = 2)
	public void TestResponseTime() {
		Response rest = RestAssured.get(
				"https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22");
		long ResponseTime = rest.getTime();
		System.out.println(ResponseTime);
	}
	
	@Test(priority = 3)
	public void TestContentType() {
		Response rest = RestAssured.get(
				"https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22");
		String ContentType = rest.contentType().toString();
		System.out.println(ContentType);
	}
}
