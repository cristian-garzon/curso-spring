package com.cursospring.microservicios.app.respuestas.controller;

import com.cursoSpring.microservicios.cammons.controller.CammonController;
import com.cursospring.microservicios.app.respuestas.entity.Answer;
import com.cursospring.microservicios.app.respuestas.service.AnswerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AnswerController extends CammonController<Answer, AnswerService> {

    @PostMapping("/save_all")
    public ResponseEntity<?> saveAll(@RequestBody Iterable<Answer> answers){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.saveAll(answers));
    }

    @GetMapping("/list_answer/{idStudent}/{idExam}")
    public ResponseEntity<?> listAnswer(@PathVariable Long idStudent, @PathVariable Long idExam){
        return ResponseEntity.ok(service.findAnswerByStudentByExam(idStudent,idExam));
    }

    @GetMapping("/list_exams/{id}")
    public ResponseEntity<?> listExams(@PathVariable Long id){
        return ResponseEntity.ok(service.findByidExamswhithAnswwerByStudent(id));
    }
}
