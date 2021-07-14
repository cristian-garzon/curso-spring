package com.cursoSpring.microservicios.app.users.repository;


import com.cursospring.microservicios.cammons.students.entity.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface StudentRepo extends PagingAndSortingRepository<Student, Long> {
    @Query("select s from Student s where upper(s.name) like upper(concat('%', ?1, '%')) or upper(s.surname) like  upper(concat('%', ?1, '%'))")
    public List<Student> findByNameStartingWithOrSurnameStartingWith(String name);
}
