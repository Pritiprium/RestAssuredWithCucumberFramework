package com.StepDefinition;

import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;

import java.io.IOException;

import org.testng.Assert;

import com.API_Test.Schema_Stub;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.github.tomakehurst.wiremock.WireMockServer;
import com.model.CarList;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;

public class Test_Steps extends Schema_Stub {

	@Given("Mocking Server Using WireMock Server SetUp")
	public void mocking_Server_Using_WireMock_Server_SetUp() {
		wiremockserver = new WireMockServer(options().port(9090));
		wiremockserver.start();
		System.out.println("Wiremock Server Started-->" + wiremockserver.port());

	}

	@When("Stubing Schema")
	public void stubing_Schema() throws JsonParseException, JsonMappingException, IOException {

		stubbing_Schema();
	}

	@When("Getting Responce of all Cars")
	public void getting_Responce_of_all_Cars() throws JsonParseException, JsonMappingException, IOException {

		String hostName = "http://localhost:9090";
		String URI = "/get_cars";
		String URL = hostName + URI;
		RestAssured.baseURI = URL;
		response = RestAssured.given().contentType("application/json").get();
		CarList carList = mapping_with_Response(response.asString()); //CALLING THIS METHOD AND PASSING RESPONSE AS PARAMETER
		System.out.println(response.asString());
		System.out.println(carList);
		System.out.println("carList  >>>>>> " + carList.getCars().length);

	}

	@When("Getting Status Code")
	public void getting_Status_Code() {

		System.out.println(response.statusCode());
		Assert.assertEquals(200, response.getStatusCode());
	}

	@Then("Print the blue Tesla car")
	public void print_the_blue_Tesla_car() {

		print_Blue_cars();
	}

	@Then("Print Note also of blur Car")
	public void print_Note_also_of_blur_Car() {

		System.out.println("--------printing Blue Cars's Notes-----------");

		notes_of_blueCars();
	}

	@Then("Return All Car with lowest per day rental cost price only")
	public void return_All_Car_with_lowest_per_day_rental_cost_price_only() {

		System.out.println("----------printing lowest per day rent-------- ");

		lowest_priceOf_perDAy();
	}

	@Then("Return All Car with lowest per day rental cost after discount")
	public void return_All_Car_with_lowest_per_day_rental_cost_after_discount() {

		System.out.println("-------printing after Discount----------");

		after_Discount_LowestPrice();
	}

	@Then("Find the Highest Revenue generating Car")
	public void find_the_Highest_Revenue_generating_Car() {

		System.out.println("printing Higest Revenue");

		highest_Revenue_generating_Car();
	}

	@Then("Stop the Server")
	public void stop_the_Server() {

		wiremockserver.stop();

		System.out.println("Wiremock Server Stopped");
	}

}