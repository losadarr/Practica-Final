package com.example.demo.controller;

import com.example.demo.model.Contacto;
import com.example.demo.service.ContactoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class ContactoController {
    @Autowired
    ContactoService servicio;

    @GetMapping("/contacto")
    public ResponseEntity<Iterable<Contacto>> getAllContacto() {
        return ResponseEntity.ok().body(servicio.findAll());
    }

    @GetMapping("/contacto/{tarifa}")
    public ResponseEntity<Iterable<Contacto>> getContactoByTarifa(@PathVariable String tarifa){
        return ResponseEntity.ok().body(servicio.findByTarifa(tarifa));
    }
}
