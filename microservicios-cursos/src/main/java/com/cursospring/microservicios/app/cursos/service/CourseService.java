package com.cursospring.microservicios.app.cursos.service;

import com.cursoSpring.microservicios.cammons.service.CammonService;
import com.cursospring.microservicios.app.cursos.entity.Course;
import com.cursospring.microservicios.cammons.students.entity.Student;

import java.util.List;

public interface CourseService extends CammonService<Course> {
    public Course findByIdAlumno(Long id);
    public Course FindByIdExam(Long id);
    public Iterable<Long> listExams( Long id);
    public List<Student> listStudents (List<Long> ids);
    public void DeleteCourseStudentByStudentId(Long id);
}
