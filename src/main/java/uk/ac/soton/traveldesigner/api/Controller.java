package uk.ac.soton.traveldesigner.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

  @GetMapping("/api/plan")
  public Plan plan(
    @RequestParam(name = "COVID-19", required = false) Integer covid19,
    @RequestParam(name = "Weather", required = false) Integer weather,
    @RequestParam(name = "Travel", required = false) Integer travel,
    @RequestParam(name = "Shopping", required = false) Integer shopping,
    @RequestParam String from,
    @RequestParam String to
  ) {
    // TODO: CRUD
    Plan result = new Plan();
    result.addDestination(new Destination(1, "Example Destination 1", "+0", "Sunny", "Traval", "Shopping"));
    result.addDestination(new Destination(4, "Example Destination 2", "+0", "Sunny", "Traval", "Shopping"));
    result.addDestination(new Destination(2, "Example Destination 3", "+0", "Sunny", "Traval", "Shopping"));
    result.addDestination(new Destination(3, "Example Destination 4", "+0", "Sunny", "Traval", "Shopping"));
    return result;
  }

}
