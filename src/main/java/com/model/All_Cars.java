package com.model;

public class All_Cars {
	
	private String make;
	private String model;
	private String vin;
	private Metadata metadata;
	private PerdayRent perdayrent;
	private Metrics metrics;
	
	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getVin() {
		return vin;
	}

	public void setVin(String vin) {
		this.vin = vin;
	}

	public Metadata getMetadata() {
		return metadata;
	}

	public void setMetadata(Metadata metadata) {
		this.metadata = metadata;
	}

	public PerdayRent getPerdayrent() {
		return perdayrent;
	}

	public void setPerdayrent(PerdayRent perdayrent) {
		this.perdayrent = perdayrent;
	}

	public Metrics getMetrics() {
		return metrics;
	}

	public void setMetrics(Metrics metrics) {
		this.metrics = metrics;
	}

	@Override
	public String toString() {
		return "All_Cars [make=" + make + ", model=" + model + ", vin=" + vin + ", metadata=" + metadata
				+ ", perdayrent=" + perdayrent + ", metrics=" + metrics + "]";
	}

	

}
