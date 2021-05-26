package com.webproject.FitnessCentre.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Appointment implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String date;
    @Column
    private int price;


    @ManyToMany(mappedBy = "assignedTrainings")
    private Set<Member> assigned =new HashSet<>();

    @ManyToMany(mappedBy = "completedTrainings")
    private Set<Member> completed =new HashSet<>();

    @ManyToOne(fetch = FetchType.EAGER)
    private Trainer trainer;

    @ManyToOne(fetch = FetchType.EAGER)
    private Hall hall;

    @ManyToOne(fetch = FetchType.EAGER)
    private Training training;

    @OneToMany(mappedBy = "appointment", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Grade> grade = new HashSet<>();

    public Appointment(Long id, String date, int price, Set<Member> assigned, Set<Member> completed, Trainer trainer, Hall hall, Training training, Set<Grade> grade) {
        this.id = id;
        this.date = date;
        this.price = price;
        this.assigned = assigned;
        this.completed = completed;
        this.trainer = trainer;
        this.hall = hall;
        this.training = training;
        this.grade = grade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Set<Member> getAssigned() {
        return assigned;
    }

    public void setAssigned(Set<Member> assigned) {
        this.assigned = assigned;
    }

    public Set<Member> getCompleted() {
        return completed;
    }

    public void setCompleted(Set<Member> completed) {
        this.completed = completed;
    }

    public Trainer getTrainer() {
        return trainer;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }

    public Hall getHall() {
        return hall;
    }

    public void setHall(Hall hall) {
        this.hall = hall;
    }

    public Training getTraining() {
        return training;
    }

    public void setTraining(Training training) {
        this.training = training;
    }

    public Set<Grade> getGrade() {
        return grade;
    }

    public void setGrade(Set<Grade> grade) {
        this.grade = grade;
    }
}
