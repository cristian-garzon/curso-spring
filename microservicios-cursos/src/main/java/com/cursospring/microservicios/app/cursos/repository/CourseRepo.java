package com.cursospring.microservicios.app.cursos.repository;

import com.cursospring.microservicios.app.cursos.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CourseRepo extends JpaRepository<Course, Long> {
    @Query("select c from Course c  join fetch c.student s where s.id=?1")
    public Course findByIdAlumno(Long id);

    @Query("select c from Course c join fetch c.exam e where e.id=?1")
    public Course findByIdExam(Long id);
}
