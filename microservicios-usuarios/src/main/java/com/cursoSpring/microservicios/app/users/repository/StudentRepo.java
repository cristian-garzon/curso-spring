package com.cursoSpring.microservicios.app.users.repository;


import com.cursospring.microservicios.cammons.students.entity.Student;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface StudentRepo extends PagingAndSortingRepository<Student, Long> {
    public List<Student> findByNameStartingWithOrSurnameStartingWith(String name, String surname);
}
