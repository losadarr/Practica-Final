package com.example.demo.controller;
import com.example.demo.model.Clima;
import com.example.demo.service.ClimaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1")
public class ClimaController {

    @Autowired
    private ClimaService servicio;

    @GetMapping("/clima")
    public ResponseEntity<Clima> retrieveClima(){
        return ResponseEntity.ok().body(servicio.getClima());
    }
}
