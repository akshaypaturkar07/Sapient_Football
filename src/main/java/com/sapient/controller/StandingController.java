package com.sapient.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sapient.entity.Country;
import com.sapient.entity.Leagues;
import com.sapient.entity.Standing;
import com.sapient.exception.EntityNotExistException;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/standing")
public class StandingController {
    private final RestTemplate restTemplate;
    final String apiKey = "9bb66184e0c8145384fd2cc0f7b914ada57b4e8fd2e4d6d586adcc27c257a978";
    ObjectMapper mapper = new ObjectMapper();

    public StandingController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping(value = "/byParams")
    public String standings(@RequestParam(name = "countryName") String countryName, @RequestParam(name = "leagueName") String leagueName, @RequestParam(name = "teamName") String teamName) {
        List<Leagues> leagues = new ArrayList<>();
        List<Standing> standings = new ArrayList<>();
        try {
            String responseEntity = restTemplate.getForObject("https://apiv2.apifootball.com/?action=get_countries&APIkey=" + apiKey, String.class);
            List<Country> country = Arrays.stream(mapper.readValue(responseEntity, Country[].class))
                    .filter(c -> c.getCountry_name().equals(countryName))
                    .collect(Collectors.toList());
            if (!country.isEmpty()) {
                String responseEntity1 = restTemplate.getForObject("https://apiv2.apifootball.com/?action=get_leagues&country_id=" + country.get(0).getCountry_id() + "&APIkey=" + apiKey, String.class);
                if (!StringUtils.isEmpty(responseEntity1))
                    leagues = Arrays.stream(mapper.readValue(responseEntity1, Leagues[].class))
                            .filter(l -> l.getLeague_name().equals(leagueName))
                            .collect(Collectors.toList());

            } else {
                
                return "Country is not part of standing";
            }
            if (!leagues.isEmpty()) {
                String responseEntity2 = restTemplate.getForObject("https://apiv2.apifootball.com/?action=get_standings&league_id=" + leagues.get(0).getLeague_id() + "&APIkey=" + apiKey, String.class);
                if (!StringUtils.isEmpty(responseEntity2)) {
                    standings = Arrays.stream(mapper.readValue(responseEntity2, Standing[].class))
                            .filter(e -> e.getTeam_name().equals(teamName))
                            .collect(Collectors.toList());
                }
            } else {
                throw new EntityNotExistException("Leagues for countries does not exist");
            }
            if (standings.size() > 0) {
                return mapper.writeValueAsString(standings.get(0));
            } else {
                throw new EntityNotExistException("Standing cannot be found with league Name and Country name combination");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Country or league is not available for fetching standing";


    }
}
