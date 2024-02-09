package com.ortega.scdn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.io.File;
import java.io.IOException;
import java.net.URL;

@EnableCaching
@SpringBootApplication
@EnableMongoRepositories
public class SCdnApplication {

	public static void main(String[] args) {
		SpringApplication.run(SCdnApplication.class, args);
	}

}
