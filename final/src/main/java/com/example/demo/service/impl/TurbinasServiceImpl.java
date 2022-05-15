package com.example.demo.service.impl;

import java.util.List;
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
    public Turbina getInfo(Long i) {
        Optional<Turbina> turbina_get = repositorio.findById(i);
        Turbina turbina = turbina_get.get();
        return turbina;
    }

    @Override
    public Iterable<Turbina> getAllInfo() {
        return repositorio.findAll();
    }

    @Override
    public boolean putInfo(Long i, Long angulo, Long altura, Long velocidad_max, boolean on) {
        //return repositorio.putInfo(i, angulo, altura, velocidad_max, on);
        Optional<Turbina> turbina1 = repositorio.findById(i);
        if (turbina1.isEmpty()){
            return false;
        }

        Turbina turbina = turbina1.get();
        turbina.setAngulo(angulo);
        turbina.setAltura(altura);
        turbina.setVelocidad_max(velocidad_max);
        turbina.setOn(on);
        return true;
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
