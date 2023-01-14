package com.project.soc.model;

import lombok.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.config.Projection;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @Builder
@Table(name="adherent")
public class Adherent {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
		private Long id;
		private String nom;
		private String prenom;
		private String adresse;
		private String numTel;
		private String dateInscription;
}
