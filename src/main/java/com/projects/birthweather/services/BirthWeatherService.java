package com.projects.birthweather.services;

import org.springframework.stereotype.Service;

import com.projects.birthweather.domain.birthdata.BirthData;
import com.projects.birthweather.domain.birthdata.BirthDataRequestDTO;
import com.projects.birthweather.repository.BirthDataRepository;

@Service
public class BirthWeatherService {

    private final BirthDataRepository repository;
    private final GeoDataService geoDataService;
    private final WeatherDataService weatherDataService;


    public BirthWeatherService(
            BirthDataRepository repository,
            GeoDataService geoDataService,
            WeatherDataService weatherDataService
            ) {
        this.repository = repository;
        this.geoDataService = geoDataService;
        this.weatherDataService = weatherDataService;
    }

    public BirthData registerBirthData(BirthDataRequestDTO data){
        BirthData bd = new BirthData(data);

        // Base data
        bd.setName(data.name());
        bd.setCity(data.city());
        bd.setDate(data.date());
        bd.setCountry(data.country());

        // Geo Data
        var lat = geoDataService.getGeolocation(data.city(), data.country()).getLatitude();

        var lon = geoDataService.getGeolocation(data.city(), data.country()).getLongitude();

        bd.setLatitude(lat);
        bd.setLongitude(lon);

        // Weather Data
        bd.setTemperature(weatherDataService.getWeatherData(lat, lon, data.date()).getHourlyData().getTemperature());
        bd.setPrecipitation(weatherDataService.getWeatherData(lat, lon, data.date()).getHourlyData().getPrecipitation());
        bd.setCloud(weatherDataService.getWeatherData(lat, lon, data.date()).getHourlyData().getCloud());
        bd.setHumidity(weatherDataService.getWeatherData(lat, lon, data.date()).getHourlyData().getHumidity());

        


        return repository.save(bd);
    }
}
