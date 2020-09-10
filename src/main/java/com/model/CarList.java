package com.model;

import java.util.Arrays;

public class CarList {
	
	private All_Cars [] cars;
	
	

	public All_Cars[] getCars() {
		return cars;
	}

	public void setCars(All_Cars[] cars) {
		this.cars = cars;
	}

	@Override
	public String toString() {
		return "FirstCar_Property [cars=" + Arrays.toString(cars) + "]";
	}
	

	
}
