package com.projects.birthweather.services;

import com.projects.birthweather.domain.birthdata.BirthData;
import com.projects.birthweather.domain.birthdata.BirthDataRequestDTO;
import com.projects.birthweather.repository.BirthDataRepository;
import org.springframework.stereotype.Service;

@Service
public class BirthWeatherService {

    private final BirthDataRepository repository;

    public BirthWeatherService(BirthDataRepository repository) {
        this.repository = repository;
    }

    public BirthData registerBirthData(BirthDataRequestDTO data){
        BirthData bd = new BirthData(data);
        bd.setName(data.name());
        bd.setCity(data.city());
        bd.setDate(data.date());
        bd.setCountry(data.country());

        return repository.save(bd);
    }
}
