package com.cursopring.microservicios.cammons.examenes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @JsonIgnoreProperties(value = {"son"})
    @ManyToOne(fetch = FetchType.LAZY)
    private Subject father;

    @JsonIgnoreProperties(value = {"father"}, allowSetters = true)
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "father", cascade = CascadeType.ALL )
    private List<Subject> son;

    public Subject(){
        this.son = new ArrayList<>();
    }
    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public Subject getFather() {
        return father;
    }

    public List<Subject> getSon() {
        return son;
    }

    public void setFather(Subject father) {
        this.father = father;
    }

    public void setSon(List<Subject> son) {
        this.son = son;
    }

    public String getName() {
        return name;
    }
}
