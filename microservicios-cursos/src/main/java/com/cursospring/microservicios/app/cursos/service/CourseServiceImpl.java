package com.cursospring.microservicios.app.cursos.service;

import com.cursoSpring.microservicios.cammons.service.CammonServiceImpl;
import com.cursospring.microservicios.app.cursos.client.AnwerFeingClient;
import com.cursospring.microservicios.app.cursos.client.StudentFeingClient;
import com.cursospring.microservicios.app.cursos.entity.Course;
import com.cursospring.microservicios.app.cursos.repository.CourseRepo;
import com.cursospring.microservicios.cammons.students.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.plaf.synth.SynthToolTipUI;
import java.util.List;

@Service
public class CourseServiceImpl extends CammonServiceImpl<Course, CourseRepo> implements CourseService{

    @Autowired
    private AnwerFeingClient anwerFeingClient;

    @Autowired
    private StudentFeingClient studentFeingClient;

    @Override
    @Transactional(readOnly = true)
    public Course findByIdAlumno(Long id) {
        return repository.findByIdAlumno(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Course FindByIdExam(Long id) {
        return repository.findByIdExam(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Long> listExams(Long id) {
        return anwerFeingClient.listExams(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Student> listStudents(List<Long> ids) {
        return studentFeingClient.listStudents(ids);
    }

    @Override
    public void DeleteCourseStudentByStudentId(Long id) {
        repository.DeleteCourseStudentByStudentId(id);
    }


}
