package com.example.demo.controller;

import java.util.List;

import com.example.demo.model.Turbina;
import com.example.demo.service.TurbinasService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TurbinaController {
    
    @Autowired
    private TurbinasService servicio;

    @GetMapping("/api/getinfo")
    public ResponseEntity<Turbina> getInfoController(Long i){
        return new ResponseEntity<>(servicio.getInfo(i), HttpStatus.OK);
    }

    @GetMapping("/api/getAllInfo")
    public ResponseEntity<List<Turbina>> getAllInfoController(){
        return new ResponseEntity<>(servicio.getAllInfo(), HttpStatus.OK);
    }

    @PutMapping("/api/putInfo")
    public String putInfo(@RequestBody Turbina turbina){
        Long id = turbina.getId();
        Long angulo = turbina.getAngulo();
        Long altura = turbina.getAltura();
        Long velocidad_max = turbina.getVelocidad_max();
        boolean on = turbina.getOn();
        servicio.putInfo(id, angulo, altura, velocidad_max, on);
        return "Ok! Changes made";
    }
}
