package com.projects.birthweather.domain.stats;

import java.util.List;

public record WeatherStatsDTO (
        // Unchanged
        String name,
        String city,
        String country,
        String date,

        // Generated data
        String mapsURL,

        // precipitation
        Double maxPrecipitation,
        Double minPrecipitation,
        Double averagePrecipitation,
        List<Double> Precipitation,

        // cloud
        Integer maxCloud,
        Integer minCloud,
        Double averageCloud,
        List<Integer> Cloud,

        // humidity
        Integer maxHumidity,
        Integer minHumidity,
        Double averageHumidity,
        List<Integer> Humidity,

        // temperature
        Double maxTemperature,
        Double minTemperature,
        Double averageTemperature,
        List<Double> Temperature,

        // abstractions

        String isRaining,
        String isCloudy,
        String isTemperature
){}
