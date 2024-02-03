package com.ortega.scdn;

import com.ortega.scdn.repository.ServerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class SCdnApplication {

	public static void main(String[] args) {
		SpringApplication.run(SCdnApplication.class, args);
	}

	CommandLineRunner runner(ServerRepository serverRepository) {
		return args -> {
//			Server gemena = new Server(
//					UUID.randomUUID(),
//					"s-gemena",
//					new Location(3.2549286, 19.7750831),
//					aleaGenerator.latencyGenerator(1, 1000),
//					aleaGenerator.bandwidthGenerator()
//			);
//
//			Server goma = new Server(
//					UUID.randomUUID(),
//					"s-goma",
//					new Location(-1.6665685, 29.225652),
//					aleaGenerator.latencyGenerator(1, 1000),
//					aleaGenerator.bandwidthGenerator()
//			);
//
//			Server lubumbashi = new Server(
//					UUID.randomUUID(),
//					"s-lubumbashi",
//					new Location(-11.6642316, 27.4826264),
//					aleaGenerator.latencyGenerator(1, 1000),
//					aleaGenerator.bandwidthGenerator()
//			);
//
//			Server lusambo = new Server(
//					UUID.randomUUID(),
//					"s-lusambo",
//					new Location(-6.1094951, 23.612934124246713),
//					aleaGenerator.latencyGenerator(1, 1000),
//					aleaGenerator.bandwidthGenerator()
//			);
//
//			Server matadi = new Server(
//					UUID.randomUUID(),
//					"s-matadi",
//					new Location(-5.79740005, 13.494820298074796),
//					aleaGenerator.latencyGenerator(1, 1000),
//					aleaGenerator.bandwidthGenerator()
//			);

			//serverRepository.save(gemena);
			//serverRepository.save(goma);
			//serverRepository.save(lubumbashi);
			//serverRepository.save(lusambo);
			//serverRepository.save(matadi);
		};
	}
}
