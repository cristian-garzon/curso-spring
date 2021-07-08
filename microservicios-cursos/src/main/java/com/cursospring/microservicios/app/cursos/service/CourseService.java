package com.cursospring.microservicios.app.cursos.service;

import com.cursoSpring.microservicios.cammons.service.CammonService;
import com.cursospring.microservicios.app.cursos.entity.Course;
public interface CourseService extends CammonService<Course> {
    public Course findByIdAlumno(Long id);
    public Course FindByIdExam(Long id);
    public Iterable<Long> listExams( Long id);
}
