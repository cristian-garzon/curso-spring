package com.cusrospring.microservicios.app.examenes.service;

import com.cursoSpring.microservicios.cammons.service.CammonService;
import com.cursopring.microservicios.cammons.examenes.Exams;
import com.cursopring.microservicios.cammons.examenes.Subject;

import java.util.List;

public interface ExamService extends CammonService<Exams> {
    public List<Exams> search(String name);

    public List<Subject> listSubject();
}
