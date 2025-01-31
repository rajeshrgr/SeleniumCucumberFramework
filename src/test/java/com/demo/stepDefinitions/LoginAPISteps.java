package com.demo.stepDefinitions;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;

import com.demo.utils.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class LoginAPISteps extends BaseTest {
    private String apiEndPoint;
    private Response response;

	@Given("API endpoint is {string}")
	public void api_endpoint_is(String url) {
        this.apiEndPoint = url;

	}
	@When("User sends a POST request with valid credentials")
	public void user_sends_a_post_request_with_valid_credentials() {
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");
		
        Map<String, String> credentials = new HashMap<>();
        credentials.put("email", "eve.holt@reqres.in");
        credentials.put("password", "cityslicka");
        response = request.body(credentials).post(apiEndPoint);


	}
	@Then("API response status code should be {int}")
	public void api_response_status_code_should_be(int statusCode) {
		String res_statusCode= String.valueOf(response.getStatusCode());
		String actual_statusCode= String.valueOf(response.statusCode());
		Assert.assertEquals(actual_statusCode, res_statusCode);

	}
	@Then("API response should contain token")
	public void api_response_should_contain_token() {
		String token = response.jsonPath().getString("token");
        Assert.assertNotNull("Token is missing in response!", token);
        System.out.println("Login Token: " + token);
	}
}
