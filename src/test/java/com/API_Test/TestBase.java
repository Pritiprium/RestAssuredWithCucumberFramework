package com.API_Test;

import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.core.Options;

import io.restassured.response.Response;

public class TestBase {
	public WireMockServer wiremockserver;
	public Response response;
	

	@BeforeSuite
	public void setting_up_Server() {
		wiremockserver = new WireMockServer(options().port(9090));
		wiremockserver.start();
		System.out.println("Wiremock Server Started-->"+wiremockserver.port());
		
		
	}
	@AfterSuite
	public void stop_The_Server() {
		wiremockserver.stop();
	}
}
