package com.projects.birthweather.domain.stats;

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

        // cloud
        Integer maxCloud,
        Integer minCloud,
        Double averageCloud,

        // humidity
        Integer maxHumidity,
        Integer minHumidity,
        Double averageHumidity,

        // temperature
        Double maxTemperature,
        Double minTemperature,
        Double averageTemperature,

        // abstractions

        String isRaining,
        String isCloudy,
        String isTemperature
){}
