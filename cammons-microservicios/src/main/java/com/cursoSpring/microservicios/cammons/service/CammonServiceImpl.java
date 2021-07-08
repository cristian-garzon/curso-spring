package com.cursoSpring.microservicios.cammons.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


public class CammonServiceImpl<E,R extends PagingAndSortingRepository<E,Long>> implements CammonService<E> {

    @Autowired
    protected R repository ;

    @Override
    @Transactional(readOnly = true)
    public Iterable<E> list() {
        return repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Page<E> list(Pageable pageable) {
        return repository.findAll(pageable);
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
