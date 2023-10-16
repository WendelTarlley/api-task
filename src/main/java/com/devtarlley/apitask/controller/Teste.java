package com.devtarlley.apitask.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teste")
public class Teste {

    @GetMapping
    public ResponseEntity<?> teste(){
        return ResponseEntity.ok("Hello World");
    }
}
