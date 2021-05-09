package uk.ac.soton.traveldesigner.service;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Service
public class COVIDService {

    private String entryPointUrl = "https://api.coronavirus.data.gov.uk/v1/data";

    @Value("${waCOVID.appId}")
    private String appId;

    @Value("${waCOVID.COVIDCode}")
    private String COVIDCode;

    @Autowired
    private RestTemplate restTemplate;

    public Map getCOVIDByCityName(String cityName) {
        Map<String, String> structure = new HashMap<>();
        structure.put("date", "date");
        structure.put("name", "areaName");
        structure.put("code", "areaCode");
        structure.put("dailyCases", "newCasesByPublishDate");
        structure.put("cumulativeCases", "cumCasesByPublishDate");
        structure.put("dailyDeaths", "newDeaths28DaysByPublishDate");
        structure.put("cumulativeDeaths", "cumDeaths28DaysByPublishDate");
        String reqUrl;
        if (cityName == "London")
            reqUrl = entryPointUrl +"?filters=areaType=regions;areaName="+ cityName +"&structure={structure}";
        else
            reqUrl = entryPointUrl +"?filters=areaType=ltla;areaName="+ cityName +"&structure={structure}";

        Map forObject = restTemplate.getForObject(reqUrl, Map.class, JSON.toJSONString(structure));
        return forObject;
    }
}
