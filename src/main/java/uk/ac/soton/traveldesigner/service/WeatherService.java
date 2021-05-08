package uk.ac.soton.traveldesigner.service;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Map;

@Service
public class WeatherService {

    @Value("${xzWeather.weatherCode}")
    private String weatherKeyCode;

    @Autowired
    private RestTemplate restTemplate;

    public Map getWeatherByCityName(String cityName, LocalDate date) {
        ResponseEntity<Map> exchange = restTemplate.
                exchange("https://api.seniverse.com/v3/weather/now.json?key=" + weatherKeyCode + "&location=England " + cityName + "&language=zh-Hans&start="+ date +"&unit=c",
                        HttpMethod.GET, null, Map.class);
        return exchange.getBody();
    }
}
