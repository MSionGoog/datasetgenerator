package com.datasetgenerator.addressdatasetgenerator.utils;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.datasetgenerator.addressdatasetgenerator.domains.Country;
import com.datasetgenerator.addressdatasetgenerator.domains.DataResponse;

public class CountryUtils {

	
	public static Country generateList(String countryStr) throws RestClientException, URISyntaxException {
		String mashapeKey = "494rygOki2msh0KxoJuhZgJ1yyWep1ntKqVjsnyoFyZjl60sxy";
		
		
		/*
		 * curl --get --include 'https://andruxnet-world-cities-v1.p.mashape.com/?query=paris&searchby=city' \
  -H 'X-Mashape-Key: ' \
  -H 'Accept: application/json'
		 */
		
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("X-Mashape-Key", mashapeKey);
		httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		
		HttpEntity<Object> httpEntity = new HttpEntity<>(httpHeaders);
		String url = "https://andruxnet-world-cities-v1.p.mashape.com/?query="+countryStr+"&searchby=country";
		
		RestTemplate restTemplate = new RestTemplate();
		
		ResponseEntity<List<DataResponse>> responseEntity = restTemplate.exchange(url, HttpMethod.GET,httpEntity, new ParameterizedTypeReference<List<DataResponse>>() {});
		
		List<DataResponse> dataResponseList = responseEntity.getBody();
		
		Country country = new Country();
		country.setCountryName(countryStr);
		List<String> cities = new ArrayList<>();
		for(DataResponse dataResponse : dataResponseList) {
			cities.add(dataResponse.getCity());
		}
		country.setCityList(cities);
		country.setCityCount(cities.size());
	
		return country;
		
	}

}
