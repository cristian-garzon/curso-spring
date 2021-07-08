package com.cursospring.microservicios.app.respuestas.service;

import com.cursoSpring.microservicios.cammons.service.CammonService;
import com.cursospring.microservicios.app.respuestas.entity.Answer;

public interface AnswerService extends CammonService<Answer> {
    public Iterable<Answer> saveAll(Iterable<Answer> answers);
    public Iterable<Answer> findAnswerByStudentByExam(Long idStudent, Long idExam);
    public Iterable<Long> findByidExamswhithAnswwerByStudent(Long idStudent);
}
