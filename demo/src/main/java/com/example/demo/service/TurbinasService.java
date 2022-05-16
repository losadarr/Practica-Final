package com.example.demo.service;

import com.example.demo.model.Turbina;

public interface TurbinasService {
    Turbina findById(Long id);
    Iterable<Turbina> getAllInfo();
    Turbina updateTurbina(Turbina turbina);
    Turbina createInfo(Turbina turbina);
}
