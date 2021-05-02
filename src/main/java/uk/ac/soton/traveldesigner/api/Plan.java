package uk.ac.soton.traveldesigner.api;

import java.util.ArrayList;

public class Plan {
  private ArrayList<Destination> destinations;

  public Plan() {
    this.destinations = new ArrayList<Destination>();
  }

  public void addDestination(Destination dst) {
    this.destinations.add(dst);
  }

  public ArrayList<Destination> getDestinations() {
    return this.destinations;
  }
}
