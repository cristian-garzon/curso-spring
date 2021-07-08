package com.cursoSpring.microservicios.app.users.controller;

import com.cursoSpring.microservicios.app.users.service.StudentService;
import com.cursoSpring.microservicios.cammons.controller.CammonController;
import com.cursospring.microservicios.cammons.students.entity.Student;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.util.Optional;

@RestController
public class StudentController extends CammonController<Student, StudentService> {

    @GetMapping ("/show_photo/{id}")
    public ResponseEntity<?> showPhoto(@PathVariable Long id){
        Optional<Student> photo = service.findById(id);
        if(photo.isEmpty() || photo.get().getPhoto() == null) return ResponseEntity.notFound().build();
        Resource img = new ByteArrayResource(photo.get().getPhoto());
        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(img);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<?> update(@Valid @RequestBody Student student, BindingResult result, @PathVariable Long id) {

        if(result.hasErrors()) return this.validation(result);
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

    @PostMapping("/save_photo")
    public ResponseEntity<?> savePhoto(@Valid Student student, BindingResult result, @RequestParam MultipartFile file) throws IOException {
        if(!file.isEmpty()) student.setPhoto(file.getBytes());
        return super.save(student, result);
    }
    @PutMapping("/update_photo/{id}")
    public ResponseEntity<?> updatePhoto(@Valid Student student, BindingResult result,@PathVariable Long id, @RequestParam MultipartFile file ) throws IOException {
        if(result.hasErrors()) return this.validation(result);
        Optional<Student> studentUpdated = service.findById(id);
        if (studentUpdated.isEmpty()) return ResponseEntity.notFound().build();
        studentUpdated.get().setName(student.getName());
        studentUpdated.get().setSurname(student.getSurname());
        studentUpdated.get().setEmail(student.getEmail());
        if(!file.isEmpty()) studentUpdated.get().setPhoto(file.getBytes());
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(studentUpdated.get()));
    }
}
