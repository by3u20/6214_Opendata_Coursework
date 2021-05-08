package uk.ac.soton.traveldesigner.mapper;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uk.ac.soton.traveldesigner.domain.TravelCity;

import java.util.List;

@Repository
public interface TravelCityMapper extends JpaRepository<TravelCity, Integer> {
    TravelCity findByCityName(String cityName);

}
