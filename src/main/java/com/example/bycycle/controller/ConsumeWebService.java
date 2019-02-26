package com.example.bycycle.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.example.bycycle.service.ByCycleService;
import com.exmaple.bycycle.model.Availability;
import com.exmaple.bycycle.model.Station;

@RestController
public class ConsumeWebService {

	@Value("${client}")
	private String client; // Client-Identifier
	@Value("${identifier}")
	private String identifier;// e81b39a749e37713354311b5a606ba03

	@Value("${stations.url}")
	private String stationsURL;
	@Value("${availability.url}")
	private String availabilityURL;

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private ByCycleService service;

	@RequestMapping(value = "/list")
	public ModelAndView list() throws Exception {
		restTemplate = new RestTemplate();
		HttpEntity<String> entity;
		ResponseEntity<String> responseForAvailable;
		ResponseEntity<String> responseForStations;
		Map<String, Object> params = new HashMap<>();

		try {
			entity = setHeaders();
		} catch (Exception exception) {
			params.put("message", exception);
			return new ModelAndView("error", params);
		}
		
		try {
			responseForAvailable = restTemplate.exchange(availabilityURL, HttpMethod.GET, entity, String.class);
			responseForStations = restTemplate.exchange(stationsURL, HttpMethod.GET, entity, String.class);
		} catch (Exception exception) {
			params.put("message", exception);
			return new ModelAndView("error", params);
		}

		List<Availability> availabilities = service.availability(responseForAvailable);
		List<Station> stations = service.listofStations(responseForStations);
		params.put("availabilities", availabilities);
		params.put("stations", stations);

		return new ModelAndView("list", params);
	}

	private HttpEntity<String> setHeaders() throws Exception {
		HttpHeaders headers = new HttpHeaders();
		headers.set(client, identifier);
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		return new HttpEntity<String>(headers);
	}
}
