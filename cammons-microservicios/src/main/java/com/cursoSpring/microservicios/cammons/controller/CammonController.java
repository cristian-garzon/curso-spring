package com.cursoSpring.microservicios.cammons.controller;

import com.cursoSpring.microservicios.cammons.service.CammonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class CammonController<E, S extends CammonService<E>> {

    @Autowired
    protected S service;

    @GetMapping("/list")
    public ResponseEntity<?> list(){
        return ResponseEntity.ok().body(service.list());
    }

    @GetMapping("/listP")
    public ResponseEntity<?> list(Pageable pageable){
        return ResponseEntity.ok().body(service.list(pageable));
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<?> find(@PathVariable Long id){
        Optional<E> entity = service.findById(id);
        if(entity.isEmpty()) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(entity.get());
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@Valid @RequestBody E entity, BindingResult result){
        if (result.hasErrors()) return this.validation(result);
        E entityCreated = service.save(entity);
        return ResponseEntity.status(HttpStatus.CREATED).body(entityCreated);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    protected ResponseEntity<?> validation(BindingResult result){
        Map<String, Object> errors = new HashMap<>();
        result.getFieldErrors().forEach(err -> {
            errors.put(err.getField(), "the camp " + err.getField() + " " +err.getDefaultMessage());
        });
        return ResponseEntity.badRequest().body(errors);
    }
}
