package com.datasetgenerator.addressdatasetgenerator.repository;

import java.net.URISyntaxException;

import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestClientException;

import com.datasetgenerator.addressdatasetgenerator.domains.Country;
import com.datasetgenerator.addressdatasetgenerator.utils.CountryUtils;

@Repository
public class CountryRepository {
	
	Country country;
	
	
	public Country getCountry(String countryStr, int page, int size) throws RestClientException, URISyntaxException {
		country = CountryUtils.generateList(countryStr);
		
		int pageSize = 10;
	//	page+= size/pageSize; // if size > pageSize, add the quotient to page. example: 43 -> size. 43/10 = 4 added to page
	//	size= size%pageSize; // make size only the remainder: 43%10  = 3
		
		if (country.getCityList().size() < pageSize*page) {
			if(country.getCityList().size() < size) {
				country.setCityList(country.getCityList());
				country.setCityCount(country.getCityList().size());
				return country;
			}
			country.setCityList(country.getCityList().subList(0, size));
			country.setCityCount(country.getCityList().size());

			return country;
		}
		
		country.setCityList(country.getCityList().subList(page*pageSize, page*pageSize+size));
		country.setCityCount(country.getCityList().size());

		return country;
	}

	
}
