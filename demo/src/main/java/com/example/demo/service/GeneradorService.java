package com.example.demo.service;

import com.example.demo.model.Generador;

public interface GeneradorService {
    Generador findByID(Long id);
    Iterable<Generador> findAll();
}
