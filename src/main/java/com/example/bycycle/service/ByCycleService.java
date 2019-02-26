package com.example.bycycle.service;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.exmaple.bycycle.model.Availability;
import com.exmaple.bycycle.model.Station;

@Service
public class ByCycleService {

	public List<Station> listofStations(ResponseEntity<String> response) throws JSONException {
		List<Station> stationsList = new ArrayList<>();
		Station station;

		int id, locks;
		String title;

		if (response.getStatusCode() == HttpStatus.OK) {

			JSONObject jsonObj = new JSONObject(response.getBody());
			JSONArray jsonArray = (JSONArray) jsonObj.get("stations");

			for (int i = 0; i < jsonArray.length(); i++) {
				JSONObject obj = jsonArray.getJSONObject(i);
				id = obj.getInt("id");
				title = obj.getString("title");
				locks = obj.getInt("number_of_locks");
				station = new Station();

				station.setId(id);
				station.setTitle(title);
				station.setNumberOfLocks(locks);
				stationsList.add(station);

			}
		}
		return stationsList;
	}

	public List<Availability> availability(ResponseEntity<String> response) throws JSONException {

		List<Availability> availableList = new ArrayList<>();
		Availability available;

		int id, bikes, locks;
		if (response.getStatusCode() == HttpStatus.OK) {

			JSONObject jsonObj = new JSONObject(response.getBody());
			JSONArray jsonArray = (JSONArray) jsonObj.get("stations");

			for (int i = 0; i < jsonArray.length(); i++) {
				JSONObject obj = jsonArray.getJSONObject(i);
				id = obj.getInt("id");
				JSONObject jObj = obj.getJSONObject("availability");
				bikes = jObj.getInt("bikes");
				locks = jObj.getInt("locks");
				available = new Availability();

				available.setId(id);
				available.setBikes(bikes);
				available.setLocks(locks);
				availableList.add(available);
			}
		}
		return availableList;
	}
}
