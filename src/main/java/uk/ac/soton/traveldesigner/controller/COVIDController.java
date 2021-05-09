package uk.ac.soton.traveldesigner.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uk.ac.soton.traveldesigner.service.COVIDService;

@RestController
@RequestMapping("/COVID")
public class COVIDController {

    @Autowired
    private static COVIDService covidService;

    @GetMapping("/{cityName}")
    public static Object getCOVIDByCityName(@PathVariable("cityName") String cityName) {
        return covidService.getCOVIDByCityName(cityName);
    }
}
