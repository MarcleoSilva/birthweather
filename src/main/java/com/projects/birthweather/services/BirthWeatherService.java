package com.projects.birthweather.services;

import com.projects.birthweather.domain.birthdata.BirthData;
import com.projects.birthweather.domain.birthdata.BirthDataRequestDTO;
import com.projects.birthweather.repository.BirthDataRepository;
import org.springframework.stereotype.Service;

@Service
public class BirthWeatherService {

    private final BirthDataRepository repository;
    private final GeoDataService geoDataService;

    public BirthWeatherService(
            BirthDataRepository repository,
            GeoDataService geoDataService
            ) {
        this.repository = repository;
        this.geoDataService = geoDataService;
    }

    public BirthData registerBirthData(BirthDataRequestDTO data){
        BirthData bd = new BirthData(data);
        bd.setName(data.name());
        bd.setCity(data.city());
        bd.setDate(data.date());
        bd.setCountry(data.country());

        bd.setLatitude(geoDataService.getGeolocation(data.city(), data.country()).getLatitude());

        bd.setLongitude(geoDataService.getGeolocation(data.city(), data.country()).getLongitude());

        return repository.save(bd);
    }
}
