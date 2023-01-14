package com.project.soc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.soc.model.Adherent;
import com.project.soc.repository.AdherentRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class AdherentService {
	@Autowired
	private AdherentRepository adherentRepository;
	
	 public void addAdherent(Adherent adherent) {
	        Adherent adh = Adherent.builder()
	                .nom(adherent.getNom())
	                .prenom(adherent.getPrenom())
	                .adresse(adherent.getAdresse())
	                .numTel(adherent.getNumTel())
	                .dateInscription(adherent.getDateInscription())
	                .build();

	        adherentRepository.save(adh);
	        log.info("Adherent {} is saved", adh.getId());
	    }
	 
	 public List<Adherent> getAllAdherents() {
	       return(List<Adherent>) adherentRepository.findAll();
	  }
	public ResponseEntity<?> deleteAdherent(Long id) {
		return adherentRepository.findById(id).map(adherent -> {
				adherentRepository.delete(adherent);
				return ResponseEntity.ok().build();
			}).orElseThrow(() -> new IllegalArgumentException("Adherent not found with id " + id));
		}
}
