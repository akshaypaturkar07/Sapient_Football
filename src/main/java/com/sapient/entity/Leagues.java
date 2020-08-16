package com.sapient.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class Leagues {
    private int league_id;
    private String league_name;
    private Country country;


}
