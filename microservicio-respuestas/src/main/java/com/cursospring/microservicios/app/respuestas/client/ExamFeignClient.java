package com.cursospring.microservicios.app.respuestas.client;

import com.cursopring.microservicios.cammons.examenes.Exams;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "microservicios-examenes")
public interface ExamFeignClient {
    @GetMapping("/find/{id}")
    public Exams findExamById(@PathVariable Long id);
}
