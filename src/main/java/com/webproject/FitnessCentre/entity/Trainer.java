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




//    @OneToMany(cascade = CascadeType.ALL,
//            mappedBy = "fitness", orphanRemoval = true)
//    private Set<Trainer> fitness = new HashSet<>();

}
