package uk.ac.soton.traveldesigner.api;

public class Destination {
  private int rank;
  private String name;
  private String covid19;
  private String weather;
  private String travel;
  private String shopping;

  public Destination(int rank, String name, String covid19, String weather, String travel, String shopping) {
    this.rank = rank;
    this.name = name;
    this.covid19 = covid19;
    this.weather = weather;
    this.travel = travel;
    this.shopping = shopping;
  }

  public int getRank() {
    return this.rank;
  }

  public String getName() {
    return this.name;
  }

  public String getCovid19() {
    return this.covid19;
  }

  public String getWeather() {
    return this.weather;
  }

  public String getTravel() {
    return this.travel;
  }

  public String getShopping() {
    return this.shopping;
  }
}
