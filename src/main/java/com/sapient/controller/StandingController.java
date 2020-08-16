package com.sapient.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sapient.entity.Country;
import com.sapient.entity.Leagues;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/standing")
public class StandingController {
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping(value = "/byParams")
    public String standings(@RequestParam(name = "countryName") String countryName, @RequestParam(name = "leagueName") String leagueName, @RequestParam(name = "teamName") String teamName) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String responseEntity = restTemplate.getForObject("https://apiv2.apifootball.com/?action=get_countries&APIkey=9bb66184e0c8145384fd2cc0f7b914ada57b4e8fd2e4d6d586adcc27c257a978", String.class);
        List<Country> country = Arrays.asList(mapper.readValue(responseEntity, Country[].class));
        country = country.stream().filter(c -> c.getCountry_name() == countryName).collect(Collectors.toList());
        String responseEntity1 = restTemplate.getForObject("https://apiv2.apifootball.com/?action=get_leagues&country_id=" + country.get(0).getCountry_id() + "&APIkey=9bb66184e0c8145384fd2cc0f7b914ada57b4e8fd2e4d6d586adcc27c257a978", String.class);
        List<Leagues> leagues = Arrays.asList(mapper.readValue(responseEntity, Leagues[].class));
        return restTemplate.getForObject("https://apiv2.apifootball.com/?action=get_standings&league_id=148&APIkey=9bb66184e0c8145384fd2cc0f7b914ada57b4e8fd2e4d6d586adcc27c257a978", String.class);
    }
}
