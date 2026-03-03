package com.projects.birthweather.domain.geodata;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class GeoData {
    @JsonProperty("lat")
    private String latitude;
    @JsonProperty("lon")
    private String longitude;

    @Override
    public String toString() {
        return "Lat: " + getLatitude() + " -- Lon: " + getLongitude();
    }
}
