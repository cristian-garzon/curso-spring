package com.cusrospring.microservicios.app.examenes.controller;

import com.cursoSpring.microservicios.cammons.controller.CammonController;
import com.cursopring.microservicios.cammons.examenes.Exams;
import com.cursopring.microservicios.cammons.examenes.Questions;
import com.cusrospring.microservicios.app.examenes.service.ExamService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class ExamController extends CammonController<Exams, ExamService> {
   @PutMapping("update/{id}")
   public ResponseEntity<?> update(@Valid @RequestBody Exams exam,BindingResult result, @PathVariable Long id){
      if(result.hasErrors()) return this.validation(result);
      Optional<Exams> examupdate = service.findById(id);
      if(examupdate.isEmpty()) return ResponseEntity.notFound().build();
      examupdate.get().setName(exam.getName());
      List<Questions> delete = new ArrayList<>();
      for (Questions question: examupdate.get().getQuestions()) {
         if(!exam.getQuestions().contains(question)) delete.add(question);
      }
      delete.forEach(examupdate.get()::removeQuestions);
      examupdate.get().setQuestions(exam.getQuestions());
      return ResponseEntity.status(HttpStatus.CREATED).body(service.save(examupdate.get()));
   }

   @GetMapping("search/{name}")
   public ResponseEntity<?> search(@PathVariable String name){
      return ResponseEntity.ok(service.search(name));
   }

   @GetMapping("/subject/list")
   public ResponseEntity<?> listsubject(){
      return ResponseEntity.ok(service.listSubject());
   }
}
