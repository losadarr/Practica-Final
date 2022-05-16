package com.example.demo.service.impl;

import java.util.Optional;

import com.example.demo.model.Turbina;
import com.example.demo.repository.TurbinaRepository;
import com.example.demo.service.TurbinasService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TurbinasServiceImpl implements TurbinasService{

    @Autowired
	private TurbinaRepository repositorio;

    @Override
    public Turbina findById(Long id) {
        Optional<Turbina> turbina_get = repositorio.findById(id);
        if(turbina_get.isEmpty()){
            return null;
        }
        return turbina_get.get();
    }

    @Override
    public Iterable<Turbina> getAllInfo() {
        return repositorio.findAll();
    }

    @Override
    public Turbina updateTurbina(Turbina turbina) {
        Optional<Turbina> turbina1 = repositorio.findById(turbina.getId());
        if (turbina1.isEmpty()){
            return null;
        }
        Turbina turbina2 = turbina1.get();
        turbina2.setAngulo(turbina.getAngulo());
        turbina2.setAltura(turbina.getAltura());
        turbina2.setVelocidad_max(turbina.getVelocidad_max());
        turbina2.setOn(turbina.getOn());
        turbina2.setCarga(turbina.getCarga());
        return turbina2;
    }

    @Override
    public Turbina createInfo(Turbina turbina){
        Long id = turbina.getId();
        Long angulo = turbina.getAngulo();
        Long altura = turbina.getAltura();
        Long velocidad_max = turbina.getVelocidad_max();
        boolean on = turbina.getOn();

        repositorio.addTurbina(id, angulo, altura, velocidad_max, on);
        return turbina;
    }
    
}
