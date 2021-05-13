package com.webproject.FitnessCentre.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Trainer extends User {

    @ManyToOne(targetEntity = com.webproject.FitnessCentre.entity.Training.class)
    @JoinColumn(name="training", nullable=true)
    private Set<Training> training = new HashSet<>();

    @ManyToOne(targetEntity = com.webproject.FitnessCentre.entity.Training.class)
    @JoinColumn(name="rating", nullable=true)
    private int rating;




    @OneToMany(cascade = CascadeType.ALL,
            mappedBy = "fitness", orphanRemoval = true)
    private Set<Trainer> fitness = new HashSet<>();

}
