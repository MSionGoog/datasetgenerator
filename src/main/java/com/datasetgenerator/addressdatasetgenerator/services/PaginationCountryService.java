package com.datasetgenerator.addressdatasetgenerator.services;

import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;

import com.datasetgenerator.addressdatasetgenerator.domains.Country;
import com.datasetgenerator.addressdatasetgenerator.repository.CountryRepository;

@Service
public class PaginationCountryService {
	
	@Autowired
	CountryRepository countryRepository;

	public Country getResultByPage(String country, int page, int size) throws RestClientException, URISyntaxException {
		return countryRepository.getCountry(country, page, size);
	}

}
