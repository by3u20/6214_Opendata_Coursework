package uk.ac.soton.traveldesigner.api;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import uk.ac.soton.traveldesigner.controller.COVIDController;
import uk.ac.soton.traveldesigner.controller.RecommendController;
import uk.ac.soton.traveldesigner.controller.WeatherController;

import java.time.LocalDate;
import java.util.Date;
import  java.util.*;
import java.text.*;


@RestController
public class Controller {

  @GetMapping("/api/plan")
  public Plan plan(
    @RequestParam(name = "COVID-19", required = false) Integer covid19,
    @RequestParam(name = "Weather", required = false) Integer weather,
    @RequestParam(name = "Travel", required = false) Integer travel,
    @RequestParam(name = "Shopping", required = false) Integer shopping,
    @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate from,
    @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate to
  ) {
    // TODO: CRUD
    Plan result = new Plan();
    String cityName = "Southampton";

    RecommendController recommendController = new RecommendController();
    Map<String, Integer> covidScore = recommendController.getCovidScore();
    Map<String, Integer> weatherScore = recommendController.getWeatherScore(from);
    Map<String, Double> travelScore = recommendController.getTravelScore();
    Map<String, Double> shoppingScore = recommendController.getShoppingScore();

    Map<String, Integer> finalScore;

    result.addDestination(new Destination(1, "Example Destination 1", "+0", "Sunny", "Traval", "Shopping"));
    result.addDestination(new Destination(4, "Example Destination 2", "+0", "Sunny", "Traval", "Shopping"));
    result.addDestination(new Destination(2, "Example Destination 3", "+0", "Sunny", "Traval", "Shopping"));
    result.addDestination(new Destination(3, "Example Destination 4", "+0", "Sunny", "Traval", "Shopping"));
    return result;
  }

}
