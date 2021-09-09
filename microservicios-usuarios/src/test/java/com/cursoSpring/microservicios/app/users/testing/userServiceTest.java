package com.cursospring.microservicios.app.users.testing;

import com.cursospring.microservicios.app.users.service.StudentService;
import com.cursospring.microservicios.cammons.students.entity.Student;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

@Tag("userTest")
@SpringBootTest
@TestMethodOrder(MethodOrderer.class)
public class userServiceTest {

    @Autowired
    private StudentService service;


    @Test
    @Order(1)
    @DisplayName("test of user service")
    void searchStudent() {
        assertEquals(6, ((List<Student>) service.list()).size());
    }

    @Test
    void find() {
        assertTrue(service.findById(Long.parseLong(31 + "")).get().getName().equals("test1"));
    }

    @Test
    void delete() {
        service.deleteById(Long.parseLong(28 + ""));
        assertEquals(6, ((List<Student>) service.list()).size());
    }

    @Test
    @Order(2)
    void save() {
        //given
        Student student = new Student();

        // where
        student.setId(Long.parseLong(31 + ""));
        student.setName("test1");
        student.setSurname("test1");
        student.setEmail("test@gmail.com");
        student.setCreateAt(new Date());

        //then
        assertEquals(service.save(student), service.findById(Long.parseLong(31 + "")).get());
    }

    @Test
    @Order(3)
    @DisplayName("searching two names")
    void search() {
        String name = "paco";
        String surname = "garzon";
        assertAll("show by name and surname",
                () -> assertEquals(1, service.search(name).size()),
                () -> assertEquals(2, service.search(surname).size()));
    }

    @Test
    void durationSaveUser() {

        assertTimeout(Duration.ofSeconds(1), () -> {
            Student student = new Student();
            // where
            student.setId(Long.parseLong(31 + ""));
            student.setName("test1");
            student.setSurname("test1");
            student.setEmail("test@gmail.com");
            student.setCreateAt(new Date());
            service.save(student);
        });
    }


    // test with exception
    @Test
    @DisplayName("test of exceptions")
    void exceptions() {
        assertThrows(NoSuchElementException.class, () -> service.findById(Long.parseLong(25 + "")).get());
    }


    // test with parameters null and empty
    @ParameterizedTest
    @NullSource
    @EmptySource
    @NullAndEmptySource
    void nullSource(String test) {
        assertTrue(test == null || test.trim().isEmpty());
    }


    @ParameterizedTest
    //test with parameter in a method
    @MethodSource("method")
    void methodTest(String test) {
        //if test not null, the test is true
        assertNotNull(test);
    }


    // method for test with method
    // IMPORTANT the methos must be static
    static List<String> method() {
        List<String> test = new ArrayList<>();
        test.add("test1");
        test.add("test2");
        return test;
    }


    // test with arguments in the notation
    @ParameterizedTest
    @CsvSource({"renaul, apple,  1",
            "chevrolet, pear, 2"
    })
    void testWithArguments(String car, String fruit, int rank) {
        assertNotNull(car);
        assertNotEquals(0, rank);
        assertNotNull(fruit);
    }
}