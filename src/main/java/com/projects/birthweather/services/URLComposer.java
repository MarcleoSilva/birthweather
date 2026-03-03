package com.projects.birthweather.services;

public class URLComposer {
    public String getWeatherAPI(String latitude, String longitude, String date){
        return "https://archive-api.open-meteo.com/v1/era5?latitude=" + latitude +"&longitude=" + longitude +"&date="+date+"&hourly=temperature_2m,rain,precipitation,cloud_cover,relative_humidity_2m";
    }
}
