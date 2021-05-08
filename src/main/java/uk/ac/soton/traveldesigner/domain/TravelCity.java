package uk.ac.soton.traveldesigner.domain;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Data
@ToString
@Table(name = "travel_city")
@Entity
public class TravelCity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cityId;
    private String cityName;
    private String COVIDGovLTLACityName;
    private String weatherCityName;

    private String gdpNamePS;
    private String gdpCityName;
    private String gdp2018;

    private Integer holidayVisit;
    private Integer travelVisit;
    private Integer totalVisit;
    private Double visitsIn10KRound;
    private Double visitScoreByRank;
    private Double visitScore;
    private String universityName;
    private Double universityScore;

    private Double gdp20181;
}
