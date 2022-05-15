package com.example.demo.service;

import com.example.demo.model.Contacto;

public  interface ContactoService {
    Contacto findById(Long id);
    Iterable<Contacto> findAll();
    Iterable<Contacto> findByTarifa(String tarifa);
}
