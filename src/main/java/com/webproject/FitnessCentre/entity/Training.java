package com.webproject.FitnessCentre.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Training implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private String type;

    @Column
    private int duration;

    @OneToMany(mappedBy = "training", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Appointment> appointments = new HashSet<>();

//    @JoinColumn(name = "price")
//    @OneToOne(fetch = FetchType.LAZY)
//    private Fitness price;

//    @OneToOne(cascade = CascadeType.ALL,
//            mappedBy = "fitness_timetable", orphanRemoval = true)
//    private Set<Fitness> price = new HashSet<>();


//    @OneToMany(cascade = CascadeType.ALL,
//            mappedBy = "fitness", orphanRemoval = true)
//    private Set<Hall> fitness = new HashSet<>();

}
