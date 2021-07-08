package com.cursospring.microservicios.app.cursos.controller;

import com.cursoSpring.microservicios.cammons.controller.CammonController;
import com.cursopring.microservicios.cammons.examenes.Exams;
import com.cursospring.microservicios.app.cursos.entity.Course;
import com.cursospring.microservicios.app.cursos.service.CourseService;
import com.cursospring.microservicios.cammons.students.entity.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class CourseController extends CammonController<Course, CourseService> {

    // inyectamos el valor del balanceador de carga desde el aplication properties
    @Value("${config.balanced.test}")
    private String testBalancer;



    @GetMapping("/test_balancer")
    public ResponseEntity <?> balancer(){
        Map<String, Object> response = new HashMap<>();
        response.put("balancer", testBalancer);
        response.put("course", service.list());
        return ResponseEntity.ok(response);
    }
    @PutMapping("/edit/{id}")
    public ResponseEntity<?>  update(@Valid @RequestBody Course course, BindingResult result, @PathVariable Long id){
        if(result.hasErrors()) return this.validation(result);
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
    @GetMapping("/search_student/{id}")
    public ResponseEntity<?> findByStudent(@PathVariable Long id){
        Course course = service.findByIdAlumno(id);
        if(course == null) return ResponseEntity.notFound().build();
        else{
            List<Long> examsid =(List<Long>) service.listExams(id);
            List<Exams> exams = course.getExam().stream().map(exam -> {
                if(examsid.contains(exam.getId())) exam.setAnswered(true);
                return exam;
            }).collect(Collectors.toList());
            course.setExam(exams);
        }
        return ResponseEntity.ok(course);
    }

    @PutMapping("/add_exam/{id}")
    public ResponseEntity<?> addExam(@RequestBody List<Exams> exams, @PathVariable Long id){
        Optional<Course> course = service.findById(id);
        if(course.isEmpty()) return ResponseEntity.notFound().build();
        for(Exams exam : exams){
            course.get().addExam(exam);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(course.get()));
    }
    @PutMapping("/delete_exam/{id}")
    public ResponseEntity<?> deleteExam(@RequestBody Exams exam, @PathVariable Long id){
       Optional<Course> course = service.findById(id);
       if (course.isEmpty()) return ResponseEntity.notFound().build();
       course.get().removeExam(exam);
       return ResponseEntity.status(HttpStatus.CREATED).body(service.save(course.get()));
    }

    @GetMapping("search_exam/{id}")
    public ResponseEntity<?> findByExam(@PathVariable Long id){
        return ResponseEntity.ok(service.FindByIdExam(id));
    }
}
