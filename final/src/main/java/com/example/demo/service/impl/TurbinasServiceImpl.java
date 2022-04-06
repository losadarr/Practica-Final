package com.example.demo.service.impl;

import com.example.demo.model.Turbina;
import com.example.demo.repository.Repository;
import com.example.demo.service.TurbinasService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TurbinasServiceImpl implements TurbinasService{

    @Autowired
	private Repository  repositorio;

    @Override
    public Turbina getInfo(int i) {
        return repositorio.getInfoQuery(i);
    }

    @Override
    public Turbina getAllInfo() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int changeInfo(int i) {
        // TODO Auto-generated method stub
        return 0;
    }
    
}
