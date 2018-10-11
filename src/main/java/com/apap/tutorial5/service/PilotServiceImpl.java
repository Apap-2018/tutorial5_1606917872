package com.apap.tutorial5.service;

import com.apap.tutorial5.model.PilotModel;
import com.apap.tutorial5.repository.PilotDB;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PilotServiceImpl implements PilotService {
	@Autowired
	private PilotDB pilotDb;
	
	@Override
	public PilotModel getPilotDetailByLicenseNumber(String licenseNumber) {
		return pilotDb.findByLicenseNumber(licenseNumber);
	}
	
	@Override
	public void addPilot(PilotModel pilot) {
		pilotDb.save(pilot);
	}
	
	@Override
	public void deletePilot(String licenseNumber) {
		PilotModel pilot = pilotDb.findByLicenseNumber(licenseNumber);
		pilotDb.delete(pilot);
	}
	
	public void updatePilot(String licenseNumber, String name, int flyhour) {
		PilotModel temp = pilotDb.findByLicenseNumber(licenseNumber);
		temp.setName(name);
		temp.setFlyHour(flyhour);
		pilotDb.save(temp);
		
	}
	
	public List<PilotModel> viewAllPilot() {
		return pilotDb.findAll();
	}
}
