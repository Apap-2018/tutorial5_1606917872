package com.apap.tutorial5.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.apap.tutorial5.model.FlightModel;
import com.apap.tutorial5.model.PilotModel;
import com.apap.tutorial5.service.PilotService;

@Controller
public class PilotController {
	@Autowired
	private PilotService pilotService;
	
	@RequestMapping("/")
	private String home() {
		return "home";
	}
	
	@RequestMapping(value = "/pilot/add", method = RequestMethod.GET)
	private String add(Model model) {
		model.addAttribute("pilot", new PilotModel());
		return "addPilot";
	}
	
	@RequestMapping(value = "/pilot/add", method = RequestMethod.POST)
	private String addPilotSubmit(@ModelAttribute PilotModel pilot) {
		pilotService.addPilot(pilot);
		return "add";
	}
	
	@RequestMapping(value = "/pilot/view", method = RequestMethod.GET)
	public String viewPilot(@RequestParam("licenseNumber") String licenseNumber, Model model) {
		PilotModel pilot = pilotService.getPilotDetailByLicenseNumber(licenseNumber);
		
		//List<FlightModel> listFlights = pilot.getPilotFlight();
		model.addAttribute("pilot", pilot);
		//model.addAttribute("flight", listFlights);
		return "view-pilot";
	}
	
	@RequestMapping(value = "/pilot/delete", method = RequestMethod.POST)
	public String deletePilot(@ModelAttribute PilotModel pilot, Model model) {
		System.out.println("harusnya mah masuk sini");
		for(PilotModel temp : pilotService.viewAllPilot()) {
			pilotService.deletePilot(temp.getLicenseNumber());
		}
		System.out.println("masuk delete teeeeeuuu");
		return "delete";
		
	}
	
	@RequestMapping(value = "/pilot/update", method = RequestMethod.GET)
	public String updatePilot(String licenseNumber, Model model) {
		PilotModel temp = pilotService.getPilotDetailByLicenseNumber(licenseNumber);
		model.addAttribute("pilot", temp);
		return "update";
	}
	
	@RequestMapping(value = "/pilot/update", method = RequestMethod.POST)
	public String updatePilot(@ModelAttribute PilotModel pilot, Model model) {
		pilotService.updatePilot(pilot.getLicenseNumber(), pilot.getName(), pilot.getFlyHour());
		return "hasilUpdate";
	}
	
	@RequestMapping(value = "/pilot/viewAll", method = RequestMethod.GET)
	public String viewAllPilot(Model model) {
		List<PilotModel> listPilot = pilotService.viewAllPilot();
		System.out.println(listPilot.size() + " jumlah pilot");
		System.out.println(listPilot.get(0).getName());
		model.addAttribute("listPilot", listPilot);
		return "viewall-pilot";
	}
	
	
}
