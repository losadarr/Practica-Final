package com.example.demo.service.impl;

import java.util.Random;

import com.example.demo.model.Clima;
import com.example.demo.repository.ClimaRepository;
import com.example.demo.service.ClimaService;

import org.springframework.beans.factory.annotation.Autowired;

public class ClimaServiceImpl implements ClimaService{

    @Autowired
    private ClimaRepository repository;

    @Override
    public Clima getClima() {
        Random rn = new Random();
        Long x = rn.nextLong(4);
        return repository.findById(x).get();
    }
    
}
