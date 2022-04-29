package com.donovan.travels.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.donovan.travels.models.Travel;
import com.donovan.travels.repositories.TravelRepository;

@Service
public class TravelService {
	private final TravelRepository travelRepository;
	
	public TravelService(TravelRepository travelRepository) {
		this.travelRepository = travelRepository;
	}
	
	// return all travels
	public List<Travel> allTravels(){
		return travelRepository.findAll();
	}
	//return one travel
	public Travel findTravel(Long id) {
		Optional<Travel> optionalTravel = travelRepository.findById(id);
		if(optionalTravel.isPresent()) {
			return optionalTravel.get();
		} else {
			return null;
		}
	}
	
	//update
	public Travel updateTravel(Travel travel) {
		return travelRepository.save(travel);
	}
	// delete
	public void deleteTravel(Long id) {
		travelRepository.deleteById(id);
	}
	// create
	public Travel createTravel(Travel travel) {
		return travelRepository.save(travel);
	}
}
