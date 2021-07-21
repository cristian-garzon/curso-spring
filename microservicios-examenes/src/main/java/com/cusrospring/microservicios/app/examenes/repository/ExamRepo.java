package com.cusrospring.microservicios.app.examenes.repository;

import com.cursopring.microservicios.cammons.examenes.Exams;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface ExamRepo extends PagingAndSortingRepository<Exams, Long> {
    public List<Exams> findByNameStartingWith(String name);
    @Query("select  e.id from Questions q join q.exam e where q.id in ?1 group by e.id")
    public Iterable<Long> findExamsidwithAnswerByQuestionId(Iterable<Long> questionsId);
}
