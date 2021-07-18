package com.cursospring.microservicios.app.respuestas.service;

import com.cursoSpring.microservicios.cammons.service.CammonService;
import com.cursopring.microservicios.cammons.examenes.Exams;
import com.cursospring.microservicios.app.respuestas.entity.Answer;
import org.springframework.stereotype.Repository;

public interface AnswerService{
    public Iterable<Answer> saveAll(Iterable<Answer> answers);
    public Iterable<Answer> findAnswerByStudentByQuestion(Long idStudent, Long idExam);
    public Iterable<Long> findByidExamswhithAnswwerByStudent(Long idStudent);
}
