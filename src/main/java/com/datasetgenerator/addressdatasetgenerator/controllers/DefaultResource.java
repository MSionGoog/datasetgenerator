package com.datasetgenerator.addressdatasetgenerator.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DefaultResource {

	@PostMapping("/greet/{name}")
	public ResponseEntity<Map<String,String>> defaultMethod(@PathVariable("name") String name) {
		Map<String,String> defaultMap = new HashMap<String,String>();
		defaultMap.put("message", "Hello " + name);
		return new ResponseEntity<Map<String,String>>(defaultMap,HttpStatus.OK);
	}
}
