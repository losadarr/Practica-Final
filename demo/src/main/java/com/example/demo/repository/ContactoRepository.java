package com.example.demo.repository;

import com.example.demo.model.Contacto;

import org.springframework.data.repository.CrudRepository;

public interface ContactoRepository extends CrudRepository<Contacto,Long> {
    Iterable<Contacto> findAllByTarifa(String tarifa);
}
