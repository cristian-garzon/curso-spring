package com.cursoSpring.microservicios.app.users.service;

import com.cursoSpring.microservicios.app.users.entity.Student;

import java.util.Optional;


public interface StudentService {
    public Iterable<Student> list();
    public Optional<Student> findById(Long id);
    public Student save(Student student);
    public void deleteById(Long id);
}
