package com.cursospring.microservicios.app.respuestas.entity;

import com.cursopring.microservicios.cammons.examenes.Questions;
import com.cursospring.microservicios.cammons.students.entity.Student;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @NotNull
    private String answer;

    @Transient
    private Student student;

    @Column(name = "id_student")
    private  Long studentId;

    @OneToOne(fetch = FetchType.LAZY)
    private Questions question;

    public void setId(Long id) {
        this.id = id;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Long getId() {
        return id;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public void setQuestion(Questions question) {
        this.question = question;
    }

    public Student getStudent() {
        return student;
    }

    public Questions getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Long getStudentId() {
        return studentId;
    }
}
