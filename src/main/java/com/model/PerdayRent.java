package com.model;

public class PerdayRent {
	private Float price;
	private Float discount;

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Float getDiscount() {
		return discount;
	}

	public void setDiscount(Float discount) {
		this.discount = discount;
	}

	@Override
	public String toString() {
		return "PerdayRent [price=" + price + ", discount=" + discount + "]";
	}
	

}
