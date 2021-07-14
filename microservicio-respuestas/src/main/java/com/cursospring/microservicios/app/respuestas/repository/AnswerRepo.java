package com.cursospring.microservicios.app.respuestas.repository;

import com.cursospring.microservicios.app.respuestas.entity.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AnswerRepo extends JpaRepository<Answer, Long> {

    @Query("select a from Answer a join fetch a.question q join fetch q.exam e where a.studentId=?1 and e.id=?2")
    public Iterable<Answer> findAnswerByStudentByExam(Long idStudent, Long idExam);

    @Query("select  e.id from Answer a join a.question q join q.exam e where a.studentId=?1 group by e.id")
    public Iterable<Long> findByidExamswhithAnswwerByStudent(Long idStudent);
}
