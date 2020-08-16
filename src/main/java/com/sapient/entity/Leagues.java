package com.sapient.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor
@Getter
@Setter
public class Leagues implements Serializable {
    private int league_id;
    private String league_name;
    private Country country;


}
