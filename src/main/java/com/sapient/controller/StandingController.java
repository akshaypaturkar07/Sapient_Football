package com.sapient.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sapient.entity.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping(value = "/standing")
public class StandingController {
    @Autowired
    private RestTemplate restTemplate;
    String standingsUrl = "https://apiv2.apifootball.com/?action=get_standings&league_id=148&APIkey=9bb66184e0c8145384fd2cc0f7b914ada57b4e8fd2e4d6d586adcc27c257a978";

   @GetMapping(value = "/byParams")
    public String standings(String countryName, String leagueName, String teamName) throws Exception{
        ObjectMapper mapper = new ObjectMapper();
        String responseEntity = restTemplate.getForObject("https://apiv2.apifootball.com/?action=get_countries&APIkey=9bb66184e0c8145384fd2cc0f7b914ada57b4e8fd2e4d6d586adcc27c257a978",String.class);
        Country[] country = mapper.readValue(responseEntity, Country[].class);
        return "responseEntity";
    }
}
