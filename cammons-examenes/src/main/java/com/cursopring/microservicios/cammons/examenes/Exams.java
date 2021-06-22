package com.cursopring.microservicios.cammons.examenes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
public class Exams {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(name = "create_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createAt;

    @JsonIgnoreProperties(value = {"exam"}, allowSetters = true)
    @OneToMany(mappedBy = "exam", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Questions> questions;

    @ManyToOne(fetch = FetchType.LAZY)
    private Subject subject;

    public Exams(){
        this.questions = new ArrayList<>();
    }



    @PrePersist
    public void date(){
        this.createAt = new Date();
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setQuestions(List<Questions> questions) {
        this.questions.clear();
        for (Questions question: questions) this.addQuestions(question);
    }
    public void addQuestions(Questions question) {
        this.questions.add(question);
        question.setExam(this);
    }
    public void removeQuestions(Questions question) {
        this.questions.remove(question);
        question.setExam(null);
    }
    public List<Questions> getQuestions() {
        return questions;
    }

    public Date getCreateAt() {
        return createAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o instanceof Exams ) return false;
        Exams exams = (Exams) o;
        return this.id != null && this.id.equals(exams.getId());
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }
}
