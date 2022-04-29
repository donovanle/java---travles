package com.donovan.travels.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.donovan.travels.models.Travel;
import com.donovan.travels.services.TravelService;

@Controller
public class HomeController {

	@Autowired
	private TravelService travelService;
	
	//Create Form
	@GetMapping("/expenses")
	public String renderIndex(@ModelAttribute("travel") Travel travel, Model model) {
		List<Travel> travels = travelService.allTravels();
		model.addAttribute("travels", travels);
		return "index.jsp";
	}
	
	@PostMapping("/expenses/new")
	public String processCreate(@Valid @ModelAttribute("travel") Travel travel,
			BindingResult result) {
		if(result.hasErrors()) {
			return "index.jsp";
		}else {
			travelService.createTravel(travel);
			return "redirect:/expenses";
		}
	}
	
	// edit form
	@GetMapping("/expenses/{id}/edit")
	public String renderEdit(@PathVariable("id")Long id, Model model) {
		Travel travel = travelService.findTravel(id);
		model.addAttribute("travel", travel);
		return "edit.jsp";
	}
	
	@RequestMapping(value="/expenses/{id}/edit", method=RequestMethod.PUT)
	public String update(@Valid @ModelAttribute("travel") Travel travel,
			BindingResult result) {
		if(result.hasErrors()) {
			return "edit.jsp";
		}else {
			travelService.updateTravel(travel);
			return "redirect:/expenses";
		}
	}
	
	//delete
	@DeleteMapping("/expenses/{id}/delete")
	public String deleteTravel(@PathVariable("id")Long id) {
		travelService.deleteTravel(id);
		return "redirect:/expenses";
	}
	
	//find one
	@GetMapping("/expenses/{id}")
	public String oneTravel(@PathVariable("id")Long id, Model model) {
		Travel travel = travelService.findTravel(id);
		model.addAttribute("travel",travel);
		return "oneTravel.jsp";
	}
}
