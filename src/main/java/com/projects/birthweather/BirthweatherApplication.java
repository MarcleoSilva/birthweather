package com.projects.birthweather;

import com.projects.birthweather.webclient.Client;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BirthweatherApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(BirthweatherApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		var fetcher = new Client();

		var weather = fetcher.getJSON("https://archive-api.open-meteo.com/v1/era5?latitude=52.52&longitude=13.41&start_date=2021-01-01&end_date=2021-01-02&hourly=temperature_2m,rain,precipitation_probability,precipitation,cloud_cover,relative_humidity_2m");

		var place = fetcher.getJSON("https://nominatim.openstreetmap.org/search?q=Salvador%20Brasil&format=json");

		System.out.println(weather);
		System.out.println("=================================");
		System.out.println(place);
	}

}
