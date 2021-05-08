package uk.ac.soton.traveldesigner.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.ac.soton.traveldesigner.domain.TravelCity;
import uk.ac.soton.traveldesigner.mapper.TravelCityMapper;

import java.util.List;

@Service
public class TravelCityService {

    @Autowired
    private TravelCityMapper travelCityMapper;

    public TravelCity getTravelCityByCityName(String cityName) {
        TravelCity byCityName = travelCityMapper.findByCityName(cityName);
        return byCityName;
    }

    public List<TravelCity> getAllTravelCity() {
        return travelCityMapper.findAll();
    }
}
