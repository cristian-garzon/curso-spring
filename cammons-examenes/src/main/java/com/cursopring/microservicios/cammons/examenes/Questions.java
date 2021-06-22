package com.cursopring.microservicios.cammons.examenes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
public class Questions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String text;

    @JsonIgnoreProperties(value = {"questions"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "exam_id")
    private Exams exam;

    public void setId(Long id) {
        this.id = id;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Long getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public Exams getExam() {
        return exam;
    }

    public void setExam(Exams exam) {
        this.exam = exam;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Questions)) return false;
        Questions questions = (Questions) o;
        return this.id != null && this.id.equals(questions.getId());
    }


}
