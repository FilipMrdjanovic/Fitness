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
}
