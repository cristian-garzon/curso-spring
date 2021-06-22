package com.cursoSpring.microservicios.app.users.controller;

import com.cursoSpring.microservicios.app.users.service.StudentService;
import com.cursoSpring.microservicios.cammons.controller.CammonController;
import com.cursospring.microservicios.cammons.students.entity.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentController extends CammonController<Student, StudentService> {


    @PutMapping("/edit/{id}")
    public ResponseEntity<?> update(@RequestBody Student student, @PathVariable Long id) {
        Optional<Student> studentUpdated = service.findById(id);
        if (studentUpdated.isEmpty()) return ResponseEntity.notFound().build();
        studentUpdated.get().setName(student.getName());
        studentUpdated.get().setSurname(student.getSurname());
        studentUpdated.get().setEmail(student.getEmail());
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(studentUpdated.get()));
    }

    @GetMapping("/search/{name}")
    public ResponseEntity<?> search(@PathVariable String name){
        return ResponseEntity.ok(service.search(name));
    }

}
