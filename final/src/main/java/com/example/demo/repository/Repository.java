package com.example.demo.repository;

import com.example.demo.model.Turbina;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface Repository extends CrudRepository <Turbina, Long> { 

    //@Query("SELECT * FROM TURBINA WHERE ID = :ID")
    //Turbina getInfoQuery(@Param("ID") int i);

    //@Query("SELECT * FROM TURBINA ;")
    //List<Turbina> getAllInfoQuery();

    @Query("INSERT INTO TURBINA VALUES(:ID, :ANGULO, :ALTURA, :VELOCIDAD_MAX, :ENCENDIDO, :CARGA")
    int addTurbina(@Param("ID")Long id, @Param("ANGULO")Long angulo, @Param("ALTURA")Long altura, @Param("VELOCIDAD_MAX")Long velocidad_max, @Param("ENCENDIDO")boolean on);

    // @Query("UPDATE TURBINA SET ANGULO = :ANGULO, ALTURA = :ALTURA, VELOCIDAD_MAX = :VELOCIDAD_MAX, ENCENDIDO = :ENCENDIDO WHERE ID = :ID")
    // int putInfo(@Param("ID")int i, @Param("ANGULO")int angulo, @Param("ALTURA")int altura, @Param("VELOCIDAD_MAX")int velocidad_max, @Param("ENCENDIDO")boolean on);

}
