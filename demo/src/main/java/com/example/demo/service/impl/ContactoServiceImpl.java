package com.example.demo.service.impl;

import java.util.Optional;

import com.example.demo.model.Contacto;
import com.example.demo.repository.ContactoRepository;
import com.example.demo.service.ContactoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service 
public class ContactoServiceImpl implements ContactoService{

    @Autowired
    private ContactoRepository repository;

    @Override
    public Contacto findById(Long id) {
        Optional<Contacto> contacto = repository.findById(id);
        if(contacto.isEmpty()){
            return null;
        }
        return contacto.get();
    }

    @Override
    public Iterable<Contacto> findAll() {
        return repository.findAll();
    }

    @Override
    public Iterable<Contacto> findByTarifa(String tarifa) {
        return repository.findAllByTarifa(tarifa);
    }
    
}
