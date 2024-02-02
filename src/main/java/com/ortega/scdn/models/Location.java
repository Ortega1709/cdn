package com.ortega.scdn.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Location {

    @JsonProperty("lat")
    private double latitude;

    @JsonProperty("lon")
    private double longitude;

}
