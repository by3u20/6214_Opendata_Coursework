package uk.ac.soton.traveldesigner.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

  @GetMapping("/api/plan")
  public Plan plan(
    @RequestParam(value = "from") String from,
    @RequestParam(value = "to") String to
  ) {
    // TODO: CRUD
    Plan result = new Plan();
    result.addDestination(new Destination(1, "Example Destination", "Sunny", "+0"));
    return result;
  }

}
