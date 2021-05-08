package uk.ac.soton.traveldesigner.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uk.ac.soton.traveldesigner.domain.TravelCity;
import uk.ac.soton.traveldesigner.service.TravelCityService;

import java.util.List;

@RestController
@RequestMapping("/travelCity")
public class TravelCityController {

    @Autowired
    private TravelCityService travelCityService;

    @GetMapping("{cityName}")
    public TravelCity getTravelCityByCityName(@PathVariable("cityName")String cityName) {
        return travelCityService.getTravelCityByCityName(cityName);
    }

    @GetMapping
    public List<TravelCity> getAllTravelCity() {
        return travelCityService.getAllTravelCity();
    }


}
