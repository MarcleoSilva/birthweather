package com.projects.birthweather;

import com.projects.birthweather.domain.geodata.GeoData;
import com.projects.birthweather.domain.weatherdata.WeatherData;
import com.projects.birthweather.services.GeoDataService;
import com.projects.birthweather.services.WeatherDataService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BirthweatherApplication implements CommandLineRunner {
	private final GeoDataService geoDataService;

	private final WeatherDataService weatherDataService;

	public BirthweatherApplication(GeoDataService geoDataService, WeatherDataService weatherDataService){
		this.geoDataService = geoDataService;
		this.weatherDataService = weatherDataService;
	}


	public static void main(String[] args) {
		SpringApplication.run(BirthweatherApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {


		GeoData geo = geoDataService.getGeolocation("Salvador", "Brasil");
		System.out.println(geo);

		WeatherData weather = weatherDataService.getWeatherData("10","13","2022-02-03");
		System.out.println(weather);

	}


}
