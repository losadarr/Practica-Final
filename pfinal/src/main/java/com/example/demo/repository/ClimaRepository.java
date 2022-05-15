package com.example.demo.repository;

import com.example.demo.model.Clima;

import org.springframework.data.repository.CrudRepository;

public interface ClimaRepository extends CrudRepository<Clima,Long> {

}
