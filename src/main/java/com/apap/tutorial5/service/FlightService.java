package com.apap.tutorial5.service;


import com.apap.tutorial5.model.FlightModel;
import com.apap.tutorial5.model.PilotModel;

public interface FlightService {
	void addFlight(FlightModel flight);
	void deleteFlight(Long Id);
}
