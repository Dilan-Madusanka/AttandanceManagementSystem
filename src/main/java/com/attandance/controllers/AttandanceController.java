package com.attandance.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.attandance.domain.Attndance;
import com.attandance.myException.ResourceNotFoundException;
import com.attandance.repo.AttandanceRepo;

@RestController
@RequestMapping("/attaendanceAPI")
public class AttandanceController {
	@Autowired
	AttandanceRepo attandanceRepo;
	
	//save
	@PostMapping("/attndance")
	public Attndance addAttndance(@ModelAttribute("attndance") Attndance attndance) {
		return attandanceRepo.save(attndance);
	}
	
	//getAll
	@GetMapping("/attndance")
	public List<Attndance> getAllAttndance(){
		return attandanceRepo.findAll();
		
	}
	
	//getById
	@GetMapping("/attndance/{id}")
	public Attndance getAttndanceById(@PathVariable(value = "id") Long attId) {
	    return attandanceRepo.findById(attId).orElseThrow(() -> 
	    new ResourceNotFoundException("Attndance", "id", attId));
	}
	
	//update
	@PutMapping("/attndance/{id}")
	public Attndance updateAttndance(@PathVariable(value = "id") Long attId,
	                                         @RequestBody Attndance attndance) {
		Attndance attndanceObj =new Attndance();
		attndanceObj = attandanceRepo.findById(attId)
	            .orElseThrow(() -> new ResourceNotFoundException("Attndance", "id", attId));

		attndance.setAttandanceId(attndanceObj.getAttandanceId());

		Attndance updatedAttndance = attandanceRepo.save(attndance);
	    return updatedAttndance;
	}
	
	// Delete
	@DeleteMapping("/attndance/{id}")
	public ResponseEntity<?> deleteAttndance(@PathVariable(value = "id") Long attId) {
		Attndance attndance = attandanceRepo.findById(attId).orElseThrow(() -> 
		new ResourceNotFoundException("Attndance", "id", attId));

		attandanceRepo.delete(attndance);

	    return ResponseEntity.ok().build();
	}
}
