package com.cursoSpring.microservicios.cammons.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


public class CammonServiceImpl<E,R extends JpaRepository<E,Long>> implements CammonService<E> {

    @Autowired
    protected R repository ;

    @Override
    @Transactional(readOnly = true)
    public Iterable<E> list() {
        return repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<E> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    @Transactional
    public E save(E entity) {
        return repository.save(entity);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
