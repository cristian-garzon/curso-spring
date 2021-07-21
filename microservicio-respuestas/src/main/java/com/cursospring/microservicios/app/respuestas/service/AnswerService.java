package com.cursospring.microservicios.app.respuestas.service;

import com.cursospring.microservicios.app.respuestas.entity.Answer;

public interface AnswerService{
    public Iterable<Answer> saveAll(Iterable<Answer> answers);
    public Iterable<Answer> findAnswerByStudentByQuestion(Long idStudent, Long idExam);
    public Iterable<Answer> findAnswerByStudentId(Long studentId);
    public Iterable<Long> findByidExamswhithAnswwerByStudent(Long studentId);
}
