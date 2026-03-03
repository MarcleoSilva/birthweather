package com.projects.birthweather.controller;

import com.projects.birthweather.domain.birthdata.BirthData;
import com.projects.birthweather.domain.birthdata.BirthDataRequestDTO;
import com.projects.birthweather.services.BirthWeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/birthweather")
public class BirthWeatherController {

    @Autowired
    private BirthWeatherService birthWeatherService;

    @PostMapping
    public ResponseEntity<BirthData> create(@RequestBody BirthDataRequestDTO body){
        BirthData newBirthdata = this.birthWeatherService.registerBirthData(body);
        return ResponseEntity.ok(newBirthdata);
    }



}
