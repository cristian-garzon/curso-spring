package com.cursospring.microservicios.app.users.testing;

import com.cursospring.microservicios.app.users.service.StudentService;
import com.cursospring.microservicios.cammons.students.entity.Student;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;


@SpringBootTest
public class userServiceTest {

    @Autowired
    private StudentService service;


    @Test
    void searchStudent() {
        assertEquals(6, ((List<Student>) service.list()).size());
    }
    @Test
    void find() {
        assertEquals("falcao", service.findById(Long.parseLong(21+"")).get().getName());
    }

    @Test
    void delete(){
        service.deleteById(Long.parseLong(21+""));
        assertEquals(5, ((List<Student>) service.list()).size());
    }
}
