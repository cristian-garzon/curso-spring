package com.cursoSpring.microservicios.app.users.service;


import com.cursoSpring.microservicios.app.users.entity.Student;
import com.cursoSpring.microservicios.app.users.repository.StudentRepo;
import com.cursoSpring.microservicios.cammons.service.CammonServiceImpl;
import org.springframework.stereotype.Service;


@Service
public class StudentServiceImpl extends CammonServiceImpl<Student, StudentRepo> implements StudentService {



}
