package com.cursospring.microservicios.app.respuestas.service;

import com.cursoSpring.microservicios.cammons.service.CammonServiceImpl;
import com.cursospring.microservicios.app.respuestas.entity.Answer;
import com.cursospring.microservicios.app.respuestas.repository.AnswerRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AnswerServiceImpl extends CammonServiceImpl<Answer, AnswerRepo> implements AnswerService{
    @Override
    @Transactional
    public Iterable<Answer> saveAll(Iterable<Answer> answers) {
               return repository.saveAll(answers);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Answer> findAnswerByStudentByExam(Long idStudent, Long idExam) {
        return repository.findAnswerByStudentByExam(idStudent, idExam);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Long> findByidExamswhithAnswwerByStudent(Long idStudent) {
        return repository.findByidExamswhithAnswwerByStudent(idStudent);
    }
}
