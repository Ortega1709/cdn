package com.ortega.scdn.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class SCdnController {

    @GetMapping("/info")
    public String index() {
        return "Serveur d'origine";
    }

}
