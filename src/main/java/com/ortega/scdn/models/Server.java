package com.ortega.scdn.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Server {
    @Id
    private UUID id = UUID.randomUUID();
    private String name;
    private Location location;
    private double latency;
    private double bandwidth;
    private String address;
    private Boolean available = true;

}
