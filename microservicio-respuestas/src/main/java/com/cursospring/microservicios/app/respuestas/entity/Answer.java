package com.cursospring.microservicios.app.respuestas.entity;

import com.cursopring.microservicios.cammons.examenes.Questions;
import com.cursospring.microservicios.cammons.students.entity.Student;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "answers")
public class Answer {



    @Id
    private String id;


    private String answer;

    @Transient
    private Student student;

    private  Long studentId;


    @Transient
    private Questions question;

    private Long questionId;

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getId() {
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
