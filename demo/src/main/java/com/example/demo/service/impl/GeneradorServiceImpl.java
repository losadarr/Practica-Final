package com.example.demo.service.impl;

import java.util.Optional;

import com.example.demo.model.Generador;
import com.example.demo.repository.GeneradorRepository;
import com.example.demo.service.GeneradorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class GeneradorServiceImpl implements GeneradorService{

    @Autowired
    public GeneradorRepository repository;

    @Override
    public Generador findByID(Long id) {
        Optional<Generador> generador = repository.findById(id);
        if(generador.isEmpty()){
            return null;
        }
        return generador.get();
    }

    @Override
    public Iterable<Generador> findAll() {
        return repository.findAll();
    }

    @Override
    public Generador createGenerador(Generador generador){
        generador.setId(null);
        return repository.save(generador);
    }

/*     @Autowired
    private JdbcTemplate template;

    @Override
    public Iterable<TurbinaGeneradorJoin> findAllJoin(){
        String query = "SELECT TURBINAS.ID, TURBINAS.ENCENDIDO, TURBINAS.CARGA, GENERADOR.ID, GENERADOR.VOLTAJE, GENERADOR.ESTADO FROM TURBINAS INNER JOIN GENERADOR ON TURBINAS.ID = GENERADOR.IDTURBINA";
        Iterable<TurbinaGeneradorJoin> TGJoin = template.query(
            query,
            (data, rowNum) -> {
                return new TurbinaGeneradorJoin(
                    data.getLong("TURBINA.ID"),
                    data.getBoolean("TURBINA.ENCENDIDO"),
                    data.getLong("TURBINA.CARGA"),
                    data.getLong("GENERADOR.ID"),
                    data.getLong("GENERADOR.VOLTAJE"),
                    data.getString("GENERADOR.ESTADO")
                )
            });
        return TGJoin;
    }    */
}