package com.API_Test;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.TreeMap;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.tomakehurst.wiremock.matching.EqualToPattern;
import com.model.CarList;

import com.model.All_Cars;

public class Schema_Stub extends TestBase {

	CarList carList;

	public void stubbing_Schema() throws JsonParseException, JsonMappingException, IOException {
		wiremockserver.stubFor(get(urlEqualTo("/get_cars")).willReturn(aResponse()
				.withHeader("Content-Type", "application/json").withStatus(200).withBodyFile("car_Responce.json")));

	}

	public CarList mapping_with_Response(String jsonString)
			throws JsonParseException, JsonMappingException, IOException {

		ObjectMapper objectMapper = new ObjectMapper();
		// String filepath = System.getProperty("user.dir")
		// +"\\src\\test\\resources\\__files\\car_Responce.json";
		// File file = new File(filepath);
		// CarList carList = objectMapper.readValue(file, CarList.class);
		// INSTEAD OF GIVING JSON FILE PATH LIKE ABOVE I GAVE THE RESAASURED RESPONSE
		carList = objectMapper.readValue(jsonString, CarList.class);

		return carList;
	}

	public void print_Blue_cars() {

		for (All_Cars car : carList.getCars()) {
			if (car.getMetadata().getColor().contains("Blue")) {
				System.out.println(car.getMake());
			}
		}
	}

	public void notes_of_blueCars() {
		for (All_Cars car : carList.getCars()) {
			if (car.getMetadata().getColor().contains("Blue")) {
				System.out.println("Notes of Blue Cars--> " + car.getMetadata().getNotes());

			}
		}
	}

	public void lowest_priceOf_perDAy() {
		TreeMap<Float, String> tm = new TreeMap<Float, String>();// TreeMap will sort the value
		for (All_Cars car : carList.getCars()) {
			tm.put(car.getPerdayrent().getPrice(), car.getMake());// putting car price as key and car name as value
		}
		System.out.println("Car Name with Lowest Price-->" + tm.firstEntry().getValue());
		System.out.println("Lowest Price from All cars-->" + tm.firstKey());

	}

	public void after_Discount_LowestPrice() {
		TreeMap<Float, String> tmap = new TreeMap<Float, String>();
		for (All_Cars cars : carList.getCars()) {
			Float discountCalculation = (cars.getPerdayrent().getDiscount() / 100) * cars.getPerdayrent().getPrice();
			Float priceAfterDiscount = cars.getPerdayrent().getPrice() - discountCalculation;
			tmap.put(priceAfterDiscount, cars.getMake());
		}
		System.out.println("After Discount Lowest price Car--> " + tmap.firstKey());
		System.out.println("Car Name After Discount--> " + tmap.firstEntry().getValue());
	}

	public void highest_Revenue_generating_Car() {
		TreeMap<Float, String> tmap = new TreeMap<Float, String>();
		for (All_Cars cars : carList.getCars()) {

			Float yeartodate = cars.getMetrics().getRentalcount().getYeartodate();
			Float yOYMaint = cars.getMetrics().getYoymaintenancecost();
			Float getdiscount = cars.getPerdayrent().getDiscount();
			Float depriciation = cars.getMetrics().getDepreciation();
			Float carRevnue = (yeartodate * getdiscount) - (yOYMaint + depriciation);
			tmap.put(carRevnue, cars.getMake());
		}
		System.out.println("Highest Revenue Generating Car-->" + tmap.lastEntry().getValue());
	}

}
