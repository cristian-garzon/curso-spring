package com.cursospring.microservicios.app.users.service;


import com.cursospring.microservicios.app.users.client.CourseFeingClient;
import com.cursoSpring.microservicios.app.users.repository.StudentRepo;
import com.cursoSpring.microservicios.cammons.service.CammonServiceImpl;
import com.cursospring.microservicios.cammons.students.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class StudentServiceImpl extends CammonServiceImpl<Student, StudentRepo> implements StudentService {


    @Autowired
    private CourseFeingClient courseFeingClient;

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

    @Override
    @Transactional
    public void deleteCourseStudent(Long id) {
       super.deleteById(id);
       courseFeingClient.deleteCourseStudent(id);
    }
}
