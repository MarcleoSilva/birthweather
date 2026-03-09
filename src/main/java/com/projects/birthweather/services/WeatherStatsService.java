package com.projects.birthweather.services;

import com.projects.birthweather.domain.birthdata.BirthData;
import com.projects.birthweather.domain.stats.WeatherStatsDTO;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.Collections.max;
import static java.util.Collections.min;

@Service
public class WeatherStatsService {
    public WeatherStatsDTO analyzeData(BirthData data){
        String name = data.getName();
        String city = data.getCity();
        String country = data.getCountry();
        String date = data.getDate();

        String mapsURL = getEmbeddedMaps(data.getLatitude(), data.getLongitude());

        Double maxPrecipitation = max(data.getPrecipitation());
        Double minPrecipitation = min(data.getPrecipitation());
        Double averagePrecipitation = average(data.getPrecipitation());

        Integer maxCloud = max(data.getCloud());
        Integer minCloud = min(data.getCloud());
        Double averageCloud = averageInt(data.getCloud());

        Integer maxHumidity = max(data.getHumidity());
        Integer minHumidity = min(data.getHumidity());
        Double averageHumidity = averageInt(data.getHumidity());

        Double maxTemperature = max(data.getTemperature());
        Double minTemperature = min(data.getTemperature());
        Double averageTemperature = average(data.getTemperature());

        return new WeatherStatsDTO(
                name, city, country, date, mapsURL, maxPrecipitation, minPrecipitation, averagePrecipitation, maxCloud, minCloud, averageCloud,
                maxHumidity, minHumidity, averageHumidity, maxTemperature, minTemperature, averageTemperature, isItRaining(averagePrecipitation), cloudCondition(averageCloud), tempCondition(averageTemperature));


    }

    private String isItRaining(Double avgPrecipitation) {
        if (avgPrecipitation == null || avgPrecipitation == 0.0)
            return "No rain";
        if (avgPrecipitation < 2.5)
            return "Light rain";
        if (avgPrecipitation < 7.6)
            return "Moderate rain";
        if (avgPrecipitation < 50.0)
            return "Heavy rain";
        return "Violent rain";
    }

    private String cloudCondition(Double avgCloud) {
        if (avgCloud < 10)  return "Clear sky";
        if (avgCloud < 30)  return "Mostly clear";
        if (avgCloud < 60)  return "Partly cloudy";
        if (avgCloud < 85)  return "Mostly cloudy";
        return "Overcast";
    }

    private String tempCondition(Double avgTemp) {
        if (avgTemp < 0)    return "Freezing";
        if (avgTemp < 10)   return "Very cold";
        if (avgTemp < 18)   return "Cold";
        if (avgTemp < 24)   return "Mild";
        if (avgTemp < 30)   return "Warm";
        if (avgTemp < 36)   return "Hot";
        return "Extremely hot";
    }

    private String getEmbeddedMaps(String lat, String lon){
        return "https://www.google.com/maps/embed?pb=!1m14!1m12!1m3!1d5533.4531094441845!2d"+lon+"!3d"+lat+"!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!5e1!3m2!1spt-BR!2sbr!4v1773080140304!5m2!1spt-BR!2sbr";
    }

    private Double average(List<Double> data) {
        return data.stream()
                .mapToDouble(Double::doubleValue)
                .average()
                .orElse(0.0);
    }

    private Double averageInt(List<Integer> data){
        return data.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0);
    }
}



