package uk.ac.soton.traveldesigner.api;

import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import uk.ac.soton.traveldesigner.controller.COVIDController;
import uk.ac.soton.traveldesigner.controller.RecommendController;
import uk.ac.soton.traveldesigner.controller.WeatherController;
import uk.ac.soton.traveldesigner.domain.TravelCity;
import uk.ac.soton.traveldesigner.service.TravelCityService;

import java.time.LocalDate;
import java.util.*;
import java.text.*;


@RestController
public class Controller {

  @Autowired
  private AutowireCapableBeanFactory beanFactory;

  @GetMapping("/api/plan")
  public Plan plan(
    @RequestParam(name = "COVID-19", required = false) Integer choiceCovid19,
    @RequestParam(name = "Weather", required = false) Integer choiceWeather,
    @RequestParam(name = "Travel", required = false) Integer choiceTravel,
    @RequestParam(name = "Shopping", required = false) Integer choiceShopping,
    @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate from,
    @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate to
  ) {
    // TODO: CRUD
    Plan result = new Plan();

    // RecommendController recommendController = new RecommendController();
    // NOTE: Tell Spring to reflect all stuff
    RecommendController recommendController = this.beanFactory.createBean(RecommendController.class);
    Map<String, Double> covidScore = recommendController.getCovidScore();
    Map<String, Double> weatherScore = recommendController.getWeatherScore(from);
    Map<String, Double> travelScore = recommendController.getTravelScore();
    Map<String, Double> shoppingScore = recommendController.getShoppingScore();
    Map<String, Double> finalScore = weatherScore;

    if (choiceCovid19 != null) {
      covidScore.forEach((key,value) -> finalScore.merge(key,value,Double::sum));
    }

    if (choiceTravel != null){
      travelScore.forEach((key,value) -> finalScore.merge(key,value,Double::sum));
    }

    if (choiceShopping != null){
      shoppingScore.forEach((key,value) -> finalScore.merge(key,value,Double::sum));
    }

    List<Map.Entry<String, Double>> list = new ArrayList<Map.Entry<String, Double>>(finalScore.entrySet());
    Collections.sort(list, new Comparator<Map.Entry<String, Double>>() {
      @Override
      public int compare(Map.Entry<String, Double> o1, Map.Entry<String, Double> o2) {
        return o2.getValue().compareTo(o1.getValue());
      }
    });


    for (int i = 0; i < 5; i++) {
      result.addDestination(new Destination(i+1, list.get(i).getKey(), "+0", "Sunny", "Traval", "Shopping"));
    }

    return result;
  }

}
