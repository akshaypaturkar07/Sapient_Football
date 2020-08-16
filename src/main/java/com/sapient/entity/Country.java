package com.sapient.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor
@Getter
@Setter
public class Country implements Serializable {
    private int country_id;
    private String country_name;


}
