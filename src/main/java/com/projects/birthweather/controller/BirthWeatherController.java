package com.projects.birthweather.controller;

import com.projects.birthweather.domain.birthdata.BirthData;
import com.projects.birthweather.domain.birthdata.BirthDataRequestDTO;
import com.projects.birthweather.domain.stats.WeatherStatsDTO;
import com.projects.birthweather.services.BirthWeatherService;
import com.projects.birthweather.services.WeatherStatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/birthweather")
public class BirthWeatherController {

    @Autowired
    private BirthWeatherService birthWeatherService;
    @Autowired
    private WeatherStatsService weatherStatsService;


    @PostMapping
    public ResponseEntity<WeatherStatsDTO> create(@RequestBody BirthDataRequestDTO body){
        BirthData newBirthData = this.birthWeatherService.registerBirthData(body);

        return ResponseEntity.ok(this.weatherStatsService.analyzeData(newBirthData));
    }



}
