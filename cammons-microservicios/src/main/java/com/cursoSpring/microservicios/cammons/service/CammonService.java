package com.cursoSpring.microservicios.cammons.service;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;


public interface CammonService<E> {
    public Iterable<E> list();
    public Page<E> list(Pageable pageable);
    public Optional<E> findById(Long id);
    public E save(E entity);
    public void deleteById(Long id);
}
