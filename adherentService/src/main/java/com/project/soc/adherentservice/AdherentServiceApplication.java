package com.project.soc.adherentservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "com.project.soc")
@EntityScan("com.project.soc.model")
@EnableJpaRepositories(basePackages = "com.project.soc.repository")
@EnableDiscoveryClient
public class AdherentServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdherentServiceApplication.class, args);
	}

}
