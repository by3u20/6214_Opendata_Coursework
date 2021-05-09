package uk.ac.soton.traveldesigner.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;
import uk.ac.soton.traveldesigner.service.WeatherService;

import java.time.LocalDate;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/weather")
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @GetMapping("/{cityName}")
    public Object getWeatherByCityName(@PathVariable("cityName") String cityName, @RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
        return weatherService.getWeatherByCityName(cityName);
    }


}
