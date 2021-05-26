package com.webproject.FitnessCentre.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
public class Fitness implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String address;

    @Column
    private String centralNumber;

    @Column
    private String email;

    @OneToMany(mappedBy = "fitness", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Trainer> trainers = new HashSet<>();

    @OneToMany(mappedBy = "fitness", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Hall> halls = new HashSet<>();

    public Fitness(Long id, String name, String address, String centralNumber, String email, Set<Trainer> trainers, Set<Hall> halls) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.centralNumber = centralNumber;
        this.email = email;
        this.trainers = trainers;
        this.halls = halls;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCentralNumber() {
        return centralNumber;
    }

    public void setCentralNumber(String centralNumber) {
        this.centralNumber = centralNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Trainer> getTrainers() {
        return trainers;
    }

    public void setTrainers(Set<Trainer> trainers) {
        this.trainers = trainers;
    }

    public Set<Hall> getHalls() {
        return halls;
    }

    public void setHalls(Set<Hall> halls) {
        this.halls = halls;
    }
}
