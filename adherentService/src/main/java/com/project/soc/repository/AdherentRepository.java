package com.project.soc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.soc.model.Adherent;

public interface AdherentRepository extends JpaRepository<Adherent,Long>{
	public Adherent findAdherentByNom(String nom);
	public Adherent findAdherentByPrenom(String prenom);

}
