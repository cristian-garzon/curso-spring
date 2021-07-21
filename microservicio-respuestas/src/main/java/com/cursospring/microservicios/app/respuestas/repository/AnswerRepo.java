package com.cursospring.microservicios.app.respuestas.repository;

import com.cursospring.microservicios.app.respuestas.entity.Answer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerRepo extends MongoRepository<Answer, String> {


    @Query("{'studentId': ?0, 'questionId': {$in : ?1}}")
    public Iterable<Answer> findAnswerByStudentByQuestionId(Long idStudent, Iterable<Long> idQuestion);

    public Iterable<Answer> findAnswerByStudentId(Long stundentId);


}
