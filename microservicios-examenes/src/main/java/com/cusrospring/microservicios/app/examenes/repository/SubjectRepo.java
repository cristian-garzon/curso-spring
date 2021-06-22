package com.cusrospring.microservicios.app.examenes.repository;

import com.cursopring.microservicios.cammons.examenes.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepo extends JpaRepository<Subject, Long> {
}
