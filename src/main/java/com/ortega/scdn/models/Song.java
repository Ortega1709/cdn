package com.ortega.scdn.models;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Song {

    @Id
    private UUID id = UUID.randomUUID();
    private String title;
    private String artist;
    private String type;
    private String link;

}
