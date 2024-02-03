package com.ortega.scdn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
public class SCdnApplication {

	public static void main(String[] args) {
		SpringApplication.run(SCdnApplication.class, args);
	}

}
