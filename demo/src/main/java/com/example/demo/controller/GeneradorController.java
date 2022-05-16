package com.example.demo.controller;

import com.example.demo.join.TurbinaGeneradorJoin;
import com.example.demo.model.Generador;
import com.example.demo.service.GeneradorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class GeneradorController{
    @Autowired
    private GeneradorService servicio;

    @GetMapping("/generador")
    public ResponseEntity<Iterable<Generador>> findAllGenerador(){
        return ResponseEntity.ok().body(servicio.findAll());
    }

    @GetMapping("/generador/{id}")
    public ResponseEntity<Generador> findById(@PathVariable String id ){
        Long idlong = Long.parseLong(id);
        Generador generador = servicio.findByID(idlong);
        if(generador == null){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().body(generador);
    }

    @PostMapping("/generador")
    public ResponseEntity<Generador> createGenerador(@RequestBody Generador generador){
        Generador newGenerador = servicio.createGenerador(generador);
        return ResponseEntity.ok().body(newGenerador);

    }

    @GetMapping("/generador/join")
    public ResponseEntity<Iterable<TurbinaGeneradorJoin>> findAllJoin(){
        return ResponseEntity.ok().body(servicio.findAllJoin());
    }
}
