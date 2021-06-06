package com.cursoSpring.microservicios.app.users.repository;


import com.cursospring.microservicios.cammons.students.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepo extends JpaRepository<Student, Long> {
    public List<Student> findByNameStartingWithOrSurnameStartingWith(String name, String surname);
}
