package com.webproject.FitnessCentre.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Member extends User {

    @ManyToOne(targetEntity = com.webproject.FitnessCentre.entity.Training.class)
    @JoinColumn(name="completed_training", nullable=true)
    private Set<Training> completedTraining = new HashSet<>();

    @ManyToOne(targetEntity = com.webproject.FitnessCentre.entity.Training.class)
    @JoinColumn(name="signed_training", nullable=true)
    private Set<Training> signedTraining = new HashSet<>();

    @ManyToOne(targetEntity = com.webproject.FitnessCentre.entity.Training.class)
    @JoinColumn(name="rated_training", nullable=true)
    private Set<Training> ratedTraining = new HashSet<>();

}
