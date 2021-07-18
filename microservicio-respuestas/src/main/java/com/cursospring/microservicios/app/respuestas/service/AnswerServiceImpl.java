package com.cursospring.microservicios.app.respuestas.service;

import com.cursopring.microservicios.cammons.examenes.Exams;
import com.cursospring.microservicios.app.respuestas.client.ExamFeignClient;
import com.cursospring.microservicios.app.respuestas.entity.Answer;
import com.cursospring.microservicios.app.respuestas.repository.AnswerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AnswerServiceImpl implements AnswerService{

    @Autowired
    private AnswerRepo repository;

    @Autowired
    private ExamFeignClient examFeignClient;

    @Override
    public Iterable<Answer> saveAll(Iterable<Answer> answers) {
               return repository.saveAll(answers);
    }

    @Override
    public Iterable<Answer> findAnswerByStudentByQuestion(Long idStudent, Long idExam) {
        Exams exam = examFeignClient.findExamById(idExam);
        Iterable<Long> idsQuestions= exam.getQuestions().stream().map(questions -> questions.getId()).collect(Collectors.toList());
        List<Answer> answers = (List<Answer>) repository.findAnswerByStudentByQuestionId(idStudent, idsQuestions);
        answers.stream().map(answer -> {
           exam.getQuestions().forEach(question -> {
                if(question.getId() == answer.getQuestionId()) answer.setQuestion(question);
           });
           return answer;
        });
        return answers;
    }

    @Override
    public Iterable<Long> findByidExamswhithAnswwerByStudent(Long idStudent) {
        return repository.findByidExamswhithAnswwerByStudent(idStudent);
    }
}
