package com.donovan.travels.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.donovan.travels.models.Travel;
import com.donovan.travels.services.TravelService;

@RestController
public class TravelsApi {
	private final TravelService travelService;
	
	public TravelsApi(TravelService travelService) {
		this.travelService = travelService;
	}
	
	@RequestMapping("/api/travels")
	public List<Travel> index(){
		return travelService.allTravels();
	}
	
	@RequestMapping(value="/api/travels", method=RequestMethod.POST)
	public Travel createTravel(@RequestParam(value="expense") String expense, @RequestParam(value="description") String description, @RequestParam(value="vendor") String vendor, @RequestParam(value="amount") double amount) {
		Travel travel = new Travel(expense, description, vendor, amount);
		return travelService.createTravel(travel);
	}
}
