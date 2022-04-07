package com.example.demo.repository;

import java.util.List;

import com.example.demo.model.Turbina;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface Repository extends CrudRepository <Turbina, Long> { 

    //@Query("SELECT * FROM TURBINA WHERE ID = :ID")
    //Turbina getInfoQuery(@Param("ID") int i);

    //@Query("SELECT * FROM TURBINA ;")
    //List<Turbina> getAllInfoQuery();

    List<Turbina> findAll();

    @Query("UPDATE TURBINA SET ANGULO = :ANGULO, ALTURA = :ALTURA, VELOCIDAD_MAX = :VELOCIDAD_MAX, ENCENDIDO = :ENCENDIDO WHERE ID = :ID")
    int putInfo(@Param("ID")int i, @Param("ANGULO")int angulo, @Param("ALTURA")int altura, @Param("VELOCIDAD_MAX")int velocidad_max, @Param("ENCENDIDO")boolean on);
}
