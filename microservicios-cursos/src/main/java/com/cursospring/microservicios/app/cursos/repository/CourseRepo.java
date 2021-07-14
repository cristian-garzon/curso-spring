package com.cursospring.microservicios.app.cursos.repository;

import com.cursospring.microservicios.app.cursos.entity.Course;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CourseRepo extends PagingAndSortingRepository<Course, Long> {
    @Query("select c from Course c  join fetch c.courseStudents cs where cs.studentId=?1")
    public Course findByIdAlumno(Long id);

    @Query("select c from Course c join fetch c.exam e where e.id=?1")
    public Course findByIdExam(Long id);

    @Modifying
    @Query("delete from CourseStudent cs where cs.studentId=?1")
    public void DeleteCourseStudentByStudentId(Long id);
}
