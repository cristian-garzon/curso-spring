package com.cursoSpring.microservicios.cammons.service;


import java.util.Optional;


public interface CammonService<E> {
    public Iterable<E> list();
    public Optional<E> findById(Long id);
    public E save(E entity);
    public void deleteById(Long id);
}
