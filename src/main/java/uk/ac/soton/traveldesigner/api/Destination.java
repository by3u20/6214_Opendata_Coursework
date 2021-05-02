package uk.ac.soton.traveldesigner.api;

public class Destination {
  private int rank;
  private String name;
  private String weather;
  private String covid19;

  public Destination(int rank, String name, String weather, String covid19) {
    this.rank = rank;
    this.name = name;
    this.weather = weather;
    this.covid19 = covid19;
  }

  public int getRank() {
    return this.rank;
  }

  public String getName() {
    return this.name;
  }

  public String getWeather() {
    return this.weather;
  }

  public String getCovid19() {
    return this.covid19;
  }
}
