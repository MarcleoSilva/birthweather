package com.projects.birthweather.services;

import com.projects.birthweather.domain.weatherdata.WeatherData;
import com.projects.birthweather.utils.ConvertData;
import com.projects.birthweather.webclient.Client;
import org.springframework.stereotype.Service;

@Service
public class WeatherDataService {
    private final ConvertData converter;
    private final Client fetcher;

    public WeatherDataService(ConvertData converter, Client fetcher){
        this.converter = converter;
        this.fetcher = fetcher;
    }

    public WeatherData getWeatherData(String lat, String lon, String date){

        String API = "https://archive-api.open-meteo.com/v1/era5?latitude="+lat+"&longitude="+lon+"&date="+date+"&hourly=temperature_2m,rain,precipitation,cloud_cover,relative_humidity_2m";
        System.out.println(API);

        String json = fetcher.getJSON(API);

        WeatherData weatherData = converter.getData(json, WeatherData.class);

        return weatherData;




    }




}
