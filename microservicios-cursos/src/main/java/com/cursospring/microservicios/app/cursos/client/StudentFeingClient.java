package com.cursospring.microservicios.app.cursos.client;

import com.cursospring.microservicios.cammons.students.entity.Student;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "microservicios-usuarios")
public interface StudentFeingClient {


    @GetMapping("/list_students")
    public List<Student> listStudents(@RequestParam List<Long> ids);
}
