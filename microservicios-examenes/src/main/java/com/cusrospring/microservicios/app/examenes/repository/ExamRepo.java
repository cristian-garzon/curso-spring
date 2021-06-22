package com.cusrospring.microservicios.app.examenes.repository;

import com.cursopring.microservicios.cammons.examenes.Exams;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExamRepo extends JpaRepository<Exams, Long> {
    public List<Exams> findByNameStartingWith(String name);
}
