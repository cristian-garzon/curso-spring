package com.cursoSpring.microservicios.app.users.controller;

import com.cursoSpring.microservicios.app.users.entity.Student;
import com.cursoSpring.microservicios.app.users.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/list")
    public ResponseEntity<?> list(){
        return ResponseEntity.ok().body(studentService.list());
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<?> find(@PathVariable Long id){
        Optional<Student> student = studentService.findById(id);
        if(student.isEmpty()) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(student.get());
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody Student student){
        Student studentCreated = studentService.save(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(studentCreated);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<?> update(@RequestBody Student student, @PathVariable Long id){
        Optional<Student> studentUpdated = studentService.findById(id);
        if(studentUpdated.isEmpty()) return ResponseEntity.notFound().build();
        studentUpdated.get().setName(student.getName());
        studentUpdated.get().setSurname(student.getSurname());
        studentUpdated.get().setEmail(student.getEmail());
        return ResponseEntity.status(HttpStatus.CREATED).body(studentService.save(studentUpdated.get()));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        studentService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
