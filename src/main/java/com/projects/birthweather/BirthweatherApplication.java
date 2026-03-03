package com.projects.birthweather;

import com.projects.birthweather.domain.geodata.GeoData;
import com.projects.birthweather.services.GeoDataService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BirthweatherApplication implements CommandLineRunner {
	private final GeoDataService geoDataService;

	public BirthweatherApplication(GeoDataService geoDataService){
		this.geoDataService = geoDataService;
	}

	public static void main(String[] args) {
		SpringApplication.run(BirthweatherApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {


		GeoData geo = geoDataService.getGeolocation("Salvador", "Brasil");
		System.out.println(geo);

	}


}
