package com.cursospring.microservicios.app.cursos.controller;

import com.cursoSpring.microservicios.cammons.controller.CammonController;
import com.cursospring.microservicios.app.cursos.entity.Course;
import com.cursospring.microservicios.app.cursos.service.CourseService;
import com.cursospring.microservicios.cammons.students.entity.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CourseController extends CammonController<Course, CourseService> {

    @PutMapping("/edit/{id}")
    public ResponseEntity<?>  update(@RequestBody Course course, @PathVariable Long id){
        Optional<Course> courseUpdate = service.findById(id);
        if(courseUpdate.isEmpty()) return ResponseEntity.notFound().build();
        courseUpdate.get().setName(course.getName());
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(courseUpdate.get()));
    }

    @PutMapping("/add_student/{id}")
    public ResponseEntity<?> addStudent(@RequestBody List<Student> students ,@PathVariable Long id){
        Optional<Course> course = service.findById(id);
        if(course.isEmpty()) return ResponseEntity.notFound().build();
        for (Student student : students) {
            course.get().addStudent(student);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(course.get()));
    }
    @PutMapping("/delete_student/{id}")
    public ResponseEntity<?> deleteStudent(@RequestBody Student student ,@PathVariable Long id){
        Optional<Course> course = service.findById(id);
        if(course.isEmpty()) return ResponseEntity.notFound().build();
        course.get().removeStudent(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(course.get()));
    }
}
