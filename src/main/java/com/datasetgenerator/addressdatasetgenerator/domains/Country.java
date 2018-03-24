package com.datasetgenerator.addressdatasetgenerator.domains;

import java.util.List;

public class Country {
	
	public Country() {
		// TODO Auto-generated constructor stub
	}

	
	private String countryName;
	private int cityCount;
	private List<String> cityList;
	
	
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	public int getCityCount() {
		return cityCount;
	}
	public void setCityCount(int cityCount) {
		this.cityCount = cityCount;
	}
	public List<String> getCityList() {
		return cityList;
	}
	public void setCityList(List<String> cityList) {
		this.cityList = cityList;
	}
	
	

	
	

}
