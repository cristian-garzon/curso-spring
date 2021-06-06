package com.cursoSpring.microservicios.app.users.service;

import com.cursoSpring.microservicios.cammons.service.CammonService;
import com.cursospring.microservicios.cammons.students.entity.Student;

import java.util.List;

public interface StudentService extends CammonService<Student> {
    public List<Student> search(String text);
}
