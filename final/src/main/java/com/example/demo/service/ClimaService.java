package com.example.demo.service;

import com.example.demo.model.Clima;

import org.springframework.stereotype.Service;

@Service
public interface ClimaService {
    Clima getClima();
}
