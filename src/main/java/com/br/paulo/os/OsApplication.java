package com.br.paulo.os;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.Entity;
//@EntityScan(basePackages = {"com.br.paulo.os.domain"})

@SpringBootApplication
public class OsApplication {

	public static void main(String[] args) {
		SpringApplication.run(OsApplication.class, args);
	}

}
