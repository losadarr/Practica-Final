package com.example.demo.controller;

import com.example.demo.model.Turbina;
import com.example.demo.service.TurbinasService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class TurbinaController {
    
    @Autowired
    private TurbinasService servicio;

    @GetMapping("/turbina/{id}")
    public ResponseEntity<Turbina> getInfoController(@PathVariable("id") String id){
        Long idLong = Long.parseLong(id); 
        return new ResponseEntity<>(servicio.findById(idLong), HttpStatus.OK);
    }

    @GetMapping("/turbina")
    public ResponseEntity<Iterable<Turbina>> getAllInfoController(){
        return new ResponseEntity<>(servicio.getAllInfo(), HttpStatus.OK);
    }

    @PutMapping("/turbina")
    public ResponseEntity<Turbina> putInfo(@RequestBody Turbina turbina){
        Turbina turbinaComp = servicio.findById(turbina.getId());
        if(turbinaComp == null){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().body(servicio.updateTurbina(turbina));
    }

    @PostMapping("/turbina")
    public ResponseEntity<Turbina> postInfo(@RequestBody Turbina turbina){
        Turbina turbinaComp = servicio.findById(turbina.getId());
        if(turbinaComp != null){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().body(servicio.createInfo(turbina));
    }
}
