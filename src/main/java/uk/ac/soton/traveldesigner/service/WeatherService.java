package uk.ac.soton.traveldesigner.service;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class WeatherService {

    @Value("${xzWeather.weatherCode}")
    private String weatherKeyCode;

    @Autowired
    private RestTemplate restTemplate;

    private String entryPointUrl = "http://api.openweathermap.org/data/2.5/forecast/daily?q=";

    public Map getWeatherByCityName(String cityName) {
        Map<String, String> structure = new HashMap<>();
        String reqUrl = entryPointUrl+cityName+",GB&cnt=15&appid=2b4662933b5e3ac426c27ef99a9ea505";
        Map forObject = restTemplate.getForObject(reqUrl, Map.class, JSON.toJSONString(structure));
        return forObject;
    }
}

