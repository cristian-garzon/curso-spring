package com.cursospring.microservicios.app.cursos.entity;

import com.cursospring.microservicios.cammons.students.entity.Student;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    @Column(name = "create_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createAt;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Student> student;

    @PrePersist
    public void date(){
        this.createAt = new Date();
    }

    public Course() {
        this.student = new ArrayList<>();
    }

    public void setStudent(List<Student> student) {
        this.student = student;
    }

    public void addStudent(Student student){
        this.student.add(student);
    }

    public void removeStudent(Student student){
       this.student.remove(student);
    }
    public List<Student> getStudent() {
        return student;
    }


    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getCreateAt() {
        return createAt;
    }


}
