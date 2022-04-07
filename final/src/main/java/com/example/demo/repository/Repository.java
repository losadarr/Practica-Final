package com.example.demo.repository;

import java.util.List;

import com.example.demo.model.Turbina;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface Repository
extends CrudRepository <Turbina, Long> { 

    @Query("SELECT * FROM TURBINA WHERE ID = :ID")
    Turbina getInfoQuery(@Param("ID") int i);

    @Query("SELECT * FROM TURBINA ;")
    List<Turbina> getAllInfoQuery();
}
