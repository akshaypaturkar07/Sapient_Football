package com.sapient.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StandingController {
    @RequestMapping(value = "/standing", method = RequestMethod.GET)
    public String standings(String countryName, String leagueName, String teamName) {

        return "";
    }
}
