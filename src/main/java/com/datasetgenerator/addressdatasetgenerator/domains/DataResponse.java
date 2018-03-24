package com.datasetgenerator.addressdatasetgenerator.domains;

public class DataResponse {
	
	private String city;
	private String state;
	private String country;
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public DataResponse(String city, String state, String country) {
		super();
		this.city = city;
		this.state = state;
		this.country = country;
	}
	
	public DataResponse() {
		// TODO Auto-generated constructor stub
	}

}
