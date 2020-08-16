package com.sapient.controller

import com.sapient.exception.EntityNotExistException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.servlet.MockMvc
import spock.lang.Specification

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@AutoConfigureWebMvc
@WebMvcTest(controllers = StandingController)
class StandingControllerSpec extends Specification {
    @Autowired
    private MockMvc mockMvc;

    def 'testing standings by countryname , team name and league name'() {
        given:

        when:
        mockMvc.perform(get("/standing/byParams?countryName=" + countryName + "&&leagueName=" + leagueName + "&&teamName=" + teamName).contentType("application/json")).andExpect(status().is(statusCode));

        then:
        0 *_._
        //result.andExpect(status().is(statusCode))
        //result == expected

        where:
        countryName | leagueName     | teamName | statusCode
        "England"   | "Championship" | "Leeds"  | 200
        "England"   | "Championship" | "Leeds1"  | 403
        "England1"   | "Championship" | "Leeds1"  | 403
        "England"   | "Championship1" | "Leeds1"  | 403
    }

}
