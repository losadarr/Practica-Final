package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Turbina;

public interface TurbinasService {
    Turbina getInfo(int i);
    List<Turbina> getAllInfo();
    int changeInfo(int i);
}
