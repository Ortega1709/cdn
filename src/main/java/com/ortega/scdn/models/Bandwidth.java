package com.ortega.scdn.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Bandwidth {
    LOW(10),
    MEDIUM(50),
    HIGH(100);

    private final int value;
}
