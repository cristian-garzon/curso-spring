package com.cursospring.microservicios.app.cursos.repository;

import com.cursospring.microservicios.app.cursos.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.hibernate.cfg.*;
public interface CourseRepo extends JpaRepository<Course, Long> {
}
