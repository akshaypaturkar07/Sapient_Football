package com.sapient.entity;

import java.io.Serializable;

public class Leagues implements Serializable {
    private int league_id;
    private int country_id;
    private String country_name;
    private String country_logo;
    private String league_name;
    private String league_season;
    private String league_logo;
    private Country country;


    public Leagues() {
    }

    public int getLeague_id() {
        return league_id;
    }

    public void setLeague_id(int league_id) {
        this.league_id = league_id;
    }

    public String getLeague_name() {
        return league_name;
    }

    public void setLeague_name(String league_name) {
        this.league_name = league_name;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public String getLeague_season() {
        return league_season;
    }

    public void setLeague_season(String league_season) {
        this.league_season = league_season;
    }

    public String getLeague_logo() {
        return league_logo;
    }

    public void setLeague_logo(String league_logo) {
        this.league_logo = league_logo;
    }

    public int getCountry_id() {
        return country_id;
    }

    public void setCountry_id(int country_id) {
        this.country_id = country_id;
    }

    public String getCountry_name() {
        return country_name;
    }

    public void setCountry_name(String country_name) {
        this.country_name = country_name;
    }

    public String getCountry_logo() {
        return country_logo;
    }

    public void setCountry_logo(String country_logo) {
        this.country_logo = country_logo;
    }
}
