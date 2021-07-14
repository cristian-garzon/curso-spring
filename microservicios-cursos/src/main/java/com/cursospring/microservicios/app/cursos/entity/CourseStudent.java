package com.cursospring.microservicios.app.cursos.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "course_student")
public class CourseStudent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_student", unique = true)
    private Long studentId;

    @JsonIgnoreProperties(value = {"courseStudents"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_course")
    private Course course;


    public void setId(Long id) {
        this.id = id;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Long getId() {
        return id;
    }

    public Long getStudentId() {
        return studentId;
    }

    public Course getCourse() {
        return course;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CourseStudent)) return false;
        CourseStudent courseStudent = (CourseStudent) o;
        return this.studentId != null && this.studentId.equals(courseStudent.getStudentId());
    }
}

