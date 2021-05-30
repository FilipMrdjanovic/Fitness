package com.webproject.FitnessCentre.entity;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Trainer extends User {
    @Column
    private float grade;

    @ManyToOne(fetch = FetchType.EAGER)
    private Fitness fitness;

    @OneToMany(mappedBy = "trainer", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Appointment> appointments = new HashSet<>();

    public float getGrade() {
        return grade;
    }

    public void setGrade(float grade) {
        this.grade = grade;
    }

    public Fitness getFitness() {
        return fitness;
    }

    public void setFitness(Fitness fitness) {
        this.fitness = fitness;
    }

    public Set<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(Set<Appointment> appointments) {
        this.appointments = appointments;
    }
}
