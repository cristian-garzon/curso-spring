package com.cursospring.microservicios.app.users.service;

import com.cursoSpring.microservicios.cammons.service.CammonService;
import com.cursospring.microservicios.cammons.students.entity.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface StudentService extends CammonService<Student> {
    public List<Student> search(String text);
    public Iterable<Student> findListStudents(Iterable<Long> ids);
    public void deleteCourseStudent(Long id);
}
