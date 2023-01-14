package com.project.soc.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import com.project.soc.model.Adherent;
import com.project.soc.repository.AdherentRepository;
import com.project.soc.service.AdherentService;

import lombok.RequiredArgsConstructor;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api/adherent")
public class AdherentController {
	
@Autowired
private AdherentService adherentService;
@Autowired
private AdherentRepository adherentRepository;
	
	@PostMapping("/add")
	@ResponseStatus(HttpStatus.CREATED)
	public void addAdherent(@RequestBody Adherent adherent) {
		 adherentService.addAdherent(adherent);
	}
	 @GetMapping("/showNewAdherentForm")
	 public String showNewAdherentForm(Model model) {
	     // create model attribute to bind form data
	     Adherent adherent = new Adherent();
	     model.addAttribute("adherent", adherent);
	     return "newAdherent.html";
	 }
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<Adherent> getAllAdherents(Model model) {
			List<Adherent> adherents = adherentService.getAllAdherents();
			System.out.print("list"+adherents);
		   model.addAttribute("listAdherent",adherents);
	       return adherents;
	  }
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteAdherent(@PathVariable(value = "id") Long id) {
		return adherentService.deleteAdherent(id);
	}
	
	 @PutMapping("/{id}")
		public Adherent updateAdherent(@PathVariable Long id, @RequestBody Adherent adherentRequest) {
			return adherentRepository.findById(id).map(adherent -> {
				adherent.setNom(adherentRequest.getNom());
				adherent.setPrenom(adherentRequest.getPrenom());
				adherent.setAdresse(adherentRequest.getAdresse());
				adherent.setNumTel(adherentRequest.getNumTel());
				adherent.setDateInscription(adherentRequest.getDateInscription());
				return adherentRepository.save(adherent);
			}).orElseThrow(() -> new IllegalArgumentException("Id " + id + " not found"));
		} 

}
