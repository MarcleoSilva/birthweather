package com.projects.birthweather.domain.weatherdata;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class HourlyData {
    @JsonProperty("temperature_2m")
    private List<Double> temperature;
    private List<Double> rain;
    private List<Double> precipitation;
    @JsonProperty("cloud_cover")
    private List<Integer> cloud;
    @JsonProperty("relative_humidity_2m")
    private List<Integer> humidity;




}
