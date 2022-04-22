package com.example.demo.controller;

import com.example.demo.model.Turbina;
import com.example.demo.service.TurbinasService;

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
public class TurbinaController {
    
    @Autowired
    private TurbinasService servicio;

    @GetMapping("/api/turbina")
    public ResponseEntity<Turbina> getInfoController(Long i){
        return new ResponseEntity<>(servicio.getInfo(i), HttpStatus.OK);
    }

    @GetMapping("/api/turbinas")
    public ResponseEntity<Iterable<Turbina>> getAllInfoController(){
        return new ResponseEntity<>(servicio.getAllInfo(), HttpStatus.OK);
    }

    @PutMapping("/api/turbina")
    public ResponseEntity<String> putInfo(@RequestBody Turbina turbina){
        Long id = turbina.getId();
        Long angulo = turbina.getAngulo();
        Long altura = turbina.getAltura();
        Long velocidad_max = turbina.getVelocidad_max();
        boolean on = turbina.getOn();
        servicio.putInfo(id, angulo, altura, velocidad_max, on);
        return new ResponseEntity<>("Ok! Cambios realizados", HttpStatus.OK);
    }

    @PostMapping("/api/turbina/{id}")
    public ResponseEntity<Turbina> postInfo(@PathVariable String id, @RequestBody Turbina turbina){

        return new ResponseEntity<>(turbina, HttpStatus.OK);
    }
    public record DataRequest(
        @NonNull
        Long id,

        @NonNull
        Long angulo,

        @NonNull
        Long altura,
        
        @NonNull
        Long velocidad_max,
        
        @NonNull
        boolean encendido,
        
        @NonNull
        Long carga) {}
}
