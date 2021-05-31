package com.cursoSpring.microservicios.cammons.controller;

import com.cursoSpring.microservicios.cammons.service.CammonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

public class CammonController<E, S extends CammonService<E>> {

    @Autowired
    protected S service;

    @GetMapping("/list")
    public ResponseEntity<?> list(){
        return ResponseEntity.ok().body(service.list());
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<?> find(@PathVariable Long id){
        Optional<E> entity = service.findById(id);
        if(entity.isEmpty()) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(entity.get());
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody E entity){
        E entityCreated = service.save(entity);
        return ResponseEntity.status(HttpStatus.CREATED).body(entityCreated);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
