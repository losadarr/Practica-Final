package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Turbina;

public interface TurbinasService {
    Turbina getInfo(Long i);
    Iterable<Turbina> getAllInfo();
    boolean putInfo(Long i, Long angulo, Long altura, Long velocidad_max, boolean on);
    Turbina createInfo(Turbina turbina);
}
