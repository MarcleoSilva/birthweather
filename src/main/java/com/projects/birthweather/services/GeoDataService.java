package com.projects.birthweather.services;

import com.projects.birthweather.domain.geodata.GeoData;
import com.projects.birthweather.utils.ConvertData;
import com.projects.birthweather.webclient.Client;
import org.springframework.stereotype.Service;

@Service
public class GeoDataService {
    private final ConvertData converter;
    private final Client fetcher;

    public GeoDataService(ConvertData converter, Client fetcher) {
        this.converter = converter;
        this.fetcher = fetcher;
    }

    public GeoData getGeolocation(String city, String country){
        String encodedCity = city.replace(" ","&");
        String encodedCountry = country.replace(" ","&");
        String API = "https://nominatim.openstreetmap.org/search?q="+encodedCity+"%20"+encodedCountry+"&format=json";

        String json = fetcher.getJSON(API);
        GeoData[] results = converter.getData(json, GeoData[].class);

        if (results.length == 0){
            throw new RuntimeException("empty coordinates");
        }
        return results[0];
    }




}
