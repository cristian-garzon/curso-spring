package com.cursoSpring.microservicios.app.users.service;


import com.cursoSpring.microservicios.app.users.entity.Student;
import com.cursoSpring.microservicios.app.users.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepo studentRepo;

    @Override
    @Transactional(readOnly = true)
    public Iterable<Student> list() {
        return studentRepo.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Student> findById(Long id) {
        return studentRepo.findById(id);
    }

    @Override
    @Transactional
    public Student save(Student student) {
        return studentRepo.save(student);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        studentRepo.deleteById(id);
    }
}
