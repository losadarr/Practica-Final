package com.example.demo.repository;

import com.example.demo.model.Turbina;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

public interface Repository
extends CrudRepository <Turbina, Long> { 

    @Query("SELECT * FROM TURBINA WHERE ID = ;")
    Turbina getInfoQuery(int i);

    @Query("SELECT * FROM TURBINA ;")
    Turbina[] getAllInfoQuery();
}
