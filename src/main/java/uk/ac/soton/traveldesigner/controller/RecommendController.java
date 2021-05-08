package uk.ac.soton.traveldesigner.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import uk.ac.soton.traveldesigner.domain.TravelCity;
import uk.ac.soton.traveldesigner.service.COVIDService;
import uk.ac.soton.traveldesigner.service.TravelCityService;
import uk.ac.soton.traveldesigner.service.WeatherService;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/recommend")
public class RecommendController {

    @Autowired
    private COVIDService covidService;

    @Autowired
    private TravelCityService travelCityService;

    @Autowired
    private WeatherService weatherService;

    @GetMapping
    public List<TravelCity> getTopCityToTravel(
            @RequestParam(value = "isWeather", required = false) Integer isWeather,
            @RequestParam(value = "isCovid", required = false) Integer isCovid,
            @RequestParam(value = "isTravel", required = false) Integer isTravel,
            @RequestParam(value = "isShopping", required = false) Integer isShopping) {

        List<TravelCity> cities = travelCityService.getAllTravelCity();

        /**
         * for travel
         */
        List<TravelCity> travelRes = new ArrayList<>();
        if (isTravel != null && isTravel == 1) {
            travelRes = cities
                    .stream()
                    .sorted(Comparator.comparing(TravelCity::getVisitScore).reversed())
                    .collect(Collectors.toList())
                    .subList(0, 10);
        }
        /**
         * for shopping
         */
        List<TravelCity> shoppingRes;
        if (isShopping != null && isShopping == 1) {
            shoppingRes = cities
                    .stream()
                    .sorted(Comparator.comparing(TravelCity::getGdp2018).reversed())
                    .collect(Collectors.toList())
                    .subList(0, 10);
            travelRes.retainAll(shoppingRes);
        }

        /**
         * for covid
         */
        Map<String, Integer> covidHash = new HashMap<>();
        isCovid = 0;
        if (isCovid != null && isCovid == 1) {
            for (int i = 0; i < cities.size(); i++) {
                String cityName = cities.get(i).getCityName();
                Map map = covidService.getCOVIDByCityName(cityName);
                if (map == null) continue;
                Integer o = (Integer) ((Map) (((List) map.get("data")).get(0))).get("cumulativeCases");
                covidHash.put(cityName, o);
            }
            Set<Map.Entry<String, Integer>> entries = covidHash.entrySet();
            List temp = entries
                    .stream()
                    .sorted(Map.Entry.comparingByValue())
                    .collect(Collectors.toList());
        }

        /**
         * for weather
         */
        Map<String, Integer> weatherHash = new HashMap<>();
        isWeather = 0;
        if (isWeather != null && isWeather == 1) {
            for (int i = 0; i < cities.size(); i++) {
                String cityName = cities.get(i).getCityName();
                Map map = weatherService.getWeatherByCityName(cityName, LocalDate.now());
                if (map == null) continue;
                Integer o = (Integer) ((Map) (((List) map.get("data")).get(0))).get("cumulativeCases");
                covidHash.put(cityName, o);
            }
        }
        return travelRes;
    }
}
