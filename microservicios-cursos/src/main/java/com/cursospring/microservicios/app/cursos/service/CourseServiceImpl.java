package com.cursospring.microservicios.app.cursos.service;

import com.cursoSpring.microservicios.cammons.service.CammonServiceImpl;
import com.cursospring.microservicios.app.cursos.entity.Course;
import com.cursospring.microservicios.app.cursos.repository.CourseRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CourseServiceImpl extends CammonServiceImpl<Course, CourseRepo> implements CourseService{
    @Override
    @Transactional(readOnly = true)
    public Course findByIdAlumno(Long id) {
        return repository.findByIdAlumno(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Course FindByIdExam(Long id) {
        return repository.findByIdExam(id);
    }

}
