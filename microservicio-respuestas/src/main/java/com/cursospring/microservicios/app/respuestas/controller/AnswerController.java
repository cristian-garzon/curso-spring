package com.cursospring.microservicios.app.respuestas.controller;

import com.cursospring.microservicios.app.respuestas.entity.Answer;
import com.cursospring.microservicios.app.respuestas.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class AnswerController  {

    @Autowired
    private AnswerService service;
    @PostMapping("/save_all")
    public ResponseEntity<?> saveAll(@RequestBody Iterable<Answer> answers){
        answers = ((List<Answer>) answers).stream().map(answer -> {
            answer.setStudentId(answer.getStudent().getId());
            answer.setQuestionId(answer.getQuestion().getId());
            return answer;
        }).collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.CREATED).body(service.saveAll(answers));
    }

    @GetMapping("/list_answer/{idStudent}/{idExam}")
    public ResponseEntity<?> listAnswer(@PathVariable Long idStudent, @PathVariable Long idExam){
        Iterable<Answer> answers = service.findAnswerByStudentByQuestion(idStudent,idExam);
        return ResponseEntity.ok(answers);
    }

    @GetMapping("/list_exams/{id}")
    public ResponseEntity<?> listExams(@PathVariable Long id){
        return ResponseEntity.ok(service.findByidExamswhithAnswwerByStudent(id));
    }
}
