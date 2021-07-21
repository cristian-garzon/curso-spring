package com.cusrospring.microservicios.app.examenes.service;

import com.cursoSpring.microservicios.cammons.service.CammonServiceImpl;
import com.cursopring.microservicios.cammons.examenes.Exams;
import com.cursopring.microservicios.cammons.examenes.Subject;
import com.cusrospring.microservicios.app.examenes.repository.ExamRepo;
import com.cusrospring.microservicios.app.examenes.repository.SubjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ExamServiceImpl extends CammonServiceImpl<Exams, ExamRepo> implements ExamService {

    @Autowired
    private SubjectRepo subjectRepo;

    @Override
    @Transactional(readOnly = true)
    public List<Exams> search(String name) {
       return repository.findByNameStartingWith(name);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Long> findExamsidwithAnswerByQuestionId(Iterable<Long> questionsId) {
        return repository.findExamsidwithAnswerByQuestionId(questionsId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Subject> listSubject() {
        return subjectRepo.findAll();
    }
}
