package com.cursoSpring.microservicios.app.users.service;


import com.cursoSpring.microservicios.app.users.repository.StudentRepo;
import com.cursoSpring.microservicios.cammons.service.CammonServiceImpl;
import com.cursospring.microservicios.cammons.students.entity.Student;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class StudentServiceImpl extends CammonServiceImpl<Student, StudentRepo> implements StudentService {

    @Override
    @Transactional(readOnly = true)
    public List<Student> search(String text) {
        return repository.findByNameStartingWithOrSurnameStartingWith(text);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Student> findListStudents(Iterable<Long> ids) {
        return repository.findAllById(ids);
    }
}
