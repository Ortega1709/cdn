package com.ortega.scdn.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CdnServer {

    private UUID id;
    private String name;
    private double latency;
    private Location location;

}
