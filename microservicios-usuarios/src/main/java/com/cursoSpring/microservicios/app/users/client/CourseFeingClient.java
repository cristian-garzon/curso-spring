package com.cursospring.microservicios.app.users.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "microservicios-cursos")
public interface CourseFeingClient {
    @DeleteMapping("/delete_course_student/{id}")
    public ResponseEntity<?> deleteCourseStudent(@PathVariable Long id);
}
