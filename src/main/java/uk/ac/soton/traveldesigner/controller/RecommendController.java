package uk.ac.soton.traveldesigner.controller;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import uk.ac.soton.traveldesigner.domain.TravelCity;
import uk.ac.soton.traveldesigner.service.COVIDService;
import uk.ac.soton.traveldesigner.service.TravelCityService;
import uk.ac.soton.traveldesigner.service.WeatherService;
import java.text.DateFormat;

import java.util.*;

@RestController
@RequestMapping("/recommend")
public class RecommendController {

    private List<TravelCity> cities = null;

    @Autowired
    private COVIDService covidService;

    @Autowired
    private TravelCityService travelCityService;

    @Autowired
    private WeatherService weatherService;

    public List<TravelCity> getCities() {
        if (this.cities == null)
            this.cities = travelCityService.getAllTravelCity();
        return this.cities;
    }

    public Map<String, Double> getTravelScore() {
        Map<String, Double> cityTravelScore = new HashMap<>();

        this.getCities()
                .forEach((city) -> cityTravelScore.put(city.getCityName(), city.getVisitScore()));

        return cityTravelScore;
    }

    public Map<String, Double> getShoppingScore() {
        Map<String, Double> cityShoppingScore = new HashMap<>();

        this.getCities()
                .forEach((city) -> cityShoppingScore.put(city.getCityName(), city.getShopping_Score()));

        return cityShoppingScore;
    }

    public Map<String, Integer> getCovidScore() {
        Map<String, Integer> covidHash = new HashMap<>();

        for (int i = 0; i < getCities().size(); i++) {
            String cityName = getCities().get(i).getCOVIDGovLTLACityName();
            Map map = covidService.getCOVIDByCityName(cityName);
            if (map == null) continue;
            Integer dailyCases = (Integer) ((Map) (((List) map.get("data")).get(0))).get("dailyCases");
            Integer covidScores ;
            if(dailyCases==0){
                covidScores=10;
                covidHash.put(cityName, covidScores);
            }else
            if(dailyCases<4){
                covidScores=9;
                covidHash.put(cityName, covidScores);
            }else
            if(dailyCases<11){
                covidScores=8;
                covidHash.put(cityName, covidScores);
            }else
            if(dailyCases<21){
                covidScores=7;
                covidHash.put(cityName, covidScores);
            }else
            if(dailyCases<31){
                covidScores=6;
                covidHash.put(cityName, covidScores);
            }else
            if(dailyCases<41){
                covidScores=5;
                covidHash.put(cityName, covidScores);
            }else
            if(dailyCases<51){
                covidScores=4;
                covidHash.put(cityName, covidScores);
            }else
            if(dailyCases<71){
                covidScores=3;
                covidHash.put(cityName, covidScores);
            }else
            if(dailyCases<101){
                covidScores=2;
                covidHash.put(cityName, covidScores);
            }else
                covidScores=1;
                covidHash.put(cityName, covidScores);
        }

        return covidHash;
    }

    public Map<String, Integer> getWeatherScore(LocalDate date) {
        Map<String, Integer> weatherHash = new HashMap<>();
        for (int i = 0; i < getCities().size(); i++) {
            String cityName = getCities().get(i).getWeatherCityName();
            LocalDate dateNow = LocalDate.now();
            Period period = Period.between(date,dateNow);
            Integer timerange = period.getDays();
            Map map = weatherService.getWeatherByCityName(cityName);
            if (map == null) continue;
            String dailyCases = (String) ((Map)((List)((Map)((List) map.get("list")).get(timerange)).get("weather")).get(0)).get("description");
            Integer weatherScores ;
            switch (dailyCases){
                case "clear sky":
                    weatherHash.put(cityName,10);
                    break;
                case "few clouds":
                    weatherHash.put(cityName,9);
                    break;
                case "scattered clouds":
                    weatherHash.put(cityName,7);
                    break;
                case "broken clouds":
                    weatherHash.put(cityName,5);
                    break;
                case "shower rain":
                    weatherHash.put(cityName,4);
                    break;
                case "rain":
                    weatherHash.put(cityName,2);
                    break;
                case "thunderstorm":
                    weatherHash.put(cityName,1);
                    break;
                case "snow":
                    weatherHash.put(cityName,3);
                    break;
                case "mist":
                    weatherHash.put(cityName,2);
                    break;
                default:
                    break;
            }
        }
        return weatherHash;
    }





}
