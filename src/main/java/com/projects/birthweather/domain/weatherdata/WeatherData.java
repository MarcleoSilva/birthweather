package com.projects.birthweather.domain.weatherdata;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherData {
    @JsonProperty("hourly")
    private HourlyData hourlyData;

    @Override
    public String toString() {
        return "Temperature" + getHourlyData().getTemperature();
    }

}
