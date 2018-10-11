package com.apap.tutorial5.service;

import java.util.List;

import com.apap.tutorial5.model.PilotModel;

public interface PilotService {
	PilotModel getPilotDetailByLicenseNumber(String licenseNumber);
	
	void addPilot(PilotModel pilot);
	void deletePilot(String licenseNumber);
	List<PilotModel> viewAllPilot();
	void updatePilot(String licenseNumber, String name, int flyhour);
}
