package com.example.demo.controller;
import com.example.demo.model.Clima;
import com.example.demo.service.ClimaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.NonNull;

@RestController
@RequestMapping("/api/v1")
public class ClimaController {

    @Autowired
    private ClimaService servicio;

    @GetMapping("/clima")
    public ResponseEntity<Clima> getInfoController(){
        return new ResponseEntity<>(servicio.getClima(), HttpStatus.OK);
    }
}
