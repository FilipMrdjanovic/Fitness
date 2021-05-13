package com.webproject.FitnessCentre.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Hall implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private int capacity;

    @OneToMany(cascade = CascadeType.ALL,
            mappedBy = "fitness", orphanRemoval = true)
    private Set<Hall> fitness = new HashSet<>();


    @OneToMany
    @JoinTable(name = "HALL_TIMETABLE",
            joinColumns = {@JoinColumn(name = "training_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "price_id", referencedColumnName = "id")})
    private Set<Hall> timetable = new HashSet<>();

}
