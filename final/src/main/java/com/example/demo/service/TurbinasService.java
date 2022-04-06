package com.example.demo.service;

import com.example.demo.model.Turbina;

public interface TurbinasService {
    Turbina getInfo(int i);
    Turbina getAllInfo();
    int changeInfo(int i);
}
