package com.cursoSpring.microservicios.app.users.repository;

import com.cursoSpring.microservicios.app.users.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student, Long> {
}
