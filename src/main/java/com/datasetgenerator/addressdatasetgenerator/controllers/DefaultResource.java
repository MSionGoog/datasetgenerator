package com.datasetgenerator.addressdatasetgenerator.controllers;

import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;

import com.datasetgenerator.addressdatasetgenerator.domains.Country;
import com.datasetgenerator.addressdatasetgenerator.services.PaginationCountryService;

@RestController
public class DefaultResource {
	
	@Autowired
	PaginationCountryService paginationCountryService;

	@PostMapping("/greet/{name}")
	public ResponseEntity<Map<String,String>> defaultMethod(@PathVariable("name") String name) {
		Map<String,String> defaultMap = new HashMap<String,String>();
		defaultMap.put("message", "Hello " + name);
		return new ResponseEntity<Map<String,String>>(defaultMap,HttpStatus.OK);
	}
	
	@PostMapping(value = "/places/{country}/{page}/{size}")
	public ResponseEntity<Map<String,Country>> paginatedResponse(@PathVariable("country") String country, @PathVariable("page") int page, @PathVariable("size") int size) throws RestClientException, URISyntaxException {
		Map<String, Country> defaultMap = new HashMap<String,Country>();
		defaultMap.put("message",paginationCountryService.getResultByPage(country, page, size));
		return new ResponseEntity<Map<String,Country>>(defaultMap,HttpStatus.OK);
	}
}
