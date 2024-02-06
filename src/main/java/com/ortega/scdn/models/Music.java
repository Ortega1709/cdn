package com.ortega.scdn.models;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Music {

    @Id
    private UUID id = UUID.randomUUID();
    private String title;
    private String link;
    private String artist;

}
