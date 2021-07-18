package com.cursospring.microservicios.app.respuestas.repository;

import com.cursospring.microservicios.app.respuestas.entity.Answer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface AnswerRepo extends MongoRepository<Answer, String> {


    @Query("{'studentid': ?0, 'questionId': {$in : ?1}}")
    public Iterable<Answer> findAnswerByStudentByQuestionId(Long idStudent, Iterable<Long> idQuestion);

    @Query("")
 //   @Query("select  e.id from Answer a join a.question q join q.exam e where a.studentId=?1 group by e.id")
    public Iterable<Long> findByidExamswhithAnswwerByStudent(Long idStudent);
}
