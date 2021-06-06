package com.cursospring.microservicios.app.cursos.service;

import com.cursoSpring.microservicios.cammons.service.CammonServiceImpl;
import com.cursospring.microservicios.app.cursos.entity.Course;
import com.cursospring.microservicios.app.cursos.repository.CourseRepo;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl extends CammonServiceImpl<Course, CourseRepo> implements CourseService{
}
