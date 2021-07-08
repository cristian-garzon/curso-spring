package com.cursospring.microservicios.app.cursos.client;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "microservicios-respuestas")
public interface AnwerFeingClient {
    @GetMapping("list_exams/{id}")
    public Iterable<Long> listExams(@PathVariable Long id);
}
