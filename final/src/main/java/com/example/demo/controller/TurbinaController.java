package com.example.demo.controller;

import com.example.demo.model.Turbina;
import com.example.demo.service.TurbinasService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TurbinaController {
    
    @Autowired
    private TurbinasService servicio;

    @GetMapping("/api/getinfo")
    public ResponseEntity<Turbina> getInfoController(int i){
        return new ResponseEntity<>(servicio.getInfo(i), HttpStatus.OK);
    }

    @PutMapping("/api/putInfo")
    public String putInfo(Turbina turbina){
        //codigo que cambia la turbina
        return "Ok! Changes made";
    }
}
